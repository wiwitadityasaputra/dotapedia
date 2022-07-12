package wiwitaditya.demo.dotapedia.controller.hero;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import wiwitaditya.demo.dotapedia.db.entity.Hero;
import wiwitaditya.demo.dotapedia.db.repository.HeroRepository;
import wiwitaditya.demo.dotapedia.db.utility.HeroType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;


@Slf4j
@ExtendWith(MockitoExtension.class)
public class HeroServiceTest {

    @Mock
    private HeroRepository heroRepository;

    @InjectMocks
    private HeroService heroService;

    @Test
    public void getAllHeroes_type_null() {
        log.info("test getAllHeroes_type_null");

        Mockito.when(heroRepository.findHeroesByActive(anyInt())).thenReturn(getHeroes());

        List<HeroResponse> heroes = heroService.getAllHeroes(null);
        Hero h = getHero();

        assertTrue(heroes.size() == 1);
        assertEquals(h.getId(), heroes.get(0).getId());
        assertEquals(h.getImageName(), heroes.get(0).getImageName());
        assertEquals(h.getType(), heroes.get(0).getHeroType());
        assertEquals(h.getName(), heroes.get(0).getName());
    }

    @Test
    public void getAllHeroes_type_invalid() {
        List<HeroResponse> heroes = heroService.getAllHeroes("invalid-type");
        assertTrue(heroes.size() == 0);
    }

    @Test
    public void getAllHeroes_type_valid() {
        Mockito.when(heroRepository.findHeroesByTypeAndActive(anyString(), anyInt())).thenReturn(getHeroes());

        List<HeroResponse> heroes = heroService.getAllHeroes(HeroType.STRENGTH.toString());
        Hero h = getHero();

        assertTrue(heroes.size() == 1);
        assertEquals(h.getId(), heroes.get(0).getId());
        assertEquals(h.getImageName(), heroes.get(0).getImageName());
        assertEquals(h.getType(), heroes.get(0).getHeroType());
        assertEquals(h.getName(), heroes.get(0).getName());
    }

    private Hero getHero() {
        Hero hero = new Hero();
        hero.setId(3);
        hero.setImageName("image-name");
        hero.setType(HeroType.STRENGTH);
        hero.setName("name");
        return hero;
    }

    private List<Hero> getHeroes() {
        List<Hero> heroes = new ArrayList();
        heroes.add(getHero());
        return heroes;
    }
}
