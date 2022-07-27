export interface ScheduleResponse {
    startDate: string;

    teamAId: number;
    teamAName: string;
    teamAScore?: number;

    teamBId: number;
    teamBName: string;
    teamBScore?: number;
    
    tournamentId: number;
    tournamentRegion: string;
    tournamentName: string;
    tournamentImage: string;
}