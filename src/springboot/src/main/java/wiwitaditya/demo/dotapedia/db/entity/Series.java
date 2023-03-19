package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.SeriesFormat;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_id")
    private Integer id;
    @Column(name = "team_id_a")
    private Integer teamIdA;
    @Column(name = "team_id_b")
    private Integer teamIdB;
    @Enumerated(EnumType.STRING)
    private SeriesFormat format;
    @Column(name = "team_a_series_score")
    private Integer teamASeriesScore;
    @Column(name = "team_b_series_score")
    private Integer teamBSeriesScore;
    @Column(name = "start_date")
    private long startDate;
}
