import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { TournamentDetailResponse } from "../tournament.response.model";
import { TournamentService } from "../tournament.service";

@Component({
    selector: 'app-tournament-detail',
    templateUrl: './tournament-detail.component.html',
    styleUrls: ['./tournament-detail.component.css']
  })
  export class TournamentDetailComponent implements OnInit {

    public tournament: TournamentDetailResponse;
    public columnSeed: boolean = false;
    public columnDpc: boolean = false;

    constructor(private activatedRoute: ActivatedRoute,
      private tournamentService: TournamentService,
      private router: Router) {
    }

    ngOnInit(): void {
      this.activatedRoute.params.subscribe((param: any) => {
        this.tournamentService.getTournamentDetail(param.tournamentId)
          .subscribe((response: TournamentDetailResponse) => {
            this.tournament = response;
            console.log(response)

            this.columnSeed = false;
            this.tournament.teams.forEach((team) => {
              if (team.seed) {
                this.columnSeed = true;
              }
              if (team.dpcPoints > 0) {
                this.columnDpc = true;
              }
            });
          });
      });
    }

    public back(): void {
      this.router.navigate(['/tournament', {}]);
    }
  }