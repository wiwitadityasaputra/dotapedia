package wiwitaditya.demo.dotapedia.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wiwitaditya.demo.dotapedia.db.repository.TournamentRepository;;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TournamentService tournamentService;

    @GetMapping(path = "")
    public List getTournaments() {
        return tournamentRepository.findAll();
    }

    @GetMapping(path = "/{tournamentId}/teams")
    public List getTournamentTeam(@PathVariable(value = "tournamentId") int tournamentId) {
        return tournamentService.getAllTeamByTournamentId(tournamentId);
    }
}
