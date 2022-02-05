import {Component, Input, OnChanges, SimpleChanges, TemplateRef} from '@angular/core';
import { TournamentBracketResponse } from 'src/app/tournament/tournament.response.model';
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
  public finalMatch: TournamentBracketResponse;

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
