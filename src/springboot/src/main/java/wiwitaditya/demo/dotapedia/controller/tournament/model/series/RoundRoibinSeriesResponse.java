package wiwitaditya.demo.dotapedia.controller.tournament.model.series;

public interface RoundRoibinSeriesResponse extends SeriesResponse {
    Integer getWeekIndex();
    Integer getDayIndex();
    Integer getMatchIndex();
}
