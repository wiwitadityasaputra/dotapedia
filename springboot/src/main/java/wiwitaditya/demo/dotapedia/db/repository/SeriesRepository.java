package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiwitaditya.demo.dotapedia.db.entity.Series;

public interface SeriesRepository extends JpaRepository<Series, Integer> {
}
