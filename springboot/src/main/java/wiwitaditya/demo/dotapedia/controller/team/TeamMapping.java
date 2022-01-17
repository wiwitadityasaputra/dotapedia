package wiwitaditya.demo.dotapedia.controller.team;

import wiwitaditya.demo.dotapedia.controller.team.model.TeamPlayerResponse;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamResponse;
import wiwitaditya.demo.dotapedia.db.entity.Player;
import wiwitaditya.demo.dotapedia.db.entity.PlayerRole;
import wiwitaditya.demo.dotapedia.db.entity.Team;

import java.util.ArrayList;

public class TeamMapping {

    public static TeamResponse toTeamResponse(Team team) {
        TeamResponse tr = new TeamResponse();
        tr.setTeamId(team.getId());
        tr.setName(team.getName());
        tr.setRegion(team.getRegion());
        tr.setSponsors(team.getSponsors());
        tr.setTotalEarnings(team.getTotalEarnings());
        tr.setImage(team.getImage());
        tr.setPlayers(new ArrayList());
        return tr;
    }

    public static TeamPlayerResponse toTeamPlayerResponse(Player player, PlayerRole playerRole) {
        TeamPlayerResponse tpr = new TeamPlayerResponse();
        tpr.setPlayerId(player.getId());
        tpr.setFullName(player.getFullName());
        tpr.setNickName(player.getNickName());
        tpr.setPlayerRoleId(playerRole.getId());
        tpr.setRole(playerRole.getName());
        return tpr;
    }
}
