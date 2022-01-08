package wiwitaditya.demo.dotapedia;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Integer id;

    private String nickName;
    private String fullName;
    private String roles;
    private long dateOfBirth;
    private String country;
    private String totalEarnings;
}
