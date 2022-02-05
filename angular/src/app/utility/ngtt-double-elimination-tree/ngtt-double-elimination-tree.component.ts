import {Component, Input, OnChanges, SimpleChanges, TemplateRef} from '@angular/core';
import {NgttRound, NgttTournament} from './ngtt-double-elimination-tree.model';

@Component({
  selector: 'ngtt-double-elimination-tree',
  templateUrl: './ngtt-double-elimination-tree.component.html',
  styleUrls: ['./ngtt-double-elimination-tree.component.css']
})
export class NgttDoubleEliminationTreeComponent implements OnChanges {
  @Input() matchTemplate: TemplateRef<any>;
  @Input() tournament: NgttTournament;

  public losersBracket: NgttRound[];
  public winnersBracket: NgttRound[];
  public final: NgttRound;

  constructor() {
  }

  ngOnChanges(changes: SimpleChanges) {
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
      this.final = tmpFinal;
    }
  }

}
