package wiwitaditya.demo.dotapedia.controller.team.model;

import wiwitaditya.demo.dotapedia.controller.schedule.ScheduleResponseDummy;
import wiwitaditya.demo.dotapedia.db.entity.TeamDummy;

public class TeamDetailDummy {

    public static TeamDetail get() {
        TeamDetail teamDetail = new TeamDetail();
        teamDetail.setTeam(TeamDummy.get());
        teamDetail.setLatestMatch(ScheduleResponseDummy.findLatestMatch());
        teamDetail.setUpcomingMatch(ScheduleResponseDummy.findUpcomingMatch());
        return teamDetail;
    }
}
