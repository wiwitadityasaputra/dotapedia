package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.db.entity.TournamentTeamPlayer;

import java.util.List;

public interface TournamentTeamPlayerRepository extends JpaRepository<TournamentTeamPlayer, Integer> {

    @Query(value = "SELECT * FROM tournament_team_player where tournament_team_id = :tournamentTeamId order by player_role_id asc",
            nativeQuery = true)
    List<TournamentTeamPlayer> findPlayerByTournamentTeamId(@Param("tournamentTeamId") int tournamentTeamId);
}
