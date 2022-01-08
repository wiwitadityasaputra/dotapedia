package wiwitaditya.demo.dotapedia.controller.tournament;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.Region;

@Getter
@Setter
public class TeamParticipant {
    private Integer teamId;
    private String name;
    private Region region;

    private Integer tournamentTeamId;
    private Integer place;
    private Long price;
    private Integer dpcPoints;
    private String seed;
}
