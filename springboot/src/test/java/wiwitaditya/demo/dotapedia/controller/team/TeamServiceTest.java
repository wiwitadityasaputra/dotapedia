package wiwitaditya.demo.dotapedia.controller.team;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import wiwitaditya.demo.dotapedia.controller.schedule.ScheduleResponse;
import wiwitaditya.demo.dotapedia.controller.schedule.ScheduleResponseDummy;
import wiwitaditya.demo.dotapedia.controller.team.model.*;
import wiwitaditya.demo.dotapedia.db.entity.Team;
import wiwitaditya.demo.dotapedia.db.entity.TeamDummy;
import wiwitaditya.demo.dotapedia.db.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    @Test
    public void getTeamAndRoster_region_invalid() {
        List<Team> teams = TeamDummy.findTeamOrderByEarningsDesc();
        Mockito.when(teamRepository.findTeamOrderByEarningsDesc()).thenReturn(teams);

        List<TeamResponse> result = teamService.getTeamAndRoster("invalid");

        assertNotNull(result);
        assertEquals(result.size(), teams.size());
        assertEquals(result.get(0).getTeamId(), teams.get(0).getId());
        assertEquals(result.get(0).getName(), teams.get(0).getName());
        assertEquals(result.get(0).getShortName(), teams.get(0).getShortName());
        assertEquals(result.get(0).getRegion().toString(), teams.get(0).getRegion().toString());
        assertEquals(result.get(0).getSponsors(), teams.get(0).getSponsors());
        assertEquals(result.get(0).getTotalEarnings(), teams.get(0).getTotalEarnings());
        assertEquals(result.get(0).getImage(), teams.get(0).getImage());
    }

    @Test
    public void getTeamAndRoster_region_valid() {
        List<Team> teams = TeamDummy.findTeamByRegion();
        Mockito.when(teamRepository.findTeamByRegion(ArgumentMatchers.anyString())).thenReturn(teams);

        List<TeamResponse> result = teamService.getTeamAndRoster("CHINA");

        assertNotNull(result);
        assertEquals(result.size(), teams.size());
        assertEquals(result.get(0).getTeamId(), teams.get(0).getId());
        assertEquals(result.get(0).getName(), teams.get(0).getName());
        assertEquals(result.get(0).getShortName(), teams.get(0).getShortName());
        assertEquals(result.get(0).getRegion().toString(), teams.get(0).getRegion().toString());
        assertEquals(result.get(0).getSponsors(), teams.get(0).getSponsors());
        assertEquals(result.get(0).getTotalEarnings(), teams.get(0).getTotalEarnings());
        assertEquals(result.get(0).getImage(), teams.get(0).getImage());
    }

    @Test
    public void findActivePlayerByTeamId() {
        List<TeamPlayer> teamPlayers = TeamPlayerDummy.findActivePlayerByTeamId();
        Mockito.when(teamRepository.findActivePlayerByTeamId(ArgumentMatchers.anyInt())).thenReturn(teamPlayers);

        List<TeamPlayer> result = teamService.findActivePlayerByTeamId(3);
        assertNotNull(result);
        assertEquals(result.size(), teamPlayers.size());
        assertEquals(result.get(0).getPlayerId(), teamPlayers.get(0).getPlayerId());
        assertEquals(result.get(0).getFullName(), teamPlayers.get(0).getFullName());
        assertEquals(result.get(0).getNickName(), teamPlayers.get(0).getNickName());
        assertEquals(result.get(0).getPlayerRoleId(), teamPlayers.get(0).getPlayerRoleId());
        assertEquals(result.get(0).getPlayerRole(), teamPlayers.get(0).getPlayerRole());
    }

    @Test
    public void getTeam_team_null() {
        Mockito.when(teamRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());

        TeamDetail result = teamService.getTeam(1);

        assertNull(result);
    }

    @Test
    public void getTeam_team_exist() {
        Team team = TeamDummy.get();
        Mockito.when(teamRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(team));
        List<ScheduleResponse> upcomingMatch = ScheduleResponseDummy.findUpcomingMatch();
        Mockito.when(teamRepository.findUpcomingMatchByTeam(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
            .thenReturn(upcomingMatch);
        List<ScheduleResponse> latestMatch = ScheduleResponseDummy.findLatestSeries();
        Mockito.when(teamRepository.findLatestSeriesByTeam(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
            .thenReturn(latestMatch);

        TeamDetail result = teamService.getTeam(1);

        assertNotNull(result);
        assertEquals(result.getTeam(), team);
        assertEquals(result.getUpcomingMatch(), upcomingMatch);
        assertEquals(result.getLatestMatch(), latestMatch);
    }
}
