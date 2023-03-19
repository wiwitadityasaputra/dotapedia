package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tournament_team")
public class TournamentTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_team_id")
    private Integer id;
    private Integer teamId;
    private Integer tournamentId;
    private Integer place;
    private Long price;
    private Integer dpcPoints;
    private String seed;
}
