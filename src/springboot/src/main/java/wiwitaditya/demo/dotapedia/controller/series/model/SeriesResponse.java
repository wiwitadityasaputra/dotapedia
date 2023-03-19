package wiwitaditya.demo.dotapedia.controller.series.model;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.SeriesFormat;

import java.util.List;

@Setter
@Getter
public class SeriesResponse {
    private Integer seriesId;
    private long startDate;
    private SeriesFormat format;
    private List<GameResponse> games;

    private Integer teamAScore;
    private Integer teamBScore;

    private int teamAId;
    private int teamBId;

    private String teamAName;
    private String teamBName;
}
