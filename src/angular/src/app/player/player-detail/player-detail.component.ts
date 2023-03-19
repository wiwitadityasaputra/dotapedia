import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { SlideShowService } from "src/app/utility/slide-show/slide-show.service";
import { SlideShowView } from "src/app/utility/slide-show/slide-show.view.model";
import { PlayerDetailResponse, PlayerQuoteResponse, PlayerScreenshotResponse } from "../player.response.model";
import { PlayerService } from "../player.service";

@Component({
    selector: 'app-player-detail',
    templateUrl: './player-detail.component.html',
    styleUrls: ['./player-detail.component.css']
})
export class PlayerDetailComponent implements OnInit {

    public player: PlayerDetailResponse;
    public quote: PlayerQuoteResponse;
    public biographies: string[];

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
                    if (this.player.biography) {
                        this.biographies = this.player.biography.split("\n");
                    }

                    if (this.player.quotes.length > 0) {
                        this.quote = this.player.quotes[0];
                    }
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

        this.slideShowService.show(data);
    }

    public changeQuote(next: number): void {
        const quotes = this.player.quotes;
        const currentIndex = quotes.findIndex((q) => {
            return q.content == this.quote.content && q.author == this.quote.author;
        });

        let nextIndex = currentIndex + next;
        if (nextIndex < 0) {
            nextIndex = quotes.length -1;
        }
        if (nextIndex >= quotes.length) {
            nextIndex = 0;
        }
        this.quote = this.player.quotes[nextIndex];
    }
}