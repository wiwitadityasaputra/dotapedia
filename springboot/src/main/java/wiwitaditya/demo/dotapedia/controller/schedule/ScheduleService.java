package wiwitaditya.demo.dotapedia.controller.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.controller.series.model.SeriesResponse;
import wiwitaditya.demo.dotapedia.db.entity.*;
import wiwitaditya.demo.dotapedia.db.repository.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduleService {

    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TournamentBracketRepository tournamentBracketRepository;
    @Autowired
    private TournamentRoundrobinRepository tournamentRoundrobinRepository;
    @Autowired
    private TournamentRepository tournamentRepository;

    public List<ScheduleResponse> findSeriesHasNotStart() {
        List<ScheduleResponse> responses = new ArrayList();
        List<Series> serieses = seriesRepository.findByScoreNull();
        for (Series series: serieses) {
            ScheduleResponse scheduleResponse = new ScheduleResponse();

            Team teamA = teamRepository.findById(series.getTeamIdA()).orElse(null);
            if (teamA != null) {
                scheduleResponse.setRadiantTeamId(series.getTeamIdA());
                scheduleResponse.setRadiantTeamName(teamA.getName());
            }
            Team teamB = teamRepository.findById(series.getTeamIdB()).orElse(null);
            if (teamB != null) {
                scheduleResponse.setDireTeamId(series.getTeamIdB());
                scheduleResponse.setDireTeamName(teamB.getName());
            }

            TournamentBracket bracket = tournamentBracketRepository.findBySeriesId(series.getId());
            TournamentRoundRobin roundRobin = tournamentRoundrobinRepository.findBySeriesId(series.getId());
            if (bracket != null) {
                scheduleResponse.setTournamentId(bracket.getTournamentId());
            }
            if (roundRobin != null) {
                scheduleResponse.setTournamentId(roundRobin.getTournamentId());
            }

            Tournament tournament = tournamentRepository.findById(scheduleResponse.getTournamentId()).orElse(null);
            if (tournament != null) {
                scheduleResponse.setTournamentName(tournament.getName());
                scheduleResponse.setTournamentRegion(tournament.getRegion());
                scheduleResponse.setTournamentImage(tournament.getImage());
            }

            scheduleResponse.setStartDate(series.getStartDate());
            responses.add(scheduleResponse);

        }
        return responses;
    }
}
