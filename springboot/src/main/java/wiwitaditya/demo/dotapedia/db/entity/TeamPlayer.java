package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "team_player")
public class TeamPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_player_id")
    private int id;
    private int teamId;
    private int playerId;
    private int playerRoleId;
    private Long joinDate;
    private Long leaveDate;
    private boolean isActive;
    private Integer newTeamPlayerId;
}
