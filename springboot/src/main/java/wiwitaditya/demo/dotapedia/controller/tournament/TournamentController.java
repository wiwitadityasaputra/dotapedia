package wiwitaditya.demo.dotapedia.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wiwitaditya.demo.dotapedia.controller.tournament.model.TournamentDetailResponse;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping(path = "")
    public List getTournaments(@RequestParam(name = "regions", required = false) String regions) {
        return tournamentService.findTournamentByRegion(regions);
    }

    @GetMapping(path = "/{tournamentId}")
    public TournamentDetailResponse getTournament(@PathVariable(value = "tournamentId") int tournamentId) {
        return tournamentService.getTournamentByTournamentId(tournamentId);
    }

//    @GetMapping(path = "/{tournamentId}/teams")
//    public List getTournamentTeam(@PathVariable(value = "tournamentId") int tournamentId) {
//        return tournamentService.getAllTeamByTournamentId(tournamentId);
//    }
}
