package wiwitaditya.demo.dotapedia.controller.tournament.model.series;

import java.util.Arrays;
import java.util.List;

public class RoundRoibinSeriesResponseDummy {

    public static RoundRoibinSeriesResponse get() {
        return new RoundRoibinSeriesResponse() {
            @Override public Integer getWeekIndex() { return 1; }
            @Override public Integer getDayIndex() { return 2; }
            @Override public Integer getMatchIndex() { return 3; }
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

    public static List<RoundRoibinSeriesResponse> getRoundRobinSeries() {
        return Arrays.asList(get());
    }

    public static List<RoundRoibinSeriesResponse> findRoundRobinSeries() {
        return Arrays.asList(get());
    }
}
