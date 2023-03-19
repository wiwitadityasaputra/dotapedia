package wiwitaditya.demo.dotapedia.db.entity;

import wiwitaditya.demo.dotapedia.db.utility.SeriesFormat;

public class SeriesDummy {

    public static Series get() {
        Series s = new Series();
        s.setId(1);
        s.setTeamIdA(2);
        s.setTeamIdB(3);
        s.setFormat(SeriesFormat.BO_3);
        s.setTeamASeriesScore(4);
        s.setTeamBSeriesScore(5);
        s.setStartDate(6);
        return s;
    }
}
