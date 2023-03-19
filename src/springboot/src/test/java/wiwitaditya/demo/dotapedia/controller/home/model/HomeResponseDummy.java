package wiwitaditya.demo.dotapedia.controller.home.model;

import wiwitaditya.demo.dotapedia.controller.hero.model.TopHeroResponseDummy;
import wiwitaditya.demo.dotapedia.controller.news.model.NewsApiArticleDummy;
import wiwitaditya.demo.dotapedia.controller.player.model.PlayerByCountryResponseDummy;
import wiwitaditya.demo.dotapedia.controller.schedule.ScheduleResponseDummy;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamResponseDummy;

import java.util.Arrays;

public class HomeResponseDummy {

    public static HomeResponse get() {
        HomeResponse homeResponse = new HomeResponse();
        homeResponse.setNews(Arrays.asList(NewsApiArticleDummy.get()));
        homeResponse.setTop3Teams(Arrays.asList(TeamResponseDummy.get()));
        homeResponse.setTop3Players(Arrays.asList(PlayerByCountryResponseDummy.get()));
        homeResponse.setTop6Heroes(Arrays.asList(TopHeroResponseDummy.get()));
        homeResponse.setUpcomingMatch(Arrays.asList(ScheduleResponseDummy.get()));
        return homeResponse;
    }
}
