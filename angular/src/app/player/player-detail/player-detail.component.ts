import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { SlideShowService } from "src/app/utility/slide-show/slide-show.service";
import { SlideShowView } from "src/app/utility/slide-show/slide-show.view.model";
import { PlayerDetailResponse, PlayerScreenshotResponse } from "../player.response.model";
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
        private playerService: PlayerService,
        private slideShowService: SlideShowService) {
    }

    ngOnInit(): void {
        this.activatedRoute.params.subscribe((param: any) => {
            const playerId = param.playerId;
            this.playerService.getPlayerById(playerId)
                .subscribe((player: PlayerDetailResponse) => {
                    this.player = player;
                });
        });
    }

    public selectScreenShoot(index: number, ss: PlayerScreenshotResponse): void {
        window.scrollTo({ top: 0, behavior: 'smooth' });

        const imageSrcs: string[] = [];
        this.player.playerScreenshots.forEach(ss => {
            imageSrcs.push("assets/image/player-screenshots/" + ss.imageName);
        });

        let data: SlideShowView = {
            selected: index,
            imageSrcs: imageSrcs
        };

        this.slideShowService.product.next(data);
    }
}