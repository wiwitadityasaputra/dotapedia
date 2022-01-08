package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.Region;
import wiwitaditya.demo.dotapedia.db.utility.TournamentType;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Region region;
    private String name;
    private long prizePool;
    private long startDate;
    private long endDate;
    private int totalDpcPoints;
    @Enumerated(EnumType.STRING)
    private TournamentType tournamentType;
}
