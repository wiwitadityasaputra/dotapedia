import { Pipe, PipeTransform } from "@angular/core";

@Pipe({name: 'tournamentPipe'})
export class TournamentTypePipe implements PipeTransform {
  transform(value: string): string {
    if ("ROUND_ROBIN" === value) {
        return "Round Robin";
    } else if ("BRACKET" === value) {
        return "Bracket";
    }
    return value;
  }
}