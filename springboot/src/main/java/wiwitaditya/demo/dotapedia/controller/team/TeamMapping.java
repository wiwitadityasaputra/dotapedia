package wiwitaditya.demo.dotapedia.controller.team;

import wiwitaditya.demo.dotapedia.controller.team.model.TeamResponse;
import wiwitaditya.demo.dotapedia.db.entity.Team;

public class TeamMapping {

    public static TeamResponse toTeamResponse(Team team) {
        TeamResponse tr = new TeamResponse();
        tr.setTeamId(team.getId());
        tr.setName(team.getName());
        tr.setShortName(team.getShortName());
        tr.setRegion(team.getRegion());
        tr.setSponsors(team.getSponsors());
        tr.setTotalEarnings(team.getTotalEarnings());
        tr.setImage(team.getImage());
        return tr;
    }
}
