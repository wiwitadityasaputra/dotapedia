package wiwitaditya.demo.dotapedia.controller.home.model;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.controller.news.model.NewsApiArticle;
import wiwitaditya.demo.dotapedia.controller.player.model.PlayerByCountryResponse;
import wiwitaditya.demo.dotapedia.controller.schedule.ScheduleResponse;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamResponse;

import java.util.List;

@Setter
@Getter
public class HomeResponse {

    private List<NewsApiArticle> news;
    private List<TeamResponse> top3Teams;
    private List<PlayerByCountryResponse> top3Players;
    private List<TopHeroResponse> top6Heroes;
    private List<ScheduleResponse> upcomingMatch;
}
