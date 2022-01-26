package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.db.entity.TournamentBracket;

import java.util.List;

public interface TournamentBracketRepository extends JpaRepository<TournamentBracket, Integer> {

    @Query(value = "SELECT * FROM tournament_bracket where tournament_id = :tournamentId",
            nativeQuery = true)
    List<TournamentBracket> findByTournamentId(@Param("tournamentId") int tournamentId);
}
