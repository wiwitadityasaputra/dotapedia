export interface PlayerParticipantResponse {
    teamId: number;
    teamName: string;
    playerId: number;
    playerNickName: string;
    roleId: number;
    roleName: string;
}

export interface TeamParticipant {
    teamId: number;
    teamName: string;
    players: PlayerParticipant[];

    // css
    showImage: boolean;
}

export interface PlayerParticipant {
    playerId: number;
    playerNickName: string;
    roleId: number;
    roleName: string;
}