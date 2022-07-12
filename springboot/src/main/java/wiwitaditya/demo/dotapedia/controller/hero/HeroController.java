package wiwitaditya.demo.dotapedia.controller.hero;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/heroes")
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping(name = "/")
    public List getAllHeroes(@RequestParam(name = "heroType", required = false) String heroType) {
        log.info("GET /api/heroes, heroType = {}", heroType);
        List response =  heroService.getAllHeroes(heroType);
        log.info("response.size() = {}", response.size());
        return response;
    }
}
