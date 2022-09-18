package wiwitaditya.demo.dotapedia.controller.home;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import wiwitaditya.demo.dotapedia.controller.home.model.HomeResponse;
import wiwitaditya.demo.dotapedia.controller.home.model.TopHeroResponseDummy;
import wiwitaditya.demo.dotapedia.controller.news.NewsApiService;
import wiwitaditya.demo.dotapedia.controller.news.model.NewsApiArticleDummy;
import wiwitaditya.demo.dotapedia.controller.player.model.PlayerByCountryResponseDummy;
import wiwitaditya.demo.dotapedia.controller.schedule.ScheduleResponseDummy;
import wiwitaditya.demo.dotapedia.controller.schedule.ScheduleService;
import wiwitaditya.demo.dotapedia.db.TeamDummy;
import wiwitaditya.demo.dotapedia.db.repository.HeroRepository;
import wiwitaditya.demo.dotapedia.db.repository.PlayerRepository;
import wiwitaditya.demo.dotapedia.db.repository.TeamRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class HomeServiceTest {

    @Mock
    private NewsApiService newsApiService;
    @Mock
    private TeamRepository teamRepository;
    @Mock
    private PlayerRepository playerRepository;
    @Mock
    private HeroRepository heroRepository;
    @Mock
    private ScheduleService scheduleService;

    @InjectMocks
    private HomeService homeService;

    @Test
    public void getHome() {
        Mockito.when(teamRepository.findTop3Teams()).thenReturn(TeamDummy.findTop3Teams());
        Mockito.when(newsApiService.getNews()).thenReturn(NewsApiArticleDummy.getNews());
        Mockito.when(playerRepository.findTop3Players()).thenReturn(PlayerByCountryResponseDummy.findTop3Players());
        Mockito.when(heroRepository.findTop6Hero()).thenReturn(TopHeroResponseDummy.findTop6Hero());
        Mockito.when(scheduleService.findUpcomingMatch()).thenReturn(ScheduleResponseDummy.findUpcomingMatch());

        HomeResponse homeResponse = homeService.getHome();

        assertNotNull(homeResponse);
        assertEquals(TeamDummy.findTop3Teams().size(), homeResponse.getTop3Teams().size());
        assertEquals(2, homeResponse.getNews().size());
        assertEquals(PlayerByCountryResponseDummy.findTop3Players().size(), homeResponse.getTop3Players().size());
        assertEquals(TopHeroResponseDummy.findTop6Hero().size(), homeResponse.getTop6Heroes().size());
        assertEquals(ScheduleResponseDummy.findUpcomingMatch().size(), homeResponse.getUpcomingMatch().size());
    }
}
