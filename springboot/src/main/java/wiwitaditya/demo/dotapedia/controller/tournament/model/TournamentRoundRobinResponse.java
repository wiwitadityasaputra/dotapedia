package wiwitaditya.demo.dotapedia.controller.tournament.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TournamentRoundRobinResponse extends SeriesResponse {
    private int weekIndex;
    private long dayOfWeek;
    private int dayIndex;

    public TournamentRoundRobinResponse() {}
    public TournamentRoundRobinResponse(SeriesResponse seriesResponse) {
        super(seriesResponse);
    }
}
