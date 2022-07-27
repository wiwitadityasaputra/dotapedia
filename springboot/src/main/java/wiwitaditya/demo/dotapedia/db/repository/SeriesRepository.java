package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.controller.schedule.ScheduleResponse;
import wiwitaditya.demo.dotapedia.db.entity.Series;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Integer> {

    @Query(value = "SELECT * FROM series where team_a_series_score is null and team_b_series_score is null order by start_date asc",
            nativeQuery = true)
    List<Series> findByScoreNull();

    @Query(value = "SELECT " +
            "  s.start_date as startDate," +
            "  s.team_id_a as teamAId," +
            "  teama.name as teamAName," +
            "  s.team_id_b as teamBId," +
            "  teamb.name as teamBName," +
            "  t.tournament_id as tournamentId," +
            "  t.region as tournamentRegion," +
            "  t.name as tournamentName," +
            "  t.image as tournamentImage " +
            "FROM series s " +
            "LEFT JOIN team teama ON teama.team_id = s.team_id_a " +
            "LEFT JOIN team teamb ON teamb.team_id = s.team_id_b " +
            "LEFT JOIN tournament_bracket tb ON tb.series_id = s.series_id " +
            "LEFT JOIN tournament_roundrobin tr ON tr.series_id = s.series_id " +
            "LEFT JOIN tournament t ON t.tournament_id = tb.tournament_id OR t.tournament_id = tr.tournament_id " +
            "WHERE s.team_a_series_score IS NULL AND s.team_b_series_score IS NULL " +
            "ORDER BY s.start_date ASC ",
            nativeQuery = true)
    List<ScheduleResponse> findUpcomingMatch();

    @Query(value = "SELECT " +
            "  s.start_date as startDate," +
            "  s.team_id_a as teamAId," +
            "  teama.name as teamAName," +
            "  s.team_a_series_score as teamAScore," +
            "  s.team_id_b as teamBId," +
            "  teamb.name as teamBName," +
            "  s.team_b_series_score as teamBScore," +
            "  t.tournament_id as tournamentId," +
            "  t.region as tournamentRegion," +
            "  t.name as tournamentName," +
            "  t.image as tournamentImage " +
            "FROM series s " +
            "LEFT JOIN team teama ON teama.team_id = s.team_id_a " +
            "LEFT JOIN team teamb ON teamb.team_id = s.team_id_b " +
            "LEFT JOIN tournament_bracket tb ON tb.series_id = s.series_id " +
            "LEFT JOIN tournament_roundrobin tr ON tr.series_id = s.series_id " +
            "LEFT JOIN tournament t ON t.tournament_id = tb.tournament_id OR t.tournament_id = tr.tournament_id " +
            "WHERE s.team_a_series_score IS NOT NULL AND " +
            "  s.team_b_series_score IS NOT NULL AND " +
            "  t.region IN (:regions) " +
            "ORDER BY s.start_date DESC LIMIT :limit OFFSET :offset ",
            nativeQuery = true)
    List<ScheduleResponse> findLatestSeries(List<String> regions, @Param("limit") int limit, @Param("offset") int offset);
}
