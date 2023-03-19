package wiwitaditya.demo.dotapedia.controller.series.model;

import wiwitaditya.demo.dotapedia.db.utility.SeriesFormat;

import java.util.Arrays;

public class SeriesResponseDummy {

    public static SeriesResponse get() {
        SeriesResponse sr = new SeriesResponse();

        sr.setSeriesId(1);
        sr.setStartDate(2);
        sr.setFormat(SeriesFormat.ONE_GAME);
        sr.setGames(Arrays.asList(GameResponseDummy.get()));

        sr.setTeamAScore(3);
        sr.setTeamBScore(4);

        sr.setTeamAId(5);
        sr.setTeamBId(6);

        sr.setTeamAName("team-a");
        sr.setTeamBName("team-b");
        return sr;
    }
}
