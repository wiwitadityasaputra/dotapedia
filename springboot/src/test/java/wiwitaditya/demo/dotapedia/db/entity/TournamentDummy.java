package wiwitaditya.demo.dotapedia.db.entity;

import wiwitaditya.demo.dotapedia.db.utility.Region;
import wiwitaditya.demo.dotapedia.db.utility.TournamentType;

import java.util.Arrays;
import java.util.List;

public class TournamentDummy {

    public static Tournament get() {
        Tournament tournament = new Tournament();
        tournament.setId(1);
        tournament.setRegion(Region.CHINA);
        tournament.setName("name");
        tournament.setImage("image");
        tournament.setPrizePool(2);
        tournament.setStartDate(3);
        tournament.setEndDate(4);
        tournament.setTotalDpcPoints(5);
        tournament.setTournamentType(TournamentType.BRACKET);
        return tournament;
    }

    public static List<Tournament> findTournamentByRegion() {
        return Arrays.asList(get());
    }

    public static List<Tournament> findAll() {
        return Arrays.asList(get());
    }

    public static List<Tournament> findByRegion() {
        return Arrays.asList(get());
    }
}
