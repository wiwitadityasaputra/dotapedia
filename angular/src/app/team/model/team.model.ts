import { TeamPlayerModel } from "./team-player.model";

export interface TeamModel {
    teamId: number;
    name: string;
    image: string;
    region: string;
    sponsors: string;
    totalEarnings: number;
    players: TeamPlayerModel[];
}