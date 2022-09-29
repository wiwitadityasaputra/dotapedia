package wiwitaditya.demo.dotapedia.controller.tournament.model.series;

import java.util.Arrays;
import java.util.List;

public class BracketSeriesResponseDummy {

    public static BracketSeriesResponse get() {
        return new BracketSeriesResponse() {
            @Override public Integer getBracketId() { return 1; }
            @Override public Integer getBracketRound() { return 2; }
            @Override public Integer getRoundIndex() { return 3; }
            @Override public String getBracketPosition() { return "position"; }
            @Override public Integer getSeriesId() { return 1; }
            @Override public String getFormat() { return "format"; }
            @Override public String getStartDate() { return "start-date"; }
            @Override public Integer getTeamAId() { return 1; }
            @Override public Integer getTeamAScore() { return 5; }
            @Override public String getTeamAName() { return "team-a-name"; }
            @Override public String getTeamAShortName() { return "team-a-short-name"; }
            @Override public String getTeamAImage() { return "team-a-image"; }
            @Override public Integer getTeamBId() { return 1; }
            @Override public Integer getTeamBScore() { return 6; }
            @Override public String getTeamBName() { return "team-b-name"; }
            @Override public String getTeamBShortName() { return "team-b-short-name"; }
            @Override public String getTeamBImage() { return "team-b-image"; }
        };
    }

    public static List<BracketSeriesResponse> getBracketSeries() {
        return Arrays.asList(get());
    }

    public static List<BracketSeriesResponse> findBracketSeries() {
        return Arrays.asList(get());
    }
}
