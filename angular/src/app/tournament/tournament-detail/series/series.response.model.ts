export interface SeriesResponse {
    seriesId: number;
    startDate: number;
    // TODO change to enum
    format: string;
    games: GameResponse[];
    teamAScore: number;
    teamBScore: number;
    teamAId: number;
    teamBId: number;
    teamAName: string;
    teamBName: string;
}

export interface GameResponse {
    gameId: number;
    // TODO change to enum
    winner: string;
    startDate: number;
    radiantTeamId: number;
    radiantTeamName: string;
    radiantScore: number;
    radiantPlayers: PlayerGameResponse[];
    direTeamId: number;
    direTeamName: string;
    direScore: number;
    direPlayers: PlayerGameResponse[];

    startDateStr?: string;
}

export interface PlayerGameResponse {
    playerGameId: number;
    playerId: number;
    playerNickname: string;
    roleId: number;
    roleName: string;
    heroId: number;
    heroName: string;
    heroImageName: string;
    heroLevel: number;
    kdaKill: number;
    kdaDeath: number;
    kdaAssist: number;
    networth: number;
    gpm: number;
    xpm: number;
    damageToHero: number;
    damageToBuilding: number;
    healing: number;
}
