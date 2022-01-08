package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.db.entity.TournamentTeam;

import java.util.List;

public interface TournamentTeamRepository extends JpaRepository<TournamentTeam, Integer> {

    @Query(value = "SELECT * FROM tournament_team where tournament_id = :tournamentId order by place asc",
            nativeQuery = true)
    List<TournamentTeam> findTeamsByTournamentId(@Param("tournamentId") int tournamentId);
}
