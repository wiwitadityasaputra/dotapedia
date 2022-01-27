import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { TournamentService } from "../tournament.service";
import { TournamentResponse } from "./model/tournament-detail.model";

@Component({
    selector: 'app-tournament-detail',
    templateUrl: './tournament-detail.component.html',
    styleUrls: ['./tournament-detail.component.css']
  })
  export class TournamentDetailComponent implements OnInit {

    constructor(private activatedRoute: ActivatedRoute,
      private tournamentService: TournamentService) {
    }

    ngOnInit(): void {
      this.activatedRoute.params.subscribe((param: any) => {
        this.tournamentService.getTournamentDetail(param.tournamentId)
          .subscribe((response: TournamentResponse) => {
            console.log(response)
          });
      });
    }
  }