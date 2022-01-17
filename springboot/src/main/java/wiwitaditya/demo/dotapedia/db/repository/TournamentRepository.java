package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.db.entity.Tournament;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    @Query(value = "SELECT * FROM tournament where region = :region",
            nativeQuery = true)
    List<Tournament> findByRegion(@Param("region") String region);
}
