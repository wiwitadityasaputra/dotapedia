package wiwitaditya.demo.dotapedia.controller.home;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import wiwitaditya.demo.dotapedia.controller.hero.model.TopHeroResponseDummy;
import wiwitaditya.demo.dotapedia.controller.home.model.HomeResponseDummy;
import wiwitaditya.demo.dotapedia.controller.news.model.NewsApiArticleDummy;
import wiwitaditya.demo.dotapedia.controller.player.model.PlayerByCountryResponseDummy;
import wiwitaditya.demo.dotapedia.controller.schedule.ScheduleResponseDummy;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamResponseDummy;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HomeService homeService;

    @Test
    public void getHome() throws Exception {
        Mockito.when(homeService.getHome()).thenReturn(HomeResponseDummy.get());

        this.mockMvc.perform(get("/api/home"))
            .andExpect(status().isOk())

            .andExpect(jsonPath("$.news.length()", is(1)))
            .andExpect(jsonPath("$.news[0].author", is(NewsApiArticleDummy.get().getAuthor())))
            .andExpect(jsonPath("$.news[0].title", is(NewsApiArticleDummy.get().getTitle())))
            .andExpect(jsonPath("$.news[0].description", is(NewsApiArticleDummy.get().getDescription())))
            .andExpect(jsonPath("$.news[0].url", is(NewsApiArticleDummy.get().getUrl())))
            .andExpect(jsonPath("$.news[0].urlToImage", is(NewsApiArticleDummy.get().getUrlToImage())))
            .andExpect(jsonPath("$.news[0].publishedAt", is(NewsApiArticleDummy.get().getPublishedAt())))
            .andExpect(jsonPath("$.news[0].content", is(NewsApiArticleDummy.get().getContent())))

            .andExpect(jsonPath("$.top3Teams.length()", is(1)))
            .andExpect(jsonPath("$.top3Teams[0].teamId", is(TeamResponseDummy.get().getTeamId())))
            .andExpect(jsonPath("$.top3Teams[0].name", is(TeamResponseDummy.get().getName())))
            .andExpect(jsonPath("$.top3Teams[0].shortName", is(TeamResponseDummy.get().getShortName())))
            .andExpect(jsonPath("$.top3Teams[0].image", is(TeamResponseDummy.get().getImage())))
            .andExpect(jsonPath("$.top3Teams[0].region", is(TeamResponseDummy.get().getRegion().toString())))
            .andExpect(jsonPath("$.top3Teams[0].sponsors", is(TeamResponseDummy.get().getSponsors())))
            .andExpect(jsonPath("$.top3Teams[0].totalEarnings", is(Math.toIntExact(TeamResponseDummy.get().getTotalEarnings()))))

            .andExpect(jsonPath("$.top3Players.length()", is(1)))
            .andExpect(jsonPath("$.top3Players[0].id", is(PlayerByCountryResponseDummy.get().getId())))
            .andExpect(jsonPath("$.top3Players[0].nickName", is(PlayerByCountryResponseDummy.get().getNickName())))

            .andExpect(jsonPath("$.top6Heroes.length()", is(1)))
            .andExpect(jsonPath("$.top6Heroes[0].heroId", is(TopHeroResponseDummy.get().getHeroId())))
            .andExpect(jsonPath("$.top6Heroes[0].name", is(TopHeroResponseDummy.get().getName())))
            .andExpect(jsonPath("$.top6Heroes[0].imageName", is(TopHeroResponseDummy.get().getImageName())))
            .andExpect(jsonPath("$.top6Heroes[0].total", is(TopHeroResponseDummy.get().getTotal())))

            .andExpect(jsonPath("$.upcomingMatch.length()", is(1)))
            .andExpect(jsonPath("$.upcomingMatch[0].startDate", is(ScheduleResponseDummy.get().getStartDate())))
            .andExpect(jsonPath("$.upcomingMatch[0].teamAId", is(ScheduleResponseDummy.get().getTeamAId())))
            .andExpect(jsonPath("$.upcomingMatch[0].teamAName", is(ScheduleResponseDummy.get().getTeamAName())))
            .andExpect(jsonPath("$.upcomingMatch[0].teamAScore", is(ScheduleResponseDummy.get().getTeamAScore())))
            .andExpect(jsonPath("$.upcomingMatch[0].teamBId", is(ScheduleResponseDummy.get().getTeamBId())))
            .andExpect(jsonPath("$.upcomingMatch[0].teamBName", is(ScheduleResponseDummy.get().getTeamBName())))
            .andExpect(jsonPath("$.upcomingMatch[0].teamBScore", is(ScheduleResponseDummy.get().getTeamBScore())))
            .andExpect(jsonPath("$.upcomingMatch[0].tournamentId", is(ScheduleResponseDummy.get().getTournamentId())))
            .andExpect(jsonPath("$.upcomingMatch[0].tournamentRegion", is(ScheduleResponseDummy.get().getTournamentRegion())))
            .andExpect(jsonPath("$.upcomingMatch[0].tournamentName", is(ScheduleResponseDummy.get().getTournamentName())))
            .andExpect(jsonPath("$.upcomingMatch[0].tournamentImage", is(ScheduleResponseDummy.get().getTournamentImage())))
        ;
    }
}
