package wiwitaditya.demo.dotapedia.controller.schedule;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.Region;

@Setter
@Getter
public class ScheduleResponse {
    private Integer tournamentId;
    private Region tournamentRegion;
    private String tournamentName;
    private String tournamentImage;

    private long startDate;

    private Integer radiantTeamId;
    private String radiantTeamName;

    private Integer direTeamId;
    private String direTeamName;
}
