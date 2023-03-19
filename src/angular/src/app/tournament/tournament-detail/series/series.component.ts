import { Component, Inject, Input, OnInit, ViewChild } from "@angular/core";
import * as moment from "moment";
import { GameResponse, SeriesResponse } from "./series.response.model";
import { SeriesService } from "./series.service";

@Component({
    selector: 'app-series',
    templateUrl: './series.component.html',
    styleUrls: ['./series.component.css']
  })
  export class SeriesComponent implements OnInit {
    public showSeries: boolean = false;
    public showLoading: boolean = true;
    public stickOnTop: boolean = false;
    private modalClick: boolean = false;
    public series: SeriesResponse;
    public displayedColumns: string[] = ['player', 'role', 'hero', 'k', 'd', 'a', 'gpm', 'xpm', 'dmghero', 'dmgbuilding', 'healing'];

    constructor(
      private seriesService: SeriesService) {
    }

    ngOnInit(): void {
      this.seriesService.getObservable().subscribe((seriesId: number) => {
        if (!Number.isNaN(Number(seriesId))) {
          this.open(seriesId);
        }
      });
    }

    close() {
      if (this.modalClick) {
        this.modalClick = false;
      } else {
        this.showSeries = false;
      }
    }

    open(seriesId: number) {
      this.showSeries = true;
      this.showLoading = true;
      this.seriesService.getSeries(seriesId)
        .subscribe((response: SeriesResponse) => {
          this.showLoading = false;
          this.series = response;
          this.series.games.forEach(g => {
            g.radiantPlayers.sort((a, b) => { return a.roleId - b.roleId; });
            g.direPlayers.sort((a, b) => { return a.roleId - b.roleId; });

            g.startDateStr = moment(g.startDate).format('YYYY, MMMM DD');
            g.isShow = false;
          });
        });
    }

    dialogClick() {
      this.modalClick = true;
    }

    toggleGame(game: GameResponse) {
      game.isShow = !game.isShow;
      this.series.games.forEach(g => {
        if (g.gameId != game.gameId) {
          g.isShow = false;
        }
      });

      this.stickOnTop = false;
      this.series.games.forEach(g => {
        if (g.isShow) {
          this.stickOnTop = true;
        }
      });
    }
  }