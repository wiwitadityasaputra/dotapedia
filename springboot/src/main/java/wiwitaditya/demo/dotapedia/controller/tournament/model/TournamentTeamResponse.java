package wiwitaditya.demo.dotapedia.controller.tournament.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TournamentTeamResponse {
    private Integer id;
    private String name;
    private String shortName;
    private String image;

    private Integer place;
    private Long price;
    private Integer dpcPoints;
    private String seed;
}
