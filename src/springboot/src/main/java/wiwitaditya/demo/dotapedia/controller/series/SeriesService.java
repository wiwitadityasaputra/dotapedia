package wiwitaditya.demo.dotapedia.controller.series;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.controller.series.model.SeriesResponse;
import wiwitaditya.demo.dotapedia.db.entity.*;
import wiwitaditya.demo.dotapedia.db.repository.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerGameRepository playerGameRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerRoleRepository playerRoleRepository;
    @Autowired
    private HeroRepository heroRepository;

    public SeriesResponse getSeries(int seriesId) {
        log.info("getSereis seriesId = {}", seriesId);
        Series series = seriesRepository.findById(seriesId).orElse(null);
        if (series == null) {
            return new SeriesResponse();
        }
        List<Game> games = gameRepository.findBySeriesId(seriesId);

        List<Integer> playerIds = new ArrayList();
        List<Integer> heroIds = new ArrayList();
        List<PlayerGame> playerGames = new ArrayList();
        for (Game game: games) {
            playerGames.addAll(playerGameRepository.findByGameId(game.getId()));
        }

        playerGames.stream().forEach( pg -> {
            playerIds.add(pg.getPlayerId());
            heroIds.add(pg.getHeroId());
        });

        log.info("teamA id = {}, teamB id = {}", series.getTeamIdA(), series.getTeamIdB());
        Team teamA = teamRepository.findById(series.getTeamIdA()).orElse(null);
        Team teamB = teamRepository.findById(series.getTeamIdB()).orElse(null);
        List<Player> players = playerRepository.findByPlayerIds(playerIds);
        List<PlayerRole> playerRoles = playerRoleRepository.findAll();
        List<Hero> heroes = heroRepository.findByHeroIds(heroIds);

        SeriesResponse seriesResponse = SeriesMapping.toSeriesResponse(series, teamA, teamB, games, playerGames,
            players, playerRoles, heroes);

        return seriesResponse;
    }
}
