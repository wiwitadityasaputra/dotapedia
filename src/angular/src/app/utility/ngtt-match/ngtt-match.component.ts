import { Component, Input, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { SeriesService } from '../../tournament/tournament-detail/series/series.service';
import { BracketSeriesResponse } from '../../tournament/tournament.response.model';

@Component({
    selector: 'ngtt-match',
    templateUrl: './ngtt-match.component.html',
    styleUrls: ['./ngtt-match.component.scss'],
    changeDetection: ChangeDetectionStrategy.Eager,
    standalone: false
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
