package wiwitaditya.demo.dotapedia.controller.schedule;

import java.util.Arrays;
import java.util.List;

public class ScheduleResponseDummy {

    public static ScheduleResponse get() {
        return new ScheduleResponse() {
            @Override public String getStartDate() { return "start-date"; }
            @Override public Integer getTeamAId() { return 1; }
            @Override public String getTeamAName() { return "team-a-name"; }
            @Override public Integer getTeamAScore() { return 2; }
            @Override public Integer getTeamBId() { return 3; }
            @Override public String getTeamBName() { return "team-b-name"; }
            @Override public Integer getTeamBScore() { return 4; }
            @Override public Integer getTournamentId() { return 5; }
            @Override public String getTournamentRegion() { return "tournament-region"; }
            @Override public String getTournamentName() { return "tournament-name"; }
            @Override public String getTournamentImage() { return "tournament-image"; }
        };
    }

    public static List<ScheduleResponse> findUpcomingMatch() {
        return Arrays.asList(get());
    }

    public static List<ScheduleResponse> findLatestMatch() {
        return Arrays.asList(get());
    }
}
