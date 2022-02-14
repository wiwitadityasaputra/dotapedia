package wiwitaditya.demo.dotapedia.controller.tournament;

import wiwitaditya.demo.dotapedia.controller.tournament.model.*;
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

    private static TournamentSeriesResponse toSeriesResponse(Series series, Map<Integer, Team> mapTeam) {
        TournamentSeriesResponse seriesResponse = new TournamentSeriesResponse();
        seriesResponse.setSeriesId(series.getId());
        seriesResponse.setSeriesFormat(series.getFormat());
        seriesResponse.setTeamAScore(series.getTeamASeriesScore());
        seriesResponse.setTeamBScore(series.getTeamBSeriesScore());
        seriesResponse.setTeamAId(series.getTeamIdA());
        seriesResponse.setTeamBId(series.getTeamIdB());
        seriesResponse.setStartDate(series.getStartDate());

        Team teamA = mapTeam.get(series.getTeamIdA());
        seriesResponse.setTeamAName(teamA.getName());
        seriesResponse.setTeamAShortName(teamA.getShortName());
        seriesResponse.setTeamAImage(teamA.getImage());

        Team teamB = mapTeam.get(series.getTeamIdB());
        seriesResponse.setTeamBName(teamB.getName());
        seriesResponse.setTeamBShortName(teamB.getShortName());
        seriesResponse.setTeamBImage(teamB.getImage());
        return seriesResponse;
    }

    public static TournamentBracketResponse toTournamentBracketResponse(Series series, Map<Integer, Team> mapTeam,
        TournamentBracket bracket) {

        TournamentBracketResponse tournamentBracketResponse =
                new TournamentBracketResponse(toSeriesResponse(series, mapTeam));
        tournamentBracketResponse.setBracketRound(bracket.getBracketRound());
        tournamentBracketResponse.setRoundIndex(bracket.getRoundIndex());
        tournamentBracketResponse.setBracketPosition(bracket.getBracketPosition());
        return tournamentBracketResponse;
    }

    public static TournamentRoundRobinResponse toTournamentRoundRobinResponse(Series series, Map<Integer, Team> mapTeam,
        TournamentRoundRobin roundRobin) {

        TournamentRoundRobinResponse tournamentRoundRobinResponse =
                new TournamentRoundRobinResponse(toSeriesResponse(series, mapTeam));
        tournamentRoundRobinResponse.setWeekIndex(roundRobin.getWeekIndex());
        tournamentRoundRobinResponse.setDayIndex(roundRobin.getDayIndex());
        tournamentRoundRobinResponse.setMatchIndex(roundRobin.getMatchIndex());
        return tournamentRoundRobinResponse;
    }
}
