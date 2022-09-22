package wiwitaditya.demo.dotapedia.controller.series;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import wiwitaditya.demo.dotapedia.controller.series.model.SeriesResponse;
import wiwitaditya.demo.dotapedia.db.entity.*;
import wiwitaditya.demo.dotapedia.db.repository.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class SeriesServiceTest {

    @Mock
    private SeriesRepository seriesRepository;
    @Mock
    private TeamRepository teamRepository;
    @Mock
    private GameRepository gameRepository;
    @Mock
    private PlayerGameRepository playerGameRepository;
    @Mock
    private PlayerRepository playerRepository;
    @Mock
    private PlayerRoleRepository playerRoleRepository;
    @Mock
    private HeroRepository heroRepository;

    @InjectMocks
    private SeriesService seriesService;

    @Test
    public void getSeries_unknown_seriesid() {
        Mockito.when(seriesRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
        SeriesResponse result = seriesService.getSeries(1);

        assertNotNull(result);
        assertNull(result.getSeriesId());
        assertNull(result.getFormat());
        assertNull(result.getGames());
        assertNull(result.getTeamAScore());
        assertNull(result.getTeamBScore());
        assertNull(result.getTeamAName());
        assertNull(result.getTeamBName());
    }

    @Test
    public void getSeries_valid_seriesid() {
        Series series = SeriesDummy.get();
        Mockito.when(seriesRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(series));
        List<Game> games = GameDummy.findBySeriesId();
        Mockito.when(gameRepository.findBySeriesId(ArgumentMatchers.anyInt())).thenReturn(games);
        List<PlayerGame> playerGames = PlayerGameDummy.findByGameId();
        Mockito.when(playerGameRepository.findByGameId(ArgumentMatchers.anyInt())).thenReturn(playerGames);
        Team team = TeamDummy.get();
        Mockito.when(teamRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(team));
        Mockito.when(teamRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(team));
        List<PlayerRole> playerRoles = PlayerRoleDummy.findAll();
        Mockito.when(playerRoleRepository.findAll()).thenReturn(playerRoles);
        List<Hero> heroes = HeroDummy.findByHeroIds();
        Mockito.when(heroRepository.findByHeroIds(ArgumentMatchers.any())).thenReturn(heroes);

        SeriesResponse result = seriesService.getSeries(1);
        assertNotNull(result);
    }
}
