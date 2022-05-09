package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wiwitaditya.demo.dotapedia.db.entity.Series;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Integer> {

    @Query(value = "SELECT * FROM series where team_a_series_score is null and team_b_series_score is null order by start_date asc",
            nativeQuery = true)
    List<Series> findByScoreNull();
}
