package wiwitaditya.demo.dotapedia.controller.tournament.model;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.Region;
import wiwitaditya.demo.dotapedia.db.utility.TournamentType;

import java.util.List;

@Getter
@Setter
public class TournamentDetailResponse {
    private Integer id;
    private Region region;
    private String name;
    private String image;

    private long prizePool;
    private long startDate;
    private long endDate;
    private int totalDpcPoints;

    private TournamentType tournamentType;
    private List<TournamentTeamResponse> teams;

    private List<TournamentBracketResponse> bracketSeries;
    private List<TournamentRoundRobinResponse> roundRobinSeries;
}
