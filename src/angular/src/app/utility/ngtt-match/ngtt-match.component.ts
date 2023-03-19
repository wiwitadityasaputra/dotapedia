import { Component, Input, OnInit } from '@angular/core';
import { SeriesService } from 'src/app/tournament/tournament-detail/series/series.service';
import { BracketSeriesResponse } from 'src/app/tournament/tournament.response.model';

@Component({
  selector: 'ngtt-match',
  templateUrl: './ngtt-match.component.html',
  styleUrls: ['./ngtt-match.component.scss']
})
export class NgttMatchComponent implements OnInit {

  @Input() match: BracketSeriesResponse;

  constructor(private seriesService: SeriesService) {
  }

  ngOnInit() {
  }

  public openSeries(): void {
    this.seriesService.show(this.match.seriesId);
  }
}
