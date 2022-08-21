import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Player, PlayerDetailResponse } from "../player.response.model";
import { PlayerService } from "../player.service";

@Component({
    selector: 'app-player-detail',
    templateUrl: './player-detail.component.html',
    styleUrls: ['./player-detail.component.css']
})
export class PlayerDetailComponent implements OnInit {

    public player: PlayerDetailResponse;

    constructor(private router: Router,
        private activatedRoute: ActivatedRoute,
        private playerService: PlayerService) {
    }

    ngOnInit(): void {
        this.activatedRoute.params.subscribe((param: any) => {
            const playerId = param.playerId;
            this.playerService.getPlayerById(playerId)
                .subscribe((player: PlayerDetailResponse) => {
                    this.player = player;
                    console.log("this.player ", this.player);
                });
        });
    }
}