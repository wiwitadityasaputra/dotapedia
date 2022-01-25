import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
    selector: 'app-tournament-detail',
    templateUrl: './tournament-detail.component.html',
    styleUrls: ['./tournament-detail.component.css']
  })
  export class TournamentDetailComponent implements OnInit {

    constructor(private activatedRoute: ActivatedRoute) {
    }

    ngOnInit(): void {
      this.activatedRoute.params.subscribe((param: any) => {
        console.log(param.tournamentId)
      })
    }
  }