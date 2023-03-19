package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.db.entity.TeamPlayer;

import java.util.List;

public interface TeamPlayerRepository extends JpaRepository<TeamPlayer, Integer> {

    @Query(value = "SELECT * FROM team_player where is_active = 1 and team_id = :teamId",
            nativeQuery = true)
    List<TeamPlayer> findTeamPlayerByTeamId(@Param("teamId") int teamId);
}
