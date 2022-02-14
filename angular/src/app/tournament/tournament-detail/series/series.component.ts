import { Component, Inject, OnInit } from "@angular/core";
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import * as moment from "moment";
import { SeriesResponse } from "./series.response.model";
import { SeriesService } from "./series.service";
import { SeriesComponentInput } from "./series.view.model";

@Component({
    selector: 'app-series',
    templateUrl: './series.component.html',
    styleUrls: ['./series.component.css']
  })
  export class SeriesComponent implements OnInit {

    public showLoading: boolean = true;
    public series: SeriesResponse;
    public displayedColumns: string[] = ['player', 'role', 'hero', 'k', 'd', 'a', 'gpm', 'xpm', 'dmghero', 'dmgbuilding', 'healing'];

    constructor(@Inject(MAT_DIALOG_DATA) public data: SeriesComponentInput,
      private seriesService: SeriesService) {
    }

    ngOnInit(): void {
      this.seriesService.getSeries(this.data.seriesId)
        .subscribe((response: SeriesResponse) => {
          this.showLoading = false;
          this.series = response;
          this.series.games.forEach(g => {
            g.radiantPlayers.sort((a, b) => { return a.roleId - b.roleId; });
            g.direPlayers.sort((a, b) => { return a.roleId - b.roleId; });

            g.startDateStr = moment(g.startDate).format('YYYY, MMMM DD');
          });
        });
    }
  }