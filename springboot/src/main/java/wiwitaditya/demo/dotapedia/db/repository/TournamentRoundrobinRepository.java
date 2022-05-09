package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.db.entity.TournamentRoundRobin;

import java.util.List;

public interface TournamentRoundrobinRepository extends JpaRepository<TournamentRoundRobin, Integer> {

    @Query(value = "SELECT * FROM tournament_roundrobin where tournament_id = :tournamentId",
            nativeQuery = true)
    List<TournamentRoundRobin> findByTournamentId(@Param("tournamentId") int tournamentId);

    @Query(value = "SELECT * FROM tournament_roundrobin where series_id = :seriesId", nativeQuery = true)
    TournamentRoundRobin findBySeriesId(@Param("seriesId") int seriesId);
}
