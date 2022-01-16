package wiwitaditya.demo.dotapedia.controller.hero;

import wiwitaditya.demo.dotapedia.db.entity.Hero;

public class HeroMapping {

    public static HeroResponse toHeroResponse(Hero hero) {
        HeroResponse heroResponse = new HeroResponse();
        heroResponse.setId(hero.getId());
        heroResponse.setName(hero.getName());
        heroResponse.setHeroType(hero.getType());
        heroResponse.setImageName(hero.getImageName());
        return heroResponse;
    }
}
