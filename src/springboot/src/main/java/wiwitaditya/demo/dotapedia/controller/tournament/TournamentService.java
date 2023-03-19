package wiwitaditya.demo.dotapedia.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.controller.LookupUtil;
import wiwitaditya.demo.dotapedia.controller.tournament.model.detail.*;
import wiwitaditya.demo.dotapedia.controller.tournament.model.player.PlayerParticipantResponse;
import wiwitaditya.demo.dotapedia.controller.tournament.model.series.BracketSeriesResponse;
import wiwitaditya.demo.dotapedia.controller.tournament.model.series.RoundRoibinSeriesResponse;
import wiwitaditya.demo.dotapedia.db.entity.*;
import wiwitaditya.demo.dotapedia.db.repository.*;
import wiwitaditya.demo.dotapedia.db.utility.Region;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private TournamentTeamPlayerRepository tournamentTeamPlayerRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerRoleRepository playerRoleRepository;

    public List<Tournament> findTournamentByRegion(String regions) {
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
        TournamentDetailResponse response = new TournamentDetailResponse();

        Tournament tournament = tournamentRepository.findById(tournamentId).orElse(null);
        if (tournament != null) {
            response = TournamentMapping.toTournamentDetailResponse(tournament);
        }
        return response;
    }

    public List<PlayerParticipantResponse> getPlayers(int tournamentId) {
        return tournamentTeamPlayerRepository.findPlayersByTournamentId(tournamentId);
    }

    public List<RoundRoibinSeriesResponse> getRoundRobinSeries(int tournamentId) {
        return roundrobinRepository.findRoundRobinSeries(tournamentId);
    }

    public List<BracketSeriesResponse> getBracketSeries(int tournamentId) {
        return bracketRepository.findBracketSeries(tournamentId);
    }

    public List<TournamentTeamResponse> getTeams(int tournamentId) {
        return tournamentTeamRepository.findTournamentTeamByTournamentId(tournamentId);
    }
}
