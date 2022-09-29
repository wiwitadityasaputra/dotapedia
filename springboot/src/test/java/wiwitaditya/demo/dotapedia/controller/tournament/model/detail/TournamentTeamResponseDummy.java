package wiwitaditya.demo.dotapedia.controller.tournament.model.detail;

import java.util.Arrays;
import java.util.List;

public class TournamentTeamResponseDummy {

    public static TournamentTeamResponse get() {
        return new TournamentTeamResponse() {
            @Override public String getDpcPoints() { return "123"; }
            @Override public Integer getPlace() { return 3; }
            @Override public String getPrice() { return "3000"; }
            @Override public String getSeed() { return "seed"; }
            @Override public Integer getTeamId() { return 1; }
            @Override public String getTeamImageId() { return "team-image-id"; }
            @Override public String getTeamName() { return "team-name"; }
            @Override public String getTeamShortName() { return "team-short-name"; }
        };
    }

    public static List<TournamentTeamResponse> getTeams() {
        return Arrays.asList(get());
    }

    public static List<TournamentTeamResponse> findTournamentTeamByTournamentId() {
        return Arrays.asList(get());
    }
}
