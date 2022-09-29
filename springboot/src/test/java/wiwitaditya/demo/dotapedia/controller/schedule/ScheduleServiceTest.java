package wiwitaditya.demo.dotapedia.controller.schedule;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import wiwitaditya.demo.dotapedia.db.repository.SeriesRepository;
import wiwitaditya.demo.dotapedia.db.utility.Region;
import wiwitaditya.demo.dotapedia.db.utility.RegionService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ScheduleServiceTest {

    @Mock
    private SeriesRepository seriesRepository;
    @Mock
    private RegionService regionService;

    @InjectMocks
    private ScheduleService scheduleService;

    @Test
    public void findUpcomingMatch() {
        List<ScheduleResponse> upcomingMatch = ScheduleResponseDummy.findUpcomingMatch();
        Mockito.when(seriesRepository.findUpcomingMatch()).thenReturn(upcomingMatch);

        List<ScheduleResponse> result= scheduleService.findUpcomingMatch();

        assertNotNull(result);
        assertEquals(upcomingMatch.size(), result.size());
        assertEquals(upcomingMatch.get(0).getStartDate(), result.get(0).getStartDate());

        assertEquals(upcomingMatch.get(0).getTeamAId(), result.get(0).getTeamAId());
        assertEquals(upcomingMatch.get(0).getTeamAName(), result.get(0).getTeamAName());
        assertEquals(upcomingMatch.get(0).getTeamAScore(), result.get(0).getTeamAScore());

        assertEquals(upcomingMatch.get(0).getTeamBId(), result.get(0).getTeamBId());
        assertEquals(upcomingMatch.get(0).getTeamBName(), result.get(0).getTeamBName());
        assertEquals(upcomingMatch.get(0).getTeamAScore(), result.get(0).getTeamAScore());

        assertEquals(upcomingMatch.get(0).getTournamentId(), result.get(0).getTournamentId());
        assertEquals(upcomingMatch.get(0).getTournamentRegion(), result.get(0).getTournamentRegion());
        assertEquals(upcomingMatch.get(0).getTournamentName(), result.get(0).getTournamentName());
        assertEquals(upcomingMatch.get(0).getTournamentImage(), result.get(0).getTournamentImage());
    }

    @Test
    public void findLatestMatch_region_valid() {
        List<String> regions = Arrays.asList(Region.CHINA.toString());
        Mockito.when(regionService.toRegions(any())).thenReturn(regions);

        List<ScheduleResponse> latestSeries = ScheduleResponseDummy.findLatestSeries();
        Mockito.when(seriesRepository.findLatestSeries(any(List.class), anyInt(), anyInt()))
            .thenReturn(latestSeries);

        List<ScheduleResponse> result = scheduleService.findLatestMatch("CHINA", 0, 1);

        assertNotNull(result);
        assertEquals(latestSeries.size(), result.size());
        assertEquals(latestSeries.get(0).getStartDate(), result.get(0).getStartDate());

        assertEquals(latestSeries.get(0).getTeamAId(), result.get(0).getTeamAId());
        assertEquals(latestSeries.get(0).getTeamAName(), result.get(0).getTeamAName());
        assertEquals(latestSeries.get(0).getTeamAScore(), result.get(0).getTeamAScore());

        assertEquals(latestSeries.get(0).getTeamBId(), result.get(0).getTeamBId());
        assertEquals(latestSeries.get(0).getTeamBName(), result.get(0).getTeamBName());
        assertEquals(latestSeries.get(0).getTeamAScore(), result.get(0).getTeamAScore());

        assertEquals(latestSeries.get(0).getTournamentId(), result.get(0).getTournamentId());
        assertEquals(latestSeries.get(0).getTournamentRegion(), result.get(0).getTournamentRegion());
        assertEquals(latestSeries.get(0).getTournamentName(), result.get(0).getTournamentName());
        assertEquals(latestSeries.get(0).getTournamentImage(), result.get(0).getTournamentImage());
    }

    @Test
    public void findLatestMatch_region_invalid() {
        List<String> regions = Arrays.asList(Region.CHINA.toString());
        Mockito.when(regionService.getAllRegions()).thenReturn(regions);

        List<ScheduleResponse> latestSeries = ScheduleResponseDummy.findLatestSeries();
        Mockito.when(seriesRepository.findLatestSeries(any(List.class), anyInt(), anyInt()))
                .thenReturn(latestSeries);

        List<ScheduleResponse> result = scheduleService.findLatestMatch("wrong-value", 0, 1);

        assertNotNull(result);
        assertEquals(latestSeries.size(), result.size());
        assertEquals(latestSeries.get(0).getStartDate(), result.get(0).getStartDate());

        assertEquals(latestSeries.get(0).getTeamAId(), result.get(0).getTeamAId());
        assertEquals(latestSeries.get(0).getTeamAName(), result.get(0).getTeamAName());
        assertEquals(latestSeries.get(0).getTeamAScore(), result.get(0).getTeamAScore());

        assertEquals(latestSeries.get(0).getTeamBId(), result.get(0).getTeamBId());
        assertEquals(latestSeries.get(0).getTeamBName(), result.get(0).getTeamBName());
        assertEquals(latestSeries.get(0).getTeamAScore(), result.get(0).getTeamAScore());

        assertEquals(latestSeries.get(0).getTournamentId(), result.get(0).getTournamentId());
        assertEquals(latestSeries.get(0).getTournamentRegion(), result.get(0).getTournamentRegion());
        assertEquals(latestSeries.get(0).getTournamentName(), result.get(0).getTournamentName());
        assertEquals(latestSeries.get(0).getTournamentImage(), result.get(0).getTournamentImage());
    }
}
