package wiwitaditya.demo.dotapedia.controller.tournament;

import wiwitaditya.demo.dotapedia.controller.tournament.model.detail.*;
import wiwitaditya.demo.dotapedia.db.entity.*;

import java.util.Map;

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

    public static TournamentTeamResponse toTournamentTeamResponse(Team team, TournamentTeam tournamentTeam) {
        TournamentTeamResponse tournamentTeamResponse = new TournamentTeamResponse();
        tournamentTeamResponse.setId(team.getId());
        tournamentTeamResponse.setName(team.getName());
        tournamentTeamResponse.setShortName(team.getShortName());
        tournamentTeamResponse.setImage(team.getImage());

        tournamentTeamResponse.setPlace(tournamentTeam.getPlace());
        tournamentTeamResponse.setPrice(tournamentTeam.getPrice());
        tournamentTeamResponse.setDpcPoints(tournamentTeam.getDpcPoints());
        tournamentTeamResponse.setSeed(tournamentTeam.getSeed());
        return tournamentTeamResponse;
    }
}
