export interface ScheduleView {
    direTeamId: number;
    direTeamName: string;
    direScore?: number;

    radiantTeamId: number;
    radiantTeamName: string;
    radiantScore?: number;

    startDate: string;
    tournamentId: number;
    tournamentImage: string;
    tournamentName: string;
    tournamentRegion: string;

    regionAbbr: string;
    startDateStr: string;
}