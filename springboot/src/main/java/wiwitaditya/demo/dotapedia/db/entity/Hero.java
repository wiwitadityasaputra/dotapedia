package wiwitaditya.demo.dotapedia.db.entity;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.HeroType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "hero")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hero_id")
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private HeroType type;
    private String imageName;
    private boolean isActive;
}
