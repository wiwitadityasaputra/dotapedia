package wiwitaditya.demo.dotapedia.controller.team.model;

import java.util.Arrays;
import java.util.List;

public class TeamPlayerDummy {

    public static TeamPlayer get() {
        return new TeamPlayer() {
            @Override public Integer getPlayerId() { return 1; }
            @Override public String getFullName() { return "full-name"; }
            @Override public String getNickName() { return "nick-name"; }
            @Override public Integer getPlayerRoleId() { return 2; }
            @Override public String getPlayerRole() { return "player-role"; }
        };
    }

    public static List<TeamPlayer> findActivePlayerByTeamId() {
        return Arrays.asList(get());
    }
}
