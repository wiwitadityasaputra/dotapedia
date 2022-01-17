package wiwitaditya.demo.dotapedia.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.controller.LookupUtil;
import wiwitaditya.demo.dotapedia.db.entity.Team;
import wiwitaditya.demo.dotapedia.db.entity.TournamentTeam;
import wiwitaditya.demo.dotapedia.db.repository.TeamRepository;
import wiwitaditya.demo.dotapedia.db.repository.TournamentRepository;
import wiwitaditya.demo.dotapedia.db.repository.TournamentTeamRepository;
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

    public List getAllTeamByTournamentId(int tournamentId) {
        List<TeamParticipant> participants = new ArrayList();

        List<TournamentTeam> teams = tournamentTeamRepository.findTeamsByTournamentId(tournamentId);
        for (TournamentTeam tournamentTeam: teams) {
            Team team = teamRepository.findById(tournamentTeam.getTeamId()).orElse(null);
            if (team != null) {
                TeamParticipant tp = new TeamParticipant();
                participants.add(TeamParticipantMapping.toTeamParticipant(tournamentTeam, team));
            }
        }

        return participants;
    }

    public List findTournamentByRegion(String r) {
        Region region = LookupUtil.lookup(Region.class, r);
        if (region == null) {
            return tournamentRepository.findAll();
        } else {
            return tournamentRepository.findByRegion(region.toString());
        }
    }
}
