package wiwitaditya.demo.dotapedia.controller.tournament.model.player;

import java.util.Arrays;
import java.util.List;

public class PlayerParticipantResponseDummy {

    public static PlayerParticipantResponse get() {
        return new PlayerParticipantResponse() {
            @Override public Integer getTeamId() { return 1; }
            @Override public String getTeamName() { return "team-name"; }
            @Override public Integer getPlayerId() { return 2; }
            @Override public String getPlayerNickName() { return "nick-name"; }
            @Override public Integer getRoleId() { return 3; }
            @Override public String getRoleName() { return "role-name"; }
        };
    }

    public static List<PlayerParticipantResponse> getPlayers() {
        return Arrays.asList(get());
    }

    public static List<PlayerParticipantResponse> findPlayersByTournamentId() {
        return Arrays.asList(get());
    }
}
