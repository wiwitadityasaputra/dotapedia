import { TeamModel } from "./team.model";

export interface TeamViewModel {
    teamA: TeamModel | null;
    teamB: TeamModel | null;
}