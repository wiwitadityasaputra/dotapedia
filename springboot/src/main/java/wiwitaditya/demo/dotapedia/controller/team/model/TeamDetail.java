package wiwitaditya.demo.dotapedia.controller.team.model;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.controller.schedule.ScheduleResponse;
import wiwitaditya.demo.dotapedia.db.entity.Team;

import java.util.List;

@Getter
@Setter
public class TeamDetail {
    private Team team;
    private List<ScheduleResponse> upcomingMatch;
    private List<ScheduleResponse> latestMatch;
}
