package wiwitaditya.demo.dotapedia.controller.tournament.model.detail;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.BracketPosition;

@Getter
@Setter
public class TournamentBracketResponse extends TournamentSeriesResponse {
    private int bracketRound;
    private int roundIndex;
    private BracketPosition bracketPosition;

    public TournamentBracketResponse() {}
    public TournamentBracketResponse(TournamentSeriesResponse seriesResponse) {
        super(seriesResponse);
    }
}
