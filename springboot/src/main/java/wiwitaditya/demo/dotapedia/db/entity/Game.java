package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.GameSide;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer id;
    private Integer seriesId;
    private Integer radiantTeamId;
    private Integer direTeamId;
    private long matchDate;
    private int radiantScore;
    private int direScore;
    @Enumerated(EnumType.STRING)
    private GameSide winner;
}
