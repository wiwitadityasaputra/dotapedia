package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "player_role")
public class PlayerRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_role_id")
    private Integer id;
    private String name;
    private boolean isActive;
}
