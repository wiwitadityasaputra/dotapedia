package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.controller.tournament.model.player.PlayerParticipantResponse;
import wiwitaditya.demo.dotapedia.db.entity.TournamentTeamPlayer;

import java.util.List;

public interface TournamentTeamPlayerRepository extends JpaRepository<TournamentTeamPlayer, Integer> {

    @Query(value = "SELECT * FROM tournament_team_player where tournament_team_id = :tournamentTeamId order by player_role_id asc",
            nativeQuery = true)
    List<TournamentTeamPlayer> findPlayerByTournamentTeamId(@Param("tournamentTeamId") int tournamentTeamId);

    @Query(value = "select " +
            "tt.team_id as teamId, " +
            "t.name as teamName, " +
            "ttp.player_id as playerId, " +
            "p.nick_name as playerNickName, " +
            "ttp.player_role_id roleId, " +
            "pr.name as roleName " +
            "from tournament_team_player ttp " +
            "inner join tournament_team tt on tt.tournament_team_id = ttp.tournament_team_id and tt.tournament_id = :tournamentId " +
            "left join player p  on p.player_id = ttp.player_id " +
            "left join player_role pr  on pr.player_role_id = ttp.player_role_id " +
            "left join team t on t.team_id = tt.team_id ",
            nativeQuery = true)
    List<PlayerParticipantResponse> findPlayersByTournamentId(@Param("tournamentId") int tournamentId);
}
