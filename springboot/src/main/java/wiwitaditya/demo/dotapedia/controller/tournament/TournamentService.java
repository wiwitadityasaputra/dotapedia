package wiwitaditya.demo.dotapedia.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.db.entity.Team;
import wiwitaditya.demo.dotapedia.db.entity.TournamentTeam;
import wiwitaditya.demo.dotapedia.db.repository.TeamRepository;
import wiwitaditya.demo.dotapedia.db.repository.TournamentTeamRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class TournamentService {

    @Autowired
    private TournamentTeamRepository tournamentTeamRepository;

    @Autowired
    private TeamRepository teamRepository;

    public List getAllTeamByTournamentId(int tournamentId) {
        List<TeamParticipant> participants = new ArrayList();

        List<TournamentTeam> teams = tournamentTeamRepository.findTeamsByTournamentId(tournamentId);
        for (TournamentTeam tournamentTeam: teams) {
            Team team = teamRepository.findById(tournamentTeam.getTeamId()).orElse(null);
            if (team != null) {
                TeamParticipant tp = new TeamParticipant();
                participants.add(TeamParticipantMapping.mapping(tournamentTeam, team));
            }
        }

        return participants;
    }
}
