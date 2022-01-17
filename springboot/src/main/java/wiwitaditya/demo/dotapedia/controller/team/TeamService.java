package wiwitaditya.demo.dotapedia.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamPlayerResponse;
import wiwitaditya.demo.dotapedia.controller.team.model.TeamResponse;
import wiwitaditya.demo.dotapedia.db.entity.Player;
import wiwitaditya.demo.dotapedia.db.entity.PlayerRole;
import wiwitaditya.demo.dotapedia.db.entity.Team;
import wiwitaditya.demo.dotapedia.db.entity.TeamPlayer;
import wiwitaditya.demo.dotapedia.db.repository.PlayerRepository;
import wiwitaditya.demo.dotapedia.db.repository.PlayerRoleRepository;
import wiwitaditya.demo.dotapedia.db.repository.TeamPlayerRepository;
import wiwitaditya.demo.dotapedia.db.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamPlayerRepository teamPlayerRepository;
    @Autowired
    private PlayerRoleRepository playerRoleRepository;

    public List<TeamResponse> getTeamAndRoster() {
        List<TeamResponse> response = new ArrayList();

        List<Team> teams = teamRepository.findTeamOrderByEarningsDesc();
        for (Team team : teams) {
            TeamResponse tr = TeamMapping.toTeamResponse(team);

            List<TeamPlayer> teamPlayers = teamPlayerRepository.findTeamPlayerByTeamId(team.getId());
            for (TeamPlayer teamPlayer : teamPlayers) {
                Player player = playerRepository.findById(teamPlayer.getPlayerId()).orElse(null);
                PlayerRole playerRole = playerRoleRepository.findById(teamPlayer.getPlayerRoleId()).orElse(null);

                if (player != null && playerRole != null) {
                    TeamPlayerResponse tpr = TeamMapping.toTeamPlayerResponse(player, playerRole);
                    tr.getPlayers().add(tpr);
                }
            }
            response.add(tr);
        }
        return response;
    }
}
