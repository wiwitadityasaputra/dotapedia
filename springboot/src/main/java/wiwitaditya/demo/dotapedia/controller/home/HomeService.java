package wiwitaditya.demo.dotapedia.controller.home;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiwitaditya.demo.dotapedia.controller.home.model.HomeResponse;
import wiwitaditya.demo.dotapedia.controller.news.NewsApiService;
import wiwitaditya.demo.dotapedia.controller.schedule.ScheduleService;
import wiwitaditya.demo.dotapedia.controller.team.TeamMapping;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamResponse;
import wiwitaditya.demo.dotapedia.db.repository.HeroRepository;
import wiwitaditya.demo.dotapedia.db.repository.PlayerRepository;
import wiwitaditya.demo.dotapedia.db.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class HomeService {

    @Autowired
    private NewsApiService newsApiService;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private ScheduleService scheduleService;

    public HomeResponse getHome() {
        List<TeamResponse> top3Teams = new ArrayList();
        teamRepository.findTop3Teams().stream().forEach(t -> {
            top3Teams.add(TeamMapping.toTeamResponse(t));
        });

        HomeResponse response = new HomeResponse();
        response.setTop3Teams(top3Teams);
        response.setNews(newsApiService.getNews().subList(0, 2));
        response.setTop3Players(playerRepository.findTop3Players());
        response.setTop6Heroes(heroRepository.findTop6Hero());
        response.setUpcomingMatch(scheduleService.findUpcomingMatch());
        return response;
    }
}
