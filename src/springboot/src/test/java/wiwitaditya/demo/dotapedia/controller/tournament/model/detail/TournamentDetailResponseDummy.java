package wiwitaditya.demo.dotapedia.controller.tournament.model.detail;

import wiwitaditya.demo.dotapedia.db.utility.Region;
import wiwitaditya.demo.dotapedia.db.utility.TournamentType;

public class TournamentDetailResponseDummy {

    public static TournamentDetailResponse get() {
        TournamentDetailResponse tdr = new TournamentDetailResponse();
        tdr.setId(1);
        tdr.setRegion(Region.CHINA);
        tdr.setName("name");
        tdr.setImage("image");
        tdr.setPrizePool(2);
        tdr.setStartDate(4);
        tdr.setEndDate(5);
        tdr.setTotalDpcPoints(6);
        tdr.setTournamentType(TournamentType.ROUND_ROBIN);
        return tdr;
    }
}
