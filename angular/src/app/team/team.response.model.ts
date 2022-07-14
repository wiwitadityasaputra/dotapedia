export interface TeamResponse {
    teamId: number;
    name: string;
    image: string;
    region: string;
    sponsors: string;

    totalEarnings: number;
    players: TeamPlayerResponse[];
}

export interface TeamPlayerResponse {
    playerId: number;
    fullName: string;
    nickName: string;

    playerRoleId: number;
    playerRole: string;
}