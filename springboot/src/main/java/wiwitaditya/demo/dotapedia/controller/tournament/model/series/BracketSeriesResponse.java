package wiwitaditya.demo.dotapedia.controller.tournament.model.series;

public interface BracketSeriesResponse extends SeriesResponse {
    Integer getBracketId();
    Integer getBracketRound();
    Integer getRoundIndex();
    String getBracketPosition();
}
