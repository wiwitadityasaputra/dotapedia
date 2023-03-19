package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.db.entity.PlayerScreenshot;

import java.util.List;

public interface PlayerScreenshotRepository extends JpaRepository<PlayerScreenshot, Integer> {

    @Query(value = "SELECT * FROM player_screenshot WHERE player_id = :playerId", nativeQuery = true)
    List<PlayerScreenshot> findScreenshots(@Param("playerId") int playerId);
}
