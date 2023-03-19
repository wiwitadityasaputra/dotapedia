package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.controller.tournament.model.series.RoundRoibinSeriesResponse;
import wiwitaditya.demo.dotapedia.db.entity.TournamentRoundRobin;

import java.util.List;

public interface TournamentRoundrobinRepository extends JpaRepository<TournamentRoundRobin, Integer> {

    @Query(value = "SELECT * FROM tournament_roundrobin where tournament_id = :tournamentId",
            nativeQuery = true)
    List<TournamentRoundRobin> findByTournamentId(@Param("tournamentId") int tournamentId);

    @Query(value = "SELECT * FROM tournament_roundrobin where series_id = :seriesId", nativeQuery = true)
    TournamentRoundRobin findBySeriesId(@Param("seriesId") int seriesId);

    @Query(value = "SELECT " +
            "  tr.week_index as weekIndex, " +
            "  tr.day_index as dayIndex, " +
            "  tr.match_index as matchIndex, " +
            "  tr.series_id as seriesId, " +
            "  s.format as format, " +
            "  s.start_date as startDate, " +
            "  s.team_id_a as teamAId, " +
            "  s.team_a_series_score as teamAScore, " +
            "  ta.name as teamAName, " +
            "  ta.short_name as teamAShortName, " +
            "  ta.image as teamAImage, " +
            "  s.team_id_b as teamBId, " +
            "  s.team_b_series_score as teamBScore, " +
            "  tb.name as teamBName, " +
            "  tb.short_name as teamBShortName, " +
            "  tb.image as teamBImage " +
            "FROM tournament_roundrobin tr " +
            "LEFT JOIN series s ON s.series_id = tr.series_id " +
            "LEFT JOIN team ta ON ta.team_id = s.team_id_a " +
            "LEFT JOIN team tb on tb.team_id = s.team_id_b " +
            "WHERE tr.tournament_id = :tournamentId", nativeQuery = true)
    List<RoundRoibinSeriesResponse> findRoundRobinSeries(@Param("tournamentId") int tournamentId);
}
