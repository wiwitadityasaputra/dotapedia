package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.controller.tournament.model.detail.TournamentTeamResponse;
import wiwitaditya.demo.dotapedia.db.entity.TournamentTeam;

import java.util.List;

public interface TournamentTeamRepository extends JpaRepository<TournamentTeam, Integer> {

    @Query(value = "SELECT * FROM tournament_team where tournament_id = :tournamentId order by place asc",
            nativeQuery = true)
    List<TournamentTeam> findTeamsByTournamentId(@Param("tournamentId") int tournamentId);

    @Query(value = "SELECT " +
            "  tt.dpc_points as dpcPoints, " +
            "  tt.place as place, " +
            "  tt.price as price, " +
            "  tt.seed as seed, " +
            "  t.team_id as teamId, " +
            "  t.image as teamImage, " +
            "  t.name as teamName, " +
            "  t.short_name as teamShortName " +
            "FROM tournament_team tt " +
            "LEFT JOIN team t ON t.team_id = tt.team_id " +
            "WHERE tt.tournament_id = :tournamentId " +
            "ORDER by tt.place ASC;", nativeQuery = true)
    List<TournamentTeamResponse> findTournamentTeamByTournamentId(@Param("tournamentId") int tournamentId);
}
