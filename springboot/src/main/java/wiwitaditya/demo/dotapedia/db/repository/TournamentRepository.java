package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.db.entity.Tournament;
import wiwitaditya.demo.dotapedia.db.utility.Region;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    @Query(value = "SELECT * FROM tournament where region IN (:regions)", nativeQuery = true)
    List<Tournament> findByRegion(@Param("regions") List<String> regions);
}
