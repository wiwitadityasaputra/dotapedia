package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.Region;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer id;
    private String name;
    private String shortName;
    private String image;
    @Enumerated(EnumType.STRING)
    private Region region;
    private String sponsors;
    private long totalEarnings;
}
