package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.BracketPosition;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tournament_bracket")
public class TournamentBracket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_bracket_id")
    private Integer id;
    private Integer tournamentId;
    private Integer seriesId;

    private int bracketRound;
    private int roundIndex;
    @Enumerated(EnumType.STRING)
    private BracketPosition bracketPosition;
}
