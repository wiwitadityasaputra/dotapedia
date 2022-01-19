package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wiwitaditya.demo.dotapedia.db.entity.Team;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query(value = "SELECT * FROM team ORDER BY total_earnings DESC", nativeQuery = true)
    List<Team> findTeamOrderByEarningsDesc();

    @Query(value = "SELECT * FROM team WHERE region = :region ORDER BY total_earnings DESC", nativeQuery = true)
    List<Team> findTeamByRegion(String region);
}
