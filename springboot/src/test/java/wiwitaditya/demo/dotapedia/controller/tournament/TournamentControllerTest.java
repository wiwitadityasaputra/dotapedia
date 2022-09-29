package wiwitaditya.demo.dotapedia.controller.tournament;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import wiwitaditya.demo.dotapedia.controller.tournament.model.detail.TournamentDetailResponseDummy;
import wiwitaditya.demo.dotapedia.controller.tournament.model.detail.TournamentTeamResponseDummy;
import wiwitaditya.demo.dotapedia.controller.tournament.model.player.PlayerParticipantResponseDummy;
import wiwitaditya.demo.dotapedia.controller.tournament.model.series.BracketSeriesResponseDummy;
import wiwitaditya.demo.dotapedia.controller.tournament.model.series.RoundRoibinSeriesResponseDummy;
import wiwitaditya.demo.dotapedia.db.entity.TournamentDummy;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class TournamentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TournamentService tournamentService;

    @Test
    public void getTournaments() throws Exception {
        Mockito.when(tournamentService.findTournamentByRegion(ArgumentMatchers.anyString())).thenReturn(TournamentDummy.findTournamentByRegion());

        this.mockMvc.perform(get("/api/tournaments"))
                .andExpect(status().isOk());
    }

    @Test
    public void getTournament() throws Exception {
        Mockito.when(tournamentService.getTournamentByTournamentId(ArgumentMatchers.anyInt())).thenReturn(TournamentDetailResponseDummy.get());
        this.mockMvc.perform(get("/api/tournaments/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPlayers() throws Exception {
        Mockito.when(tournamentService.getPlayers(ArgumentMatchers.anyInt())).thenReturn(PlayerParticipantResponseDummy.getPlayers());
        this.mockMvc.perform(get("/api/tournaments/1/players"))
                .andExpect(status().isOk());
    }

    @Test
    public void getRoundRobinSeries() throws Exception {
        Mockito.when(tournamentService.getRoundRobinSeries(ArgumentMatchers.anyInt())).thenReturn(RoundRoibinSeriesResponseDummy.getRoundRobinSeries());
        this.mockMvc.perform(get("/api/tournaments/1/round-robin-series"))
                .andExpect(status().isOk());
    }

    @Test
    public void getBracketSeries() throws Exception {
        Mockito.when(tournamentService.getBracketSeries(ArgumentMatchers.anyInt())).thenReturn(BracketSeriesResponseDummy.getBracketSeries());
        this.mockMvc.perform(get("/api/tournaments/1/bracket-series"))
                .andExpect(status().isOk());
    }

    @Test
    public void getTeams() throws Exception {
        Mockito.when(tournamentService.getTeams(ArgumentMatchers.anyInt())).thenReturn(TournamentTeamResponseDummy.getTeams());
        this.mockMvc.perform(get("/api/tournaments/1/teams"))
                .andExpect(status().isOk());
    }
}
