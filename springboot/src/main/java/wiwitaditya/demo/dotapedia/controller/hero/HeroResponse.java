package wiwitaditya.demo.dotapedia.controller.hero;

import lombok.Getter;
import lombok.Setter;
import wiwitaditya.demo.dotapedia.db.utility.HeroType;

@Getter
@Setter
public class HeroResponse {

    private int id;
    private String name;
    private HeroType heroType;
    private String imageName;
}
