package wiwitaditya.demo.dotapedia.controller.player;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.db.entity.Player;
import wiwitaditya.demo.dotapedia.db.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<PlayerCountry> findPlayerCountries() {
        return playerRepository.findPlayerCountries();
    }

    public List<Player> findByCounties(String countries) {
        log.debug("inside findByCounties");
        if (countries == null) {
            return playerRepository.findAll();
        }
        List<String> countryList = new ArrayList();
        Arrays.stream(countries.split(",")).forEach( country -> {
            countryList.add(country);
        });
        log.debug("countryList.size = {}", countryList.size());
        return playerRepository.findByCounties(countryList);
    }

    public Player findById(int playerId) {
        return playerRepository.findById(playerId).orElse(null);
    }
}
