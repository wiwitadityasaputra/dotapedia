package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.db.entity.Player;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query(value = "select * from player where player_id in (SELECT tp.player_id FROM team_player tp where tp.team_id = :teamId)",
            nativeQuery = true)
    List<Player> findPlayerByTeamId(@Param("teamId") int teamId);
}
