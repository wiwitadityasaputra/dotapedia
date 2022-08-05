import { ScheduleView } from "../schedule/schedule.view.model";
import { TeamResponse } from "./team.response.model";

export interface TeamModel {
    teamA: TeamResponse | null;
    teamB: TeamResponse | null;
}

export interface TeamDetailView {
    team: TeamDetailTeamView;
    upcomingMatch: ScheduleView[];
    latestMatch: ScheduleView[];
}

export interface TeamDetailTeamView {
    id: number;
    name: string;
    shortName: string;
    image: string;
    region: string;
    sponsors: string;
    totalEarnings: string;
    biographies: string[];
}