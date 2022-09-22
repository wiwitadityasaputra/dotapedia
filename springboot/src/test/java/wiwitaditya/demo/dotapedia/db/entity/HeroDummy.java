package wiwitaditya.demo.dotapedia.db.entity;

import wiwitaditya.demo.dotapedia.db.utility.HeroType;

import java.util.Arrays;
import java.util.List;

public class HeroDummy {

    public static Hero get() {
        Hero hero = new Hero();
        hero.setId(1);
        hero.setName("name");
        hero.setType(HeroType.AGILITY);
        hero.setImageName("image-name");
        hero.setActive(true);
        return hero;
    }

    public static List<Hero> findByHeroIds() {
        return Arrays.asList(get());
    }
}
