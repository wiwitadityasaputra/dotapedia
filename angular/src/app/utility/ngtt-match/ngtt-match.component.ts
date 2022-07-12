import {Component, Input, OnInit, Optional} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { SeriesComponent } from 'src/app/tournament/tournament-detail/series/series.component';
import { BracketSeriesResponse } from 'src/app/tournament/tournament.response.model';

@Component({
  selector: 'ngtt-match',
  templateUrl: './ngtt-match.component.html',
  styleUrls: ['./ngtt-match.component.scss']
})
export class NgttMatchComponent implements OnInit {

  @Input() match: BracketSeriesResponse;

  constructor(@Optional() public dialog: MatDialog) {
  }

  ngOnInit() {
  }

  public openSeries(): void {
    this.dialog
    .open(SeriesComponent, { width: '100%', data: { seriesId: this.match.seriesId } })
    .afterClosed().subscribe(result => {});
  }
}
