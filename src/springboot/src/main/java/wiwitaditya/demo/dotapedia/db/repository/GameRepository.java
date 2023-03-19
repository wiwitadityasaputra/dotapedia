package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.db.entity.Game;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query(value = "SELECT * FROM game where series_id = :seriesId", nativeQuery = true)
    List<Game> findBySeriesId(@Param("seriesId") int seriesId);
}
