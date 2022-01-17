package wiwitaditya.demo.dotapedia.controller.team.model;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.Region;

import java.util.List;

@Setter
@Getter
public class TeamResponse {

    private Integer teamId;
    private String name;
    private Region region;
    private String sponsors;
    private long totalEarnings;
    private List<TeamPlayerResponse> players;
}
