package wiwitaditya.demo.dotapedia.controller.hero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.controller.LookupUtil;
import wiwitaditya.demo.dotapedia.db.entity.Hero;
import wiwitaditya.demo.dotapedia.db.repository.HeroRepository;
import wiwitaditya.demo.dotapedia.db.utility.HeroType;

import java.util.ArrayList;
import java.util.List;

@Component
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List getAllHeroes(String heroType) {
        HeroType type = LookupUtil.lookup(HeroType.class, heroType);

        List<Hero> heroes;
        if (heroType == null) {
            heroes = heroRepository.findHeroesByActive(1);
        }  else if (type == null) {
            return new ArrayList();
        } else {
            heroes = heroRepository.findHeroesByTypeAndActive(type.toString(), 1);
        }

        List<HeroResponse> response = new ArrayList();
        for (Hero hero: heroes) {
            response.add(HeroMapping.toHeroResponse(hero));
        }
        return response;
    }
}
