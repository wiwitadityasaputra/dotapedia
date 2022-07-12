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

export interface TournamentDetailResponse {
    id: number;
    // TODO change to enum
    region: string;
    name: string;
    image: string;

    prizePool: number;
    startDate: number;
    endDate: number;
    totalDpcPoints: number;

    // TODO change to enum
    tournamentType: string;
    teams: TournamentTeamResponse[];
}

export interface TournamentTeamResponse {
    id: number;
    name: string;
    shortName: string;
    image: string;

    place: number;
    price: number;
    dpcPoints: number;
    seed: string;
}

export interface TournamentSeriesResponse {
    seriesId: number;
    // TODO change to enum
    seriesFormat: string;
    startDate: number;

    teamAId: number;
    teamAScore: number;
    teamAName: string;
    teamAShortName: string;
    teamAImage: string;
    
    teamBId: number;
    teamBScore: number;
    teamBName: string;
    teamBShortName: string;
    teamBImage: string;
}

export interface BracketSeriesResponse extends TournamentSeriesResponse {
    bracketRound: number;
    roundIndex: number;
    // TODO change to enum
    bracketPosition: string;
}

export interface RoundRoibinSeriesResponse extends TournamentSeriesResponse {
    weekIndex: number;
    dayIndex: number;
    matchIndex: number;
}