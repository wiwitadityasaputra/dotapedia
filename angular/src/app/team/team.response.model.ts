import { ScheduleResponse } from "../schedule/schedule.response.model";

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

export interface TeamDetailTeamResponse {
    id: number;
    name: string;
    shortName: string;
    image: string;
    region: string;
    sponsors: string;
    totalEarnings: string;
    biography: string;
}

export interface TeamDetailResponse {
    team: TeamDetailTeamResponse;
    upcomingMatch: ScheduleResponse[];
    latestMatch: ScheduleResponse[];
}