package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "player_screenshot")
public class PlayerScreenshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_screenshot_id")
    private Integer id;
    private int playerId;
    private String imageName;
}
