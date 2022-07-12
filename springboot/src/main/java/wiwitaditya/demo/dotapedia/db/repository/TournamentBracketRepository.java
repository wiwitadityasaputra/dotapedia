package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.controller.tournament.model.series.BracketSeriesResponse;
import wiwitaditya.demo.dotapedia.db.entity.TournamentBracket;

import java.util.List;

public interface TournamentBracketRepository extends JpaRepository<TournamentBracket, Integer> {

    @Query(value = "SELECT * FROM tournament_bracket where tournament_id = :tournamentId",
            nativeQuery = true)
    List<TournamentBracket> findByTournamentId(@Param("tournamentId") int tournamentId);

    @Query(value = "SELECT * FROM tournament_bracket where series_id = :seriesId", nativeQuery = true)
    TournamentBracket findBySeriesId(@Param("seriesId") int seriesId);
    @Query(value = "select " +
            "  tob.tournament_bracket_id as bracketId, " +
            "  tob.bracket_round as bracketRound, " +
            "  tob.round_index as roundIndex, " +
            "  tob.bracket_position as bracketPosition, " +
            "  tob.series_id as seriesId, " +
            "  s.format as format, " +
            "  s.start_date as startDate, " +
            "  s.team_id_a as teamAId, " +
            "  s.team_a_series_score as teamAScore, " +
            "  ta.name as teamAName, " +
            "  ta.short_name as teamAShortName, " +
            "  ta.image as teamAImage, " +
            "  s.team_id_b as teamBId, " +
            "  s.team_b_series_score as teamBScore, " +
            "  tb.name as teamBName, " +
            "  tb.short_name as teamBShortName, " +
            "  tb.image as teamBImage " +
            "from tournament_bracket tob " +
            "LEFT JOIN series s ON s.series_id = tob.series_id " +
            "LEFT JOIN team ta ON ta.team_id = s.team_id_a " +
            "LEFT JOIN team tb on tb.team_id = s.team_id_b " +
            "where tob.tournament_id = 2", nativeQuery = true)
    List<BracketSeriesResponse> findBracketSeries(@Param("tournamentId") int tournamentId);
}
