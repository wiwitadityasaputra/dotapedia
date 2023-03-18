package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tournament_roundrobin")
public class TournamentRoundRobin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_roundrobin_id")
    private Integer id;
    private Integer tournamentId;
    private Integer seriesId;

    private int weekIndex;
    private int dayIndex;
    private int matchIndex;
}
