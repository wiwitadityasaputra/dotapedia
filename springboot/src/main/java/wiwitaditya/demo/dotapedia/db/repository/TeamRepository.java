package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.controller.schedule.ScheduleResponse;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamPlayer;
import wiwitaditya.demo.dotapedia.db.entity.Team;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query(value = "SELECT * FROM team ORDER BY total_earnings DESC", nativeQuery = true)
    List<Team> findTeamOrderByEarningsDesc();

    @Query(value = "SELECT * FROM team WHERE region = :region ORDER BY total_earnings DESC", nativeQuery = true)
    List<Team> findTeamByRegion(String region);
    
    @Query(value = "SELECT " +
            "  p.player_id as playerId," +
            "  p.full_name as fullName," +
            "  p.nick_name as nickName," +
            "  pr.player_role_id as playerRoleId," +
            "  pr.name as playerRole " +
            "FROM team_player tp " +
            "LEFT JOIN player p ON p.player_id = tp.player_id " +
            "LEFT JOIN player_role pr on pr.player_role_id = tp.player_role_id " +
            "WHERE tp.team_id = :teamId " +
            "  AND tp.is_active = 1", nativeQuery = true)
    List<TeamPlayer> findActivePlayerByTeamId(@Param("teamId") int teamId);

    Team findTeamById(@Param("teamId") int teamId);

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
            "WHERE (teama.team_id = :teamId OR teamb.team_id = :teamId) AND s.team_a_series_score IS NOT NULL AND s.team_b_series_score IS NOT NULL " +
            "ORDER BY s.start_date DESC LIMIT :limit OFFSET :offset ",
            nativeQuery = true)
    List<ScheduleResponse> findLatestSeriesByTeam(@Param("teamId") int teamId, @Param("limit") int limit, @Param("offset") int offset);

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
            "WHERE (teama.team_id = :teamId OR teamb.team_id = :teamId) AND s.team_a_series_score IS NULL AND s.team_b_series_score IS NULL " +
            "ORDER BY s.start_date DESC LIMIT :limit OFFSET :offset ",
            nativeQuery = true)
    List<ScheduleResponse> findUpcomingMatchByTeam(@Param("teamId") int teamId, @Param("limit") int limit, @Param("offset") int offset);
}
