package wiwitaditya.demo.dotapedia.controller.tournament;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import wiwitaditya.demo.dotapedia.controller.tournament.model.detail.TournamentDetailResponse;
import wiwitaditya.demo.dotapedia.controller.tournament.model.detail.TournamentTeamResponse;
import wiwitaditya.demo.dotapedia.controller.tournament.model.detail.TournamentTeamResponseDummy;
import wiwitaditya.demo.dotapedia.controller.tournament.model.player.PlayerParticipantResponse;
import wiwitaditya.demo.dotapedia.controller.tournament.model.player.PlayerParticipantResponseDummy;
import wiwitaditya.demo.dotapedia.controller.tournament.model.series.BracketSeriesResponse;
import wiwitaditya.demo.dotapedia.controller.tournament.model.series.BracketSeriesResponseDummy;
import wiwitaditya.demo.dotapedia.controller.tournament.model.series.RoundRoibinSeriesResponse;
import wiwitaditya.demo.dotapedia.controller.tournament.model.series.RoundRoibinSeriesResponseDummy;
import wiwitaditya.demo.dotapedia.db.entity.Tournament;
import wiwitaditya.demo.dotapedia.db.entity.TournamentDummy;
import wiwitaditya.demo.dotapedia.db.repository.*;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class TournamentServiceTest {

    @Mock
    private TournamentTeamRepository tournamentTeamRepository;
    @Mock
    private TeamRepository teamRepository;
    @Mock
    private TournamentRepository tournamentRepository;
    @Mock
    private TournamentBracketRepository bracketRepository;
    @Mock
    private TournamentRoundrobinRepository roundrobinRepository;
    @Mock
    private SeriesRepository seriesRepository;
    @Mock
    private TournamentTeamPlayerRepository tournamentTeamPlayerRepository;
    @Mock
    private PlayerRepository playerRepository;
    @Mock
    private PlayerRoleRepository playerRoleRepository;

    @InjectMocks
    private TournamentService tournamentService;

    @Test
    public void findTournamentByRegion_region_null() {
        List<Tournament> tournaments = TournamentDummy.findAll();
        Mockito.when(tournamentRepository.findAll()).thenReturn(tournaments);

        List<Tournament> result = tournamentService.findTournamentByRegion(null);
        assertEquals(result, tournaments);
    }

    @Test
    public void findTournamentByRegion_listRegion_zero() {
        List<Tournament> tournaments = TournamentDummy.findAll();
        Mockito.when(tournamentRepository.findAll()).thenReturn(tournaments);

        List<Tournament> result = tournamentService.findTournamentByRegion("aaaa");
        assertEquals(result, tournaments);
    }

    @Test
    public void findTournamentByRegion_listRegion_many() {
        List<Tournament> tournaments = TournamentDummy.findByRegion();
        Mockito.when(tournamentRepository.findByRegion(any())).thenReturn(tournaments);

        List<Tournament> result = tournamentService.findTournamentByRegion("CHINA,NORTH_AMERICA");
        assertEquals(result, tournaments);
    }

    @Test
    public void getTournamentByTournamentId() {
        Mockito.when(tournamentRepository.findById(anyInt())).thenReturn(Optional.of(TournamentDummy.get()));

        TournamentDetailResponse tournamentDetailResponse = tournamentService.getTournamentByTournamentId(1);
        assertNotNull(tournamentDetailResponse);
    }

    @Test
    public void getTournamentByTournamentId_tournament_null() {
        Mockito.when(tournamentRepository.findById(anyInt())).thenReturn(Optional.empty());

        TournamentDetailResponse tournamentDetailResponse = tournamentService.getTournamentByTournamentId(1);
        assertNotNull(tournamentDetailResponse);
        assertNull(tournamentDetailResponse.getTournamentType());
    }

    @Test
    public void getPlayers() {
        List<PlayerParticipantResponse> playerParticipantResponses = PlayerParticipantResponseDummy.findPlayersByTournamentId();
        Mockito.when(tournamentTeamPlayerRepository.findPlayersByTournamentId(anyInt())).thenReturn(playerParticipantResponses);

        List<PlayerParticipantResponse> result = tournamentService.getPlayers(1);
        assertEquals(result, playerParticipantResponses);
    }

    @Test
    public void getRoundRobinSeries() {
        List<RoundRoibinSeriesResponse> roundRoibinSeriesResponses = RoundRoibinSeriesResponseDummy.findRoundRobinSeries();
        Mockito.when(roundrobinRepository.findRoundRobinSeries(anyInt())).thenReturn(roundRoibinSeriesResponses);

        List<RoundRoibinSeriesResponse> result = tournamentService.getRoundRobinSeries(1);
        assertEquals(result, roundRoibinSeriesResponses);
    }

    @Test
    public void getBracketSeries() {
        List<BracketSeriesResponse> bracketSeriesResponses = BracketSeriesResponseDummy.findBracketSeries();
        Mockito.when(bracketRepository.findBracketSeries(anyInt())).thenReturn(bracketSeriesResponses);

        List<BracketSeriesResponse> result = tournamentService.getBracketSeries(1);
        assertEquals(result, bracketSeriesResponses);
    }

    @Test
    public void getTeams() {
        List<TournamentTeamResponse> tournamentTeamResponses = TournamentTeamResponseDummy.findTournamentTeamByTournamentId();
        Mockito.when(tournamentTeamRepository.findTournamentTeamByTournamentId(anyInt())).thenReturn(tournamentTeamResponses);

        List<TournamentTeamResponse> result = tournamentService.getTeams(1);
        assertEquals(result, tournamentTeamResponses);
    }
}
