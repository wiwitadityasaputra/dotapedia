export interface TournamentModel {
    id: number;
    name: string;
    image: string;
    region: string;
    tournamentType: string;
    prizePool: number;
    totalDpcPoints: number;
    startDate: number;
    endDate: number;
}