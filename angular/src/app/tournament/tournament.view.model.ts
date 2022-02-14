import { TournamentSeriesResponse } from "./tournament.response.model";

export interface RoundSeriesWeekly {
    index: number;
    name: string;
    roundSeriesDaily: RoundSeriesDaily[];
}

export interface RoundSeriesDaily {
    index: number;
    name: string;
    series: TournamentSeriesResponse[];
}

