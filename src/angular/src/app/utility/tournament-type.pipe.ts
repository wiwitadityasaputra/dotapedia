import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
    name: 'tournamentPipe',
    standalone: false
})
export class TournamentTypePipe implements PipeTransform {
  transform(value: string | undefined): string {
    if ("ROUND_ROBIN" === value) {
        return "Round Robin";
    } else if ("BRACKET" === value) {
        return "Bracket";
    }
    return value ? value : "";
  }
}