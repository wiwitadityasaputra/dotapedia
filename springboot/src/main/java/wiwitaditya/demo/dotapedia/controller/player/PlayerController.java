package wiwitaditya.demo.dotapedia.controller.player;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wiwitaditya.demo.dotapedia.controller.player.model.PlayerDetailResponse;
import wiwitaditya.demo.dotapedia.db.entity.Player;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "/countries")
    public List<PlayerCountry> findPlayerCountries() {
        return playerService.findPlayerCountries();
    }

    @GetMapping
    public List<Player> getPlayersByCountry(@RequestParam(name = "countries") String countries) {
        log.debug("GET /countries/{}", countries);
        return playerService.findByCounties(countries);
    }

    @GetMapping(path = "/{playerId}")
    public PlayerDetailResponse findByPlayerId(@PathVariable(value = "playerId") int playerId) {
        return playerService.findById(playerId);
    }
}
