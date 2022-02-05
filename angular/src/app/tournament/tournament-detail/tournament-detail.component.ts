import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import * as moment from 'moment'
import { NgttTournament } from "src/app/utility/ngtt-double-elimination-tree/ngtt-double-elimination-tree.model";
import { TournamentDetailResponse } from "../tournament.response.model";
import { TournamentService } from "../tournament.service";
import { RoundSeriesWeekly } from "../tournament.view.model";

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
    public doubleEliminationTournament: NgttTournament;

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
          });
      });

      this.doubleEliminationTournament = {
        rounds: [
          {
            type: 'Winnerbracket',
            matches: [
              {
                teams: [{name: 'Team  A', score: 1}, {name: 'Team  B', score: 2}]
              },
              {
                teams: [{name: 'Team  C', score: 1}, {name: 'Team  D', score: 2}]
              },
              {
                teams: [{name: 'Team  E', score: 1}, {name: 'Team  F', score: 2}]
              },
              {
                teams: [{name: 'Team  G', score: 1}, {name: 'Team  H', score: 2}]
              }
            ]
          },
          {
            type: 'Winnerbracket',
            matches: [
              {
                teams: [{name: 'Team  B', score: 1}, {name: 'Team  D', score: 2}]
              },
              {
                teams: [{name: 'Team  F', score: 1}, {name: 'Team  H', score: 2}]
              }
            ]
          },
          {
            type: 'Winnerbracket',
            matches: [
              {
                teams: [{name: 'Team  D', score: 1}, {name: 'Team  H', score: 2}]
              }
            ]
          },
          {
            type: 'Loserbracket',
            matches: [
              {
                teams: [{name: 'Team  A', score: 1}, {name: 'Team  C', score: 2}]
              },
              {
                teams: [{name: 'Team  E', score: 1}, {name: 'Team  G', score: 2}]
              }
            ]
          },
          {
            type: 'Loserbracket',
            matches: [
              {
                teams: [{name: 'Team  C', score: 1}, {name: 'Team  B', score: 2}]
              },
              {
                teams: [{name: 'Team  G', score: 1}, {name: 'Team  F', score: 2}]
              }
            ]
          },
          {
            type: 'Loserbracket',
            matches: [
              {
                teams: [{name: 'Team  B', score: 1}, {name: 'Team  F', score: 2}]
              }
            ]
          },
          {
            type: 'Loserbracket',
            matches: [
              {
                teams: [{name: 'Team  D', score: 1}, {name: 'Team  F', score: 2}]
              }
            ]
          },
          {
            type: 'Final',
            matches: [
              {
                teams: [
                  {
                    name: 'Team  H',
                    score: 1
                  },
                  {
                    name: 'Team  F',
                    score: 2
                  }
                ]
              }
            ]
          }
        ]
      };
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

      console.log(this.roundSeries)
    }

    public back(): void {
      this.router.navigate(['/tournament', {}]);
    }
  }