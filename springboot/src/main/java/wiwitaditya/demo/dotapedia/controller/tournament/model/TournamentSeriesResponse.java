package wiwitaditya.demo.dotapedia.controller.tournament.model;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.SeriesFormat;

@Getter
@Setter
public class TournamentSeriesResponse {

    private int seriesId;
    private SeriesFormat seriesFormat;
    private int teamAScore;
    private int teamBScore;

    private Integer teamAId;
    private Integer teamBId;

    private String teamAName;
    private String teamAShortName;
    private String teamAImage;

    private String teamBName;
    private String teamBShortName;
    private String teamBImage;

    private long startDate;

    public TournamentSeriesResponse() {}
    public TournamentSeriesResponse(TournamentSeriesResponse seriesResponse) {
        this.seriesId = seriesResponse.getSeriesId();
        this.seriesFormat = seriesResponse.getSeriesFormat();
        this.teamAScore = seriesResponse.getTeamAScore();
        this.teamBScore = seriesResponse.getTeamBScore();

        this.teamAId = seriesResponse.getTeamAId();
        this.teamAName = seriesResponse.getTeamAName();
        this.teamAShortName = seriesResponse.getTeamAShortName();
        this.teamAImage = seriesResponse.getTeamAImage();

        this.teamBId = seriesResponse.getTeamBId();
        this.teamBName = seriesResponse.getTeamBName();
        this.teamBShortName = seriesResponse.getTeamBShortName();
        this.teamBImage = seriesResponse.getTeamBImage();

        this.startDate = seriesResponse.getStartDate();
    }
}
