package wiwitaditya.demo.dotapedia.controller.player;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.controller.player.model.PlayerByCountryResponse;
import wiwitaditya.demo.dotapedia.controller.player.model.PlayerDetailResponse;
import wiwitaditya.demo.dotapedia.controller.player.model.PlayerScreenshotResponse;
import wiwitaditya.demo.dotapedia.db.entity.Player;
import wiwitaditya.demo.dotapedia.db.entity.PlayerScreenshot;
import wiwitaditya.demo.dotapedia.db.repository.PlayerQuoteRepository;
import wiwitaditya.demo.dotapedia.db.repository.PlayerRepository;
import wiwitaditya.demo.dotapedia.db.repository.PlayerScreenshotRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerScreenshotRepository screenshotRepository;
    @Autowired
    private PlayerQuoteRepository playerQuoteRepository;

    public List<PlayerCountry> findPlayerCountries() {
        return playerRepository.findPlayerCountries();
    }

    public List<PlayerByCountryResponse> findByCounties(String countries) {
        log.debug("inside findByCounties");
        if (countries == null) {
            return playerRepository.findByCountries();
        }
        List<String> countryList = new ArrayList();
        Arrays.stream(countries.split(",")).forEach( country -> {
            countryList.add(country);
        });
        log.debug("countryList.size = {}", countryList.size());
        return playerRepository.findByCountries(countryList);
    }

    public PlayerDetailResponse findById(int playerId) {
        PlayerDetailResponse response = new PlayerDetailResponse();
        Player p = playerRepository.findById(playerId).orElse(null);
        if (p != null) {
            response.setId(p.getId());
            response.setCountry(p.getCountry());
            response.setDateOfBirth(p.getDateOfBirth());
            response.setFullName(p.getFullName());
            response.setNickName(p.getNickName());
            response.setTotalEarnings(p.getTotalEarnings());
            response.setRoles(p.getRoles());
            response.setBiography(p.getBiography());

            response.setPlayerScreenshots(new ArrayList());
            for (PlayerScreenshot ps: screenshotRepository.findScreenshots(playerId)) {
                response.getPlayerScreenshots().add(new PlayerScreenshotResponse(ps.getId(), ps.getImageName()));
            }

            response.setQuotes(playerQuoteRepository.findPlayerId(p.getId()));
        }
        return response;
    }
}
