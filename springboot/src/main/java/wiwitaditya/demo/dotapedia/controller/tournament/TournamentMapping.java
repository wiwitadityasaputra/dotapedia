package wiwitaditya.demo.dotapedia.controller.tournament;

import wiwitaditya.demo.dotapedia.controller.tournament.model.detail.*;
import wiwitaditya.demo.dotapedia.db.entity.*;

public class TournamentMapping {

    public static TournamentDetailResponse toTournamentDetailResponse(Tournament tournament) {
        TournamentDetailResponse tournamentDetailResponse = new TournamentDetailResponse();
        tournamentDetailResponse.setId(tournament.getId());
        tournamentDetailResponse.setRegion(tournament.getRegion());
        tournamentDetailResponse.setName(tournament.getName());
        tournamentDetailResponse.setImage(tournament.getImage());
        tournamentDetailResponse.setPrizePool(tournament.getPrizePool());
        tournamentDetailResponse.setStartDate(tournament.getStartDate());
        tournamentDetailResponse.setEndDate(tournament.getEndDate());
        tournamentDetailResponse.setTotalDpcPoints(tournament.getTotalDpcPoints());
        tournamentDetailResponse.setTournamentType(tournament.getTournamentType());
        return tournamentDetailResponse;
    }
}
