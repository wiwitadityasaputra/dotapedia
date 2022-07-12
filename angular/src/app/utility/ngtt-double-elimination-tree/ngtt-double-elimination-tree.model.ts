import { BracketSeriesResponse } from "src/app/tournament/tournament.response.model";

export interface NgttTournament {
    rounds: NgttRound[];
  }

export interface NgttRound {
  /**
   * The type determines where in which branch to place a match.
   * SingleElimination-Trees only consist of a winnerbracket and a final
   */
  type: 'Winnerbracket' | 'Loserbracket' | 'Final';
  matches: BracketSeriesResponse[];
}
  
  