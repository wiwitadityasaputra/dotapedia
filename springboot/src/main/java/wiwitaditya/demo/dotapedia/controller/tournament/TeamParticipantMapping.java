package wiwitaditya.demo.dotapedia.controller.tournament;

import wiwitaditya.demo.dotapedia.db.entity.Team;
import wiwitaditya.demo.dotapedia.db.entity.TournamentTeam;

public class TeamParticipantMapping {

    public static TeamParticipant toTeamParticipant(TournamentTeam tournamentTeam, Team team) {
        TeamParticipant teamParticipant = new TeamParticipant();

        teamParticipant.setTeamId(team.getId());
        teamParticipant.setName(team.getName());
        teamParticipant.setRegion(team.getRegion());

        teamParticipant.setTournamentTeamId(tournamentTeam.getId());
        teamParticipant.setPlace(tournamentTeam.getPlace());
        teamParticipant.setPrice(tournamentTeam.getPrice());
        teamParticipant.setDpcPoints(tournamentTeam.getDpcPoints());
        teamParticipant.setSeed(tournamentTeam.getSeed());

        return teamParticipant;
    }
}
