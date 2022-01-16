package wiwitaditya.demo.dotapedia.controller.hero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wiwitaditya.demo.dotapedia.db.repository.HeroRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/api/heroes")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping(name = "/")
    public List getAllHeroes(@RequestParam(name = "heroType", required = false) String heroType) {
        return heroService.getAllHeroes(heroType);
    }
}
