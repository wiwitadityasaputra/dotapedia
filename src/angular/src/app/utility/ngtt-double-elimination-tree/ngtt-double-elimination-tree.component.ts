import {Component, Input, OnChanges, SimpleChanges, TemplateRef, ChangeDetectionStrategy} from '@angular/core';
import { BracketSeriesResponse } from '../../tournament/tournament.response.model';
import {NgttRound, NgttTournament} from './ngtt-double-elimination-tree.model';

@Component({
    selector: 'ngtt-double-elimination-tree',
    templateUrl: './ngtt-double-elimination-tree.component.html',
    styleUrls: ['./ngtt-double-elimination-tree.component.css'],
    changeDetection: ChangeDetectionStrategy.Eager,
    standalone: false
})
export class NgttDoubleEliminationTreeComponent implements OnChanges {
  @Input() matchTemplate: TemplateRef<any>;
  @Input() tournament: NgttTournament;

  public losersBracket: NgttRound[];
  public winnersBracket: NgttRound[];
  public finalMatch: BracketSeriesResponse;

  constructor() {
  }

  ngOnChanges(changes: SimpleChanges) {
    if (this.tournament && this.tournament.rounds) {
      this.losersBracket = this.tournament.rounds.filter(round => {
        return round.type === 'Loserbracket';
      });
      this.winnersBracket = this.tournament.rounds.filter(round => {
        return round.type === 'Winnerbracket';
      });
      const tmpFinal = this.tournament.rounds.filter(round => {
        return round.type === 'Final';
      }).shift();
      if (tmpFinal) {
        this.finalMatch = tmpFinal.matches[0];
      }
    }
  }

}
