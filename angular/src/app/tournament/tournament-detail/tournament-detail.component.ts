import { Component, OnInit, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import * as moment from 'moment'
import { NgttTournament } from "src/app/utility/ngtt-double-elimination-tree/ngtt-double-elimination-tree.model";
import { TournamentSeriesResponse, TournamentDetailResponse, BracketSeriesResponse, RoundRoibinSeriesResponse, TournamentTeamResponse } from "../tournament.response.model";
import { TournamentService } from "../tournament.service";
import { RoundSeriesWeekly } from "../tournament.view.model";
import { SeriesComponent } from "./series/series.component";
import { PlayerParticipantResponse, TeamParticipant } from "./tournament-detail.view.model";

@Component({
  selector: 'app-tournament-detail',
  templateUrl: './tournament-detail.component.html',
  styleUrls: ['./tournament-detail.component.css']
})
export class TournamentDetailComponent implements OnInit {

  public tournament: TournamentDetailResponse;
  public columnSeed: boolean = false;
  public columnDpc: boolean = false;
  public roundSeries: RoundSeriesWeekly[];
  public tournamentData: NgttTournament;
  public teams: TeamParticipant[];
  public tournamentTeams: TournamentTeamResponse[];
  public seriesId: number;
  @ViewChild(SeriesComponent) childSeries: SeriesComponent;

  constructor(private activatedRoute: ActivatedRoute,
    private tournamentService: TournamentService,
    private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((param: any) => {
      this.tournamentService.getTournamentDetail(param.tournamentId)
        .subscribe((response: TournamentDetailResponse) => {
          this.tournament = response;

          this.columnSeed = false;
          this.columnDpc = false;

          this.tournamentService.getTeamParticipant(this.tournament.id)
            .subscribe((response) => {
                this.tournamentTeams = response;
                this.tournamentTeams.forEach((team) => {
                  if (team.seed) {
                    this.columnSeed = true;
                  }
                  if (team.dpcPoints > 0) {
                    this.columnDpc = true;
                  }
                });
            });

          if ("ROUND_ROBIN" === response.tournamentType) {
            this.tournamentService.getRoundRobinSeries(this.tournament.id)
              .subscribe((response) => {
                this.initRoundRobinSeries(response);
              });
          } else if ("BRACKET" === response.tournamentType) {
            this.tournamentService.getBracketSeries(this.tournament.id)
              .subscribe((response) => {
                this.initBracketSeries(response);
              });
          }
        });

      this.tournamentService.getPlayerParticipant(param.tournamentId)
        .subscribe((response: PlayerParticipantResponse[]) => {
          this.teams = [];

          response.forEach((player) => {
            const team = this.teams.find((t) => t.teamId == player.teamId);
            const p = {
              playerId: player.playerId,
              playerNickName: player.playerNickName,
              roleId: player.roleId,
              roleName: player.roleName
            };
            if (!team) {
              this.teams.push({
                teamId: player.teamId,
                teamName: player.teamName,
                players: [p],

                showImage: true
              });
            } else {
              team.players.push(p);
            }
          });
        });

    });
  }
  
  private initRoundRobinSeries(roundRobinSeries: RoundRoibinSeriesResponse[]): void {
    roundRobinSeries.sort((ta, tb) => {
      return ta.startDate - tb.startDate;
    });

    this.roundSeries = [];
    let lastWeek = 0;
    let lastDay = 0;
    let lastMd = "";
    roundRobinSeries.forEach((series) => {
      const md = moment(series.startDate, 'x').format('MMMM DD');
      if (lastWeek != series.weekIndex) {
        var weekIndex = this.roundSeries.length
        const roundSeriesWeekly: RoundSeriesWeekly = {
          index: weekIndex,
          name: "Week " + (weekIndex + 1),
          roundSeriesDaily: [
            {
              index: 0,
              name: md,
              series: [
                series
              ]
            }
          ]
        };
        this.roundSeries.push(roundSeriesWeekly);
        lastWeek++;
        lastDay = 0;
        lastMd = md;
      } else {
        if (md === lastMd) {
          this.roundSeries[lastWeek - 1].roundSeriesDaily[lastDay].series.push(series);
        } else {
          lastDay++;
          this.roundSeries[lastWeek - 1].roundSeriesDaily.push(              {
            index: 0,
            name: md,
            series: [
              series
            ]
          })
        }
        lastMd = md;
      }
    });
  }

  private initBracketSeries(bracketSeries: BracketSeriesResponse[]): void {
    
    this.tournamentData = {
      rounds: []
    };

    let lastBracketRound = -1;
    let lastRoundsIndex = -1;

    bracketSeries.filter((series) => {
      return series.bracketPosition === "UPPER";
    })
    .sort(this.sortingBracketSeries)
    .forEach((series, index) => {
      if (0 === index) {
        lastRoundsIndex++;
        lastBracketRound = series.bracketRound;
        this.tournamentData.rounds.push({
          type: "Winnerbracket",
          matches: [series]
        });
      } else if (lastBracketRound === series.bracketRound) {
        this.tournamentData.rounds[lastRoundsIndex].matches.push(series);
      } else {
        lastRoundsIndex++;
        lastBracketRound = series.bracketRound;
        this.tournamentData.rounds.push({
          type: "Winnerbracket",
          matches: [series]
        });
      }
    });

    bracketSeries.filter((series) => {
      return series.bracketPosition === "LOWER";
    })
    .sort(this.sortingBracketSeries)
    .forEach((series, index) => {
      if (0 === index) {
        lastRoundsIndex++;
        lastBracketRound = series.bracketRound;
        this.tournamentData.rounds.push({
          type: "Loserbracket",
          matches: [series]
        });
      } else if (lastBracketRound === series.bracketRound) {
        this.tournamentData.rounds[lastRoundsIndex].matches.push(series);
      } else {
        lastRoundsIndex++;
        lastBracketRound = series.bracketRound;
        this.tournamentData.rounds.push({
          type: "Loserbracket",
          matches: [series]
        });
      }
    });

    const finalSeries = bracketSeries.find((series) => {
      return series.bracketPosition === "FINAL";
    });
    if (finalSeries) {
      this.tournamentData.rounds.push({
        type: "Final",
        matches: [
          finalSeries
        ]
      });
    }
  }

  private sortingBracketSeries(a: BracketSeriesResponse, b: BracketSeriesResponse): number {
    return ((a.bracketRound * 10) + a.roundIndex) - ((b.bracketRound * 10) + b.roundIndex);
  }

  public back(): void {
    this.router.navigate(['/tournament', {}]);
  }

  public openSeries(series: TournamentSeriesResponse): void {
    if (series.teamAScore || series.teamBScore) {
      this.seriesId = series.seriesId;
      this.childSeries.open(series.seriesId);
    }
  }

  public teamMouseover(team: TeamParticipant): void {
    team.showImage = false;
  }
  public teamMouseLeave(team: TeamParticipant): void {
    team.showImage = true;
  }
}