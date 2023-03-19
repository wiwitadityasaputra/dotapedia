package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.db.entity.PlayerGame;

import java.util.List;

public interface PlayerGameRepository extends JpaRepository<PlayerGame, Integer> {

    @Query(value = "SELECT * FROM player_game where game_id = :gameId", nativeQuery = true)
    List<PlayerGame> findByGameId(@Param("gameId") int gameId);
}
