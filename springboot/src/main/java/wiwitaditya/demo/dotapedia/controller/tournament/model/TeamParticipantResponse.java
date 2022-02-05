package wiwitaditya.demo.dotapedia.controller.tournament.model;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.Region;

@Getter
@Setter
public class TeamParticipantResponse {
    private Integer teamId;
    private String name;
    private String shortName;
    private Region region;

    private Integer tournamentTeamId;
    private Integer place;
    private Long price;
    private Integer dpcPoints;
    private String seed;
}
