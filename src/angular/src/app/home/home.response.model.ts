import { NewsApiArticle } from "../news/news.response.model";
import { PlayerByCountryResponse } from "../player/player.response.model";
import { ScheduleResponse } from "../schedule/schedule.response.model";
import { TeamResponse } from "../team/team.response.model";

export interface HomeResponse {
    news: NewsApiArticle[];
    top3Teams: TeamResponse[];
    top3Players: PlayerByCountryResponse[];
    top6Heroes: TopHeroResponse[];
    upcomingMatch: ScheduleResponse[];
}

export interface TopHeroResponse {
    heroId: number;
    name: string;
    imageName: string;
    total: number;
}