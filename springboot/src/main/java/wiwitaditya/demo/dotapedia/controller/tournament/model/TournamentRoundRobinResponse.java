package wiwitaditya.demo.dotapedia.controller.tournament.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TournamentRoundRobinResponse extends SeriesResponse {
    private int weekIndex;
    private int dayIndex;
    private int matchIndex;

    public TournamentRoundRobinResponse() {}
    public TournamentRoundRobinResponse(SeriesResponse seriesResponse) {
        super(seriesResponse);
    }
}
