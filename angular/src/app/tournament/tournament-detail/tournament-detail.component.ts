import { Component, OnInit, Optional } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { MatDialog } from '@angular/material/dialog';
import * as moment from 'moment'
import { NgttTournament } from "src/app/utility/ngtt-double-elimination-tree/ngtt-double-elimination-tree.model";
import { TournamentSeriesResponse, TournamentBracketResponse, TournamentDetailResponse } from "../tournament.response.model";
import { TournamentService } from "../tournament.service";
import { RoundSeriesWeekly } from "../tournament.view.model";
import { SeriesComponent } from "./series/series.component";

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

    constructor(private activatedRoute: ActivatedRoute,
      private tournamentService: TournamentService,
      private router: Router,
      @Optional() public dialog: MatDialog) {
    }

    ngOnInit(): void {
      this.activatedRoute.params.subscribe((param: any) => {
        this.tournamentService.getTournamentDetail(param.tournamentId)
          .subscribe((response: TournamentDetailResponse) => {
            this.tournament = response;

            this.columnSeed = false;
            this.columnDpc = false;
            this.tournament.teams.forEach((team) => {
              if (team.seed) {
                this.columnSeed = true;
              }
              if (team.dpcPoints > 0) {
                this.columnDpc = true;
              }
            });

            if (response.roundRobinSeries) {
              this.initRoundRobinSeries(response);
            }
            if (response.bracketSeries) {
              this.initBracketSeries(response) 
            }
          });
      });
    }

    private initRoundRobinSeries(response: TournamentDetailResponse): void {
      response.roundRobinSeries.sort((ta, tb) => {
        return ta.startDate - tb.startDate;
      });

      this.roundSeries = [];
      let lastWeek = 0;
      let lastDay = 0;
      let lastMd = "";
      response.roundRobinSeries.forEach((series) => {
        const date = new Date(series.startDate);
        const md = moment(series.startDate).format('MMMM DD');
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

    private initBracketSeries(response: TournamentDetailResponse): void {
      
      this.tournamentData = {
        rounds: []
      };

      let lastBracketRound = -1;
      let lastRoundsIndex = -1;

      response.bracketSeries.filter((series) => {
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

      response.bracketSeries.filter((series) => {
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

      const finalSeries = response.bracketSeries.find((series) => {
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

    private sortingBracketSeries(a: TournamentBracketResponse, b: TournamentBracketResponse): number {
      return ((a.bracketRound * 10) + a.roundIndex) - ((b.bracketRound * 10) + b.roundIndex);
    }

    public back(): void {
      this.router.navigate(['/tournament', {}]);
    }

    public openSeries(series: TournamentSeriesResponse): void {
      if (series.teamAScore || series.teamBScore) {
        this.dialog
          .open(SeriesComponent, { width: '100%', data: { seriesId: series.seriesId } })
          .afterClosed().subscribe(result => {});
      }
    }
  }