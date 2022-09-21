package wiwitaditya.demo.dotapedia.controller.schedule;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class ScheduleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScheduleService scheduleService;

    @Test
    public void findSeriesHasNotStart() throws Exception {
        List<ScheduleResponse> upcomintMatch = ScheduleResponseDummy.findUpcomingMatch();
        Mockito.when(scheduleService.findUpcomingMatch()).thenReturn(upcomintMatch);

        this.mockMvc.perform(get("/api/schedule/upcoming-match"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()", is(1)))
            .andExpect(jsonPath("$[0].startDate", is(upcomintMatch.get(0).getStartDate())))
            .andExpect(jsonPath("$[0].teamAId", is(upcomintMatch.get(0).getTeamAId())))
            .andExpect(jsonPath("$[0].teamAName", is(upcomintMatch.get(0).getTeamAName())))
            .andExpect(jsonPath("$[0].teamAScore", is(upcomintMatch.get(0).getTeamAScore())))
            .andExpect(jsonPath("$[0].teamBId", is(upcomintMatch.get(0).getTeamBId())))
            .andExpect(jsonPath("$[0].teamBName", is(upcomintMatch.get(0).getTeamBName())))
            .andExpect(jsonPath("$[0].teamBScore", is(upcomintMatch.get(0).getTeamBScore())))
            .andExpect(jsonPath("$[0].tournamentId", is(upcomintMatch.get(0).getTournamentId())))
            .andExpect(jsonPath("$[0].tournamentRegion", is(upcomintMatch.get(0).getTournamentRegion())))
            .andExpect(jsonPath("$[0].tournamentName", is(upcomintMatch.get(0).getTournamentName())))
            .andExpect(jsonPath("$[0].tournamentImage", is(upcomintMatch.get(0).getTournamentImage())));
    }

    @Test
    public void findLatestMatch() throws Exception {
        List<ScheduleResponse> latestMatch = ScheduleResponseDummy.findLatestMatch();
        Mockito.when(scheduleService.findLatestMatch(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
            .thenReturn(latestMatch);

        this.mockMvc.perform(get("/api/schedule/latest-match?region=region&size=1&page=1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()", is(1)))
            .andExpect(jsonPath("$[0].startDate", is(latestMatch.get(0).getStartDate())))
            .andExpect(jsonPath("$[0].teamAId", is(latestMatch.get(0).getTeamAId())))
            .andExpect(jsonPath("$[0].teamAName", is(latestMatch.get(0).getTeamAName())))
            .andExpect(jsonPath("$[0].teamAScore", is(latestMatch.get(0).getTeamAScore())))
            .andExpect(jsonPath("$[0].teamBId", is(latestMatch.get(0).getTeamBId())))
            .andExpect(jsonPath("$[0].teamBName", is(latestMatch.get(0).getTeamBName())))
            .andExpect(jsonPath("$[0].teamBScore", is(latestMatch.get(0).getTeamBScore())))
            .andExpect(jsonPath("$[0].tournamentId", is(latestMatch.get(0).getTournamentId())))
            .andExpect(jsonPath("$[0].tournamentRegion", is(latestMatch.get(0).getTournamentRegion())))
            .andExpect(jsonPath("$[0].tournamentName", is(latestMatch.get(0).getTournamentName())))
            .andExpect(jsonPath("$[0].tournamentImage", is(latestMatch.get(0).getTournamentImage())));
    }
}
