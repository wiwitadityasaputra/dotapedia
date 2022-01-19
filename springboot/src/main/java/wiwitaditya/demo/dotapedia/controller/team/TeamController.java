package wiwitaditya.demo.dotapedia.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping(path = "")
    public List getTeams(@RequestParam(name = "region", required = false) String regions) {
        return teamService.getTeamAndRoster(regions);
    }
}
