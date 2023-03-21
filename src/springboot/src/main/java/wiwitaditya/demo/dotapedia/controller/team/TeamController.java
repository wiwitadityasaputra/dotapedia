package wiwitaditya.demo.dotapedia.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamPlayer;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamResponse;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamDetail;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping(path = "")
    public List<TeamResponse> getTeams(@RequestParam(name = "region", required = false) String regions,
        @RequestParam(name = "topTree", required = false) boolean topTree) {
        if (topTree) {
            return teamService.getTopTreeTeam();
        } else {
            return teamService.getTeamAndRoster(regions);
        }
    }

    @GetMapping(path = "/{teamId}")
    public TeamDetail getTeam(@PathVariable(value = "teamId") int teamId) {
        return teamService.getTeam(teamId);
    }

    @GetMapping(path = "/{teamId}/players")
    public List<TeamPlayer> getActivePlayers(@PathVariable(value = "teamId") int teamId) {
        return teamService.findActivePlayerByTeamId(teamId);
    }
}
