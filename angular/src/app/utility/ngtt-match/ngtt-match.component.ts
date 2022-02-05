import {Component, Input, OnInit} from '@angular/core';
import { TournamentBracketResponse } from 'src/app/tournament/tournament.response.model';

@Component({
  selector: 'ngtt-match',
  templateUrl: './ngtt-match.component.html',
  styleUrls: ['./ngtt-match.component.scss']
})
export class NgttMatchComponent implements OnInit {

  @Input() match: TournamentBracketResponse;

  constructor() {
  }

  ngOnInit() {
  }

}
