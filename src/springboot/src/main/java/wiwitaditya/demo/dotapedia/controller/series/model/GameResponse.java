package wiwitaditya.demo.dotapedia.controller.series.model;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.GameSide;

import java.util.List;

@Setter
@Getter
public class GameResponse {
    private Integer gameId;
    private GameSide winner;
    private long startDate;

    private Integer radiantTeamId;
    private String radiantTeamName;
    private int radiantScore;
    private List<PlayerGameResponse> radiantPlayers;

    private Integer direTeamId;
    private String direTeamName;
    private int direScore;
    private List<PlayerGameResponse> direPlayers;
}
