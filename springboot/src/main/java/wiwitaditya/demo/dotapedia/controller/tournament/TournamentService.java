package wiwitaditya.demo.dotapedia.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.controller.LookupUtil;
import wiwitaditya.demo.dotapedia.controller.tournament.model.*;
import wiwitaditya.demo.dotapedia.db.entity.*;
import wiwitaditya.demo.dotapedia.db.repository.*;
import wiwitaditya.demo.dotapedia.db.utility.Region;
import wiwitaditya.demo.dotapedia.db.utility.TournamentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TournamentService {

    @Autowired
    private TournamentTeamRepository tournamentTeamRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private TournamentBracketRepository bracketRepository;
    @Autowired
    private TournamentRoundrobinRepository roundrobinRepository;
    @Autowired
    private SeriesRepository seriesRepository;

    public List<TeamParticipantResponse> getAllTeamByTournamentId(int tournamentId) {
        List<TeamParticipantResponse> participants = new ArrayList();

        List<TournamentTeam> teams = tournamentTeamRepository.findTeamsByTournamentId(tournamentId);
        for (TournamentTeam tournamentTeam: teams) {
            Team team = teamRepository.findById(tournamentTeam.getTeamId()).orElse(null);
            if (team != null) {
                participants.add(TeamParticipantMapping.toTeamParticipant(tournamentTeam, team));
            }
        }

        return participants;
    }

    public List findTournamentByRegion(String regions) {
        if (regions == null) {
            return tournamentRepository.findAll();
        }
        List<String> listRegion = new ArrayList();
        String[] regionSplit = regions.split(",");
        for (String regionStr: regionSplit) {
            Region region = LookupUtil.lookup(Region.class, regionStr);
            if (region != null) {
                listRegion.add(region.toString());
            }
        }

        if (listRegion.size() == 0) {
            return tournamentRepository.findAll();
        } else {
            return tournamentRepository.findByRegion(listRegion);
        }
    }

    public TournamentDetailResponse getTournamentByTournamentId(int tournamentId) {
        Map<Integer, Team> mapTeam = new HashMap();
        TournamentDetailResponse response = new TournamentDetailResponse();

        Tournament tournament = tournamentRepository.findById(tournamentId).orElse(null);
        if (tournament != null) {
            response.setId(tournament.getId());
            response.setRegion(tournament.getRegion());
            response.setName(tournament.getName());
            response.setImage(tournament.getImage());
            response.setPrizePool(tournament.getPrizePool());
            response.setStartDate(tournament.getStartDate());
            response.setEndDate(tournament.getEndDate());
            response.setTotalDpcPoints(tournament.getTotalDpcPoints());
            TournamentType tournamentType = tournament.getTournamentType();
            response.setTournamentType(tournamentType);

            List<TournamentTeamResponse> tournamentTeamResponses = new ArrayList();
            List<TournamentTeam> tournamentTeams = tournamentTeamRepository.findTeamsByTournamentId(tournamentId);
            for (TournamentTeam tournamentTeam: tournamentTeams) {
                Team team = teamRepository.findById(tournamentTeam.getTeamId()).orElse(null);
                if (team != null) {
                    mapTeam.put(team.getId(), team);

                    TournamentTeamResponse tournamentTeamResponse = new TournamentTeamResponse();
                    tournamentTeamResponse.setId(team.getId());
                    tournamentTeamResponse.setName(team.getName());
                    tournamentTeamResponse.setImage(team.getImage());

                    tournamentTeamResponse.setPlace(tournamentTeam.getPlace());
                    tournamentTeamResponse.setPrice(tournamentTeam.getPrice());
                    tournamentTeamResponse.setDpcPoints(tournamentTeam.getDpcPoints());
                    tournamentTeamResponse.setSeed(tournamentTeam.getSeed());

                    tournamentTeamResponses.add(tournamentTeamResponse);
                }
            }
            response.setTeams(tournamentTeamResponses);

            if (TournamentType.BRACKET.equals(tournamentType)) {
                List<TournamentBracketResponse> bracketSeries = new ArrayList();
                List<TournamentBracket> brackets = bracketRepository.findByTournamentId(tournament.getId());
                for (TournamentBracket bracket: brackets) {
                    Series series = seriesRepository.findById(bracket.getSeriesId()).orElse(null);
                    if (series != null) {
                        SeriesResponse seriesResponse = new SeriesResponse();
                        seriesResponse.setSeriesId(series.getId());
                        seriesResponse.setSeriesFormat(series.getFormat());
                        seriesResponse.setTeamAScore(series.getTeamASeriesScore());
                        seriesResponse.setTeamBScore(series.getTeamBSeriesScore());
                        seriesResponse.setTeamAId(series.getTeamIdA());
                        seriesResponse.setTeamBId(series.getTeamIdB());
                        seriesResponse.setStartDate(series.getStartDate());

                        Team teamA = mapTeam.get(series.getTeamIdA());
                        seriesResponse.setTeamAName(teamA.getName());
                        seriesResponse.setTeamAImage(teamA.getImage());
                        Team teamB = mapTeam.get(series.getTeamIdB());
                        seriesResponse.setTeamBName(teamB.getName());
                        seriesResponse.setTeamBImage(teamB.getImage());

                        TournamentBracketResponse tournamentBracketResponse =
                                new TournamentBracketResponse(seriesResponse);
                        tournamentBracketResponse.setBracketRound(bracket.getBracketRound());
                        tournamentBracketResponse.setRoundIndex(bracket.getRoundIndex());
                        tournamentBracketResponse.setBracketPosition(bracket.getBracketPosition());

                        bracketSeries.add(tournamentBracketResponse);
                    }
                }

                response.setBracketSeries(bracketSeries);
            } else if (TournamentType.ROUND_ROBIN.equals(tournamentType)) {
                List<TournamentRoundRobinResponse> roundRobinSeries = new ArrayList();
                List<TournamentRoundRobin> roundRobins = roundrobinRepository.findByTournamentId(tournament.getId());
                for (TournamentRoundRobin roundRobin: roundRobins) {
                    Series series = seriesRepository.findById(roundRobin.getSeriesId()).orElse(null);
                    if (series != null) {
                        SeriesResponse seriesResponse = new SeriesResponse();
                        seriesResponse.setSeriesId(series.getId());
                        seriesResponse.setSeriesFormat(series.getFormat());
                        seriesResponse.setTeamAScore(series.getTeamASeriesScore());
                        seriesResponse.setTeamBScore(series.getTeamBSeriesScore());
                        seriesResponse.setTeamAId(series.getTeamIdA());
                        seriesResponse.setTeamBId(series.getTeamIdB());
                        seriesResponse.setStartDate(series.getStartDate());

                        Team teamA = mapTeam.get(series.getTeamIdA());
                        seriesResponse.setTeamAName(teamA.getName());
                        seriesResponse.setTeamAImage(teamA.getImage());
                        Team teamB = mapTeam.get(series.getTeamIdB());
                        seriesResponse.setTeamBName(teamB.getName());
                        seriesResponse.setTeamBImage(teamB.getImage());

                        TournamentRoundRobinResponse tournamentRoundRobinResponse =
                                new TournamentRoundRobinResponse(seriesResponse);
                        tournamentRoundRobinResponse.setWeekIndex(roundRobin.getWeekIndex());
                        tournamentRoundRobinResponse.setDayIndex(roundRobin.getDayIndex());
                        tournamentRoundRobinResponse.setMatchIndex(roundRobin.getMatchIndex());

                        roundRobinSeries.add(tournamentRoundRobinResponse);
                    }
                }
                response.setRoundRobinSeries(roundRobinSeries);
            }
        }
        return response;
    }
}
