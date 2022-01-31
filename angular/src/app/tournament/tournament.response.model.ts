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

    bracketSeries: TournamentBracketResponse[];
    roundRobinSeries: TournamentRoundRobinResponse[];
}

export interface TournamentTeamResponse {
    id: number;
    name: string;
    image: string;

    place: number;
    price: number;
    dpcPoints: number;
    seed: string;
}

export interface SeriesResponse {
    seriesId: number;
    // TODO change to enum
    seriesFormat: string;
    teamAScore: number;
    teamBScore: number;

    teamAId: number;
    teamBId: number;

    teamAName: string;
    teamAImage: string;

    teamBName: string;
    teamBImage: string;

    startDate: number;
}

export interface TournamentBracketResponse extends SeriesResponse {
    bracketRound: number;
    roundIndex: number;
    // TODO change to enum
    bracketPosition: string;
}

export interface TournamentRoundRobinResponse extends SeriesResponse {
    weekIndex: number;
    dayIndex: number;
    matchIndex: number;
}