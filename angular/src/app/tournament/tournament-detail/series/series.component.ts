import { Component, Inject, OnInit } from "@angular/core";
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { SeriesResponse } from "./series.response.model";
import { SeriesService } from "./series.service";
import { SeriesComponentInput } from "./series.view.model";

@Component({
    selector: 'app-series',
    templateUrl: './series.component.html',
    styleUrls: ['./series.component.css']
  })
  export class SeriesComponent implements OnInit {

    constructor(@Inject(MAT_DIALOG_DATA) public data: SeriesComponentInput,
      private seriesService: SeriesService) {
    }

    ngOnInit(): void {
      this.seriesService.getSeries(this.data.seriesId)
        .subscribe((response: SeriesResponse) => {
          console.log(response)
        });
    }
  }