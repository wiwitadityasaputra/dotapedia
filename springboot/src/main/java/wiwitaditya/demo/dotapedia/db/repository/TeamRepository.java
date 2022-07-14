package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
}
