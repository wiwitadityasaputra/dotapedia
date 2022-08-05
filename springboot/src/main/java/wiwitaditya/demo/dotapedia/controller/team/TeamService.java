package wiwitaditya.demo.dotapedia.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.controller.LookupUtil;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamPlayer;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamResponse;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamDetail;
import wiwitaditya.demo.dotapedia.db.entity.Team;
import wiwitaditya.demo.dotapedia.db.repository.TeamRepository;
import wiwitaditya.demo.dotapedia.db.utility.Region;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<TeamResponse> getTeamAndRoster(String regionStr) {
        Region region = LookupUtil.lookup(Region.class, regionStr);

        List<TeamResponse> response = new ArrayList();

        List<Team> teams;
        if (region == null) {
            teams = teamRepository.findTeamOrderByEarningsDesc();
        } else {
            teams = teamRepository.findTeamByRegion(region.toString());
        }

        for (Team team : teams) {
            response.add(TeamMapping.toTeamResponse(team));
        }
        return response;
    }

    public List<TeamPlayer> findActivePlayerByTeamId(int teamId) {
        return teamRepository.findActivePlayerByTeamId(teamId);
    }

    public TeamDetail getTeam(int teamId) {
        Optional<Team> optional = teamRepository.findById(teamId);
        if (optional == null) {
            return null;
        }
        TeamDetail response = new TeamDetail();
        response.setTeam(optional.get());
        response.setUpcomingMatch(teamRepository.findUpcomingMatchByTeam(teamId, 4, 0));
        response.setLatestMatch(teamRepository.findLatestSeriesByTeam(teamId, 4, 0));
        return response;
    }
}
