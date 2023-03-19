package wiwitaditya.demo.dotapedia.controller.team;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import wiwitaditya.demo.dotapedia.controller.team.TeamService;
import wiwitaditya.demo.dotapedia.controller.team.model.*;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamService teamService;

    @Test
    public void getTeams() throws Exception {
        List<TeamResponse> teamResponses = TeamResponseDummy.getTeamAndRoster();
        Mockito.when(teamService.getTeamAndRoster(ArgumentMatchers.anyString())).thenReturn(teamResponses);

        this.mockMvc.perform(get("/api/teams?region=CHINA"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()", is(teamResponses.size())))
            .andExpect(jsonPath("$[0].teamId", is(teamResponses.get(0).getTeamId())))
            .andExpect(jsonPath("$[0].name", is(teamResponses.get(0).getName())))
            .andExpect(jsonPath("$[0].shortName", is(teamResponses.get(0).getShortName())))
            .andExpect(jsonPath("$[0].image", is(teamResponses.get(0).getImage())))
            .andExpect(jsonPath("$[0].region", is(teamResponses.get(0).getRegion().toString())))
            .andExpect(jsonPath("$[0].sponsors", is(teamResponses.get(0).getSponsors())))
            .andExpect(jsonPath("$[0].totalEarnings", is(Math.toIntExact(teamResponses.get(0).getTotalEarnings()))))
        ;
    }

    @Test
    public void getTeam() throws Exception {
        TeamDetail teamDetail = TeamDetailDummy.get();
        Mockito.when(teamService.getTeam(ArgumentMatchers.anyInt())).thenReturn(teamDetail);

        this.mockMvc.perform(get("/api/teams/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.team.id", is(teamDetail.getTeam().getId())))
            .andExpect(jsonPath("$.team.name", is(teamDetail.getTeam().getName())))
            .andExpect(jsonPath("$.team.shortName", is(teamDetail.getTeam().getShortName())))
            .andExpect(jsonPath("$.team.image", is(teamDetail.getTeam().getImage())))
            .andExpect(jsonPath("$.team.region", is(teamDetail.getTeam().getRegion().toString())))
            .andExpect(jsonPath("$.team.sponsors", is(teamDetail.getTeam().getSponsors())))
            .andExpect(jsonPath("$.team.totalEarnings", is(Math.toIntExact(teamDetail.getTeam().getTotalEarnings()))))
            .andExpect(jsonPath("$.team.biography", is(teamDetail.getTeam().getBiography())))

            .andExpect(jsonPath("$.upcomingMatch.length()", is(teamDetail.getUpcomingMatch().size())))
            .andExpect(jsonPath("$.latestMatch.length()", is(teamDetail.getLatestMatch().size())))
        ;
    }

    @Test
    public void getActivePlayers() throws Exception {
        List<TeamPlayer> teamPlayers = TeamPlayerDummy.findActivePlayerByTeamId();
        Mockito.when(teamService.findActivePlayerByTeamId(ArgumentMatchers.anyInt())).thenReturn(teamPlayers);

        this.mockMvc.perform(get("/api/teams/1/players"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()", is(teamPlayers.size())))
            .andExpect(jsonPath("$[0].playerId", is(teamPlayers.get(0).getPlayerId())))
            .andExpect(jsonPath("$[0].fullName", is(teamPlayers.get(0).getFullName())))
            .andExpect(jsonPath("$[0].nickName", is(teamPlayers.get(0).getNickName())))
            .andExpect(jsonPath("$[0].playerRoleId", is(teamPlayers.get(0).getPlayerRoleId())))
            .andExpect(jsonPath("$[0].playerRole", is(teamPlayers.get(0).getPlayerRole())))
        ;
    }
}
