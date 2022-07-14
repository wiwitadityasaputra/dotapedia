package wiwitaditya.demo.dotapedia.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamPlayer;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamResponse;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping(path = "")
    public List<TeamResponse> getTeams(@RequestParam(name = "region", required = false) String regions) {
        return teamService.getTeamAndRoster(regions);
    }

    @GetMapping(path = "/{teamId}/players")
    public List<TeamPlayer> getActivePlayers(@PathVariable(value = "teamId") int teamId) {
        return teamService.findActivePlayerByTeamId(teamId);
    }
}
