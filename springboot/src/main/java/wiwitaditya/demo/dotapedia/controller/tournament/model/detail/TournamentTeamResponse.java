package wiwitaditya.demo.dotapedia.controller.tournament.model.detail;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
