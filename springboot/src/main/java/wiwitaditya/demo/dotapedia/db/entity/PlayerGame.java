package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "player_game")
public class PlayerGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_game_id")
    private Integer id;
    private Integer gameId;
    private Integer teamId;
    private Integer playerId;
    private Integer heroId;
    private Integer roleId;

    private int level;
    private int kdaKill;
    private int kdaDeath;
    private int kdaAssist;

    private int networth;
    private int goldPerMinute;
    private int experiencePerMinute;

    private int damageHero;
    private int damageBuilding;
    private int healing;
}
