package wiwitaditya.demo.dotapedia.controller.tournament.model;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.BracketPosition;

@Getter
@Setter
public class TournamentBracketResponse extends SeriesResponse {
    private int bracketRound;
    private int roundIndex;
    private BracketPosition bracketPosition;

    public TournamentBracketResponse() {}
    public TournamentBracketResponse(SeriesResponse seriesResponse) {
        super(seriesResponse);
    }
}
