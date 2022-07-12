package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tournament_team_player")
public class TournamentTeamPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_team_player_id")
    private Integer id;
    private Integer tournamentTeamId;
    private Integer playerId;
    private Integer playerRoleId;
}
