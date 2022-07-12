package wiwitaditya.demo.dotapedia.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wiwitaditya.demo.dotapedia.controller.tournament.model.detail.TournamentDetailResponse;
import wiwitaditya.demo.dotapedia.controller.tournament.model.player.PlayerParticipantResponse;
import wiwitaditya.demo.dotapedia.controller.tournament.model.series.BracketSeriesResponse;
import wiwitaditya.demo.dotapedia.controller.tournament.model.series.RoundRoibinSeriesResponse;
import wiwitaditya.demo.dotapedia.db.entity.Tournament;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping(path = "")
    public List<Tournament> getTournaments(@RequestParam(name = "regions", required = false) String regions) {
        return tournamentService.findTournamentByRegion(regions);
    }

    @GetMapping(path = "/{tournamentId}")
    public TournamentDetailResponse getTournament(@PathVariable(value = "tournamentId") int tournamentId) {
        return tournamentService.getTournamentByTournamentId(tournamentId);
    }

    @GetMapping(path = "/{tournamentId}/players")
    public List<PlayerParticipantResponse> getPlayers(@PathVariable(value = "tournamentId") int tournamentId) {
        return tournamentService.getPlayers(tournamentId);
    }

    @GetMapping(path = "/{tournamentId}/round-robin-series")
    public List<RoundRoibinSeriesResponse> getRoundRobinSeries(@PathVariable(value = "tournamentId") int tournamentId) {
        return tournamentService.getRoundRobinSeries(tournamentId);
    }

    @GetMapping(path = "/{tournamentId}/bracket-series")
    public List<BracketSeriesResponse> getBracketSeries(@PathVariable(value = "tournamentId") int tournamentId) {
        return tournamentService.getBracketSeries(tournamentId);
    }
}
