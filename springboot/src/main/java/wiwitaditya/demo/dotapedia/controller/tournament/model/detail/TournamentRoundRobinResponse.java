package wiwitaditya.demo.dotapedia.controller.tournament.model.detail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TournamentRoundRobinResponse extends TournamentSeriesResponse {
    private int weekIndex;
    private int dayIndex;
    private int matchIndex;

    public TournamentRoundRobinResponse() {}
    public TournamentRoundRobinResponse(TournamentSeriesResponse seriesResponse) {
        super(seriesResponse);
    }
}
