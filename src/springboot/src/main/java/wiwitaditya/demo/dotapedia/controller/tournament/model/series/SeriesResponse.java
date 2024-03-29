package wiwitaditya.demo.dotapedia.controller.tournament.model.series;

public interface SeriesResponse {

    Integer getSeriesId();
    String getFormat();
    String getStartDate();

    Integer getTeamAId();
    Integer getTeamAScore();
    String getTeamAName();
    String getTeamAShortName();
    String getTeamAImage();

    Integer getTeamBId();
    Integer getTeamBScore();
    String getTeamBName();
    String getTeamBShortName();
    String getTeamBImage();

}
