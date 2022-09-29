package wiwitaditya.demo.dotapedia.controller.series;

import lombok.extern.slf4j.Slf4j;
import wiwitaditya.demo.dotapedia.controller.series.model.GameResponse;
import wiwitaditya.demo.dotapedia.controller.series.model.PlayerGameResponse;
import wiwitaditya.demo.dotapedia.controller.series.model.SeriesResponse;
import wiwitaditya.demo.dotapedia.db.entity.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SeriesMapping {

    public static SeriesResponse toSeriesResponse(Series series, Team teamA, Team teamB, List<Game> games,
        List<PlayerGame> playerGames, List<Player> players, List<PlayerRole> playerRoles, List<Hero> heroes) {
        log.debug("toSeriesResponse");
        log.debug("playerGames {}", playerGames);
        log.debug("players {}", players);
        log.debug("playerRoles {}", playerRoles);
        log.debug("heroes {}", heroes);

        List<GameResponse> gameResponses = new ArrayList();
        for (Game game: games) {
            log.debug(" game id = {}", game.getId());
            log.debug(" playerGames.size = {}", playerGames.size());
            GameResponse gameResponse = toGameResponse(game, teamA, teamB);
            log.debug(" gameResponse");
            playerGames.stream()
                .filter( pg -> {
                    log.debug("  pg.getGameId() = {}", pg.getGameId());
                    log.debug("  return {}", pg.getGameId().equals(game.getId()));
                    return pg.getGameId().equals(game.getId());
                })
                .forEach( pg -> {
                    log.debug("  pg.getTeamId() = {}", pg.getTeamId());
                    log.debug("  game radiant id = {}", game.getRadiantTeamId());
                    log.debug("  game dire id = {}", game.getDireTeamId());

                    if (pg.getTeamId().equals(game.getRadiantTeamId())) {
                        gameResponse.getRadiantPlayers().add(toPlayerGameResponse(pg, players, playerRoles, heroes));
                    } else if (pg.getTeamId().equals(game.getDireTeamId())) {
                        gameResponse.getDirePlayers().add(toPlayerGameResponse(pg, players, playerRoles, heroes));
                    }
                });

            gameResponses.add(gameResponse);
        }

        SeriesResponse seriesResponse = new SeriesResponse();

        seriesResponse.setSeriesId(series.getId());
        seriesResponse.setStartDate(series.getStartDate());
        seriesResponse.setFormat(series.getFormat());
        seriesResponse.setGames(gameResponses);

        seriesResponse.setTeamAScore(series.getTeamASeriesScore());
        seriesResponse.setTeamBScore(series.getTeamBSeriesScore());

        seriesResponse.setTeamAId(series.getTeamIdA());
        seriesResponse.setTeamBId(series.getTeamIdB());

        seriesResponse.setTeamAName(teamA.getName());
        seriesResponse.setTeamBName(teamB.getName());

        return seriesResponse;
    }

    private static GameResponse toGameResponse(Game game, Team teamA, Team teamB) {
        log.debug("toGameResponse");
        GameResponse gameResponse = new GameResponse();
        gameResponse.setGameId(game.getId());
        gameResponse.setWinner(game.getWinner());
        gameResponse.setStartDate(game.getMatchDate());

        Team radiantTeam = findTeam(game.getRadiantTeamId(), teamA, teamB);
        log.debug("radiantTeam = {}", radiantTeam);
        gameResponse.setRadiantTeamId(radiantTeam.getId());
        gameResponse.setRadiantTeamName(radiantTeam.getShortName());
        gameResponse.setRadiantScore(game.getRadiantScore());
        gameResponse.setRadiantPlayers(new ArrayList());

        Team direTeam = findTeam(game.getDireTeamId(), teamA, teamB);
        log.debug("direTeam = {}", direTeam);
        gameResponse.setDireTeamId(direTeam.getId());
        gameResponse.setDireTeamName(direTeam.getShortName());
        gameResponse.setDireScore(game.getDireScore());
        gameResponse.setDirePlayers(new ArrayList());

        return gameResponse;
    }

    private static Team findTeam(Integer teamId, Team teamA, Team teamB) {
        log.debug("findTeam {} {} {}", teamId, teamA.getId(), teamB.getId());
        if (teamId.equals(teamA.getId())) {
            return teamA;
        } else if (teamId.equals(teamB.getId())) {
            return teamB;
        } else {
            return null;
        }
    }

    private static PlayerGameResponse toPlayerGameResponse(PlayerGame playerGame, List<Player> players,
        List<PlayerRole> playerRoles, List<Hero> heroes) {
        log.debug("toPlayerGameResponse");
        log.debug("players {}", players);
        PlayerGameResponse pgs = new PlayerGameResponse();
        pgs.setPlayerGameId(playerGame.getId());

        Player player = players.stream()
                .filter( p -> {
                    log.debug(" p.getId() {}, playerGame.getPlayerId() = {}", p.getId(), playerGame.getPlayerId());
                    return p.getId().equals(playerGame.getPlayerId());
                })
                .findFirst()
                .orElse(null);
        log.debug("player {}", player);
        pgs.setPlayerId(playerGame.getPlayerId());
        pgs.setPlayerNickname(player.getNickName());

        PlayerRole playerRole = playerRoles.stream()
            .filter( pl -> {
                log.debug(" pl.getId() {}, playerGame.getRoleId() = {}", pl.getId(), playerGame.getRoleId());
                return pl.getId().equals(playerGame.getRoleId());
            })
            .findFirst()
            .orElse(null);
        log.debug("playerRole {}", playerRole);
        pgs.setRoleId(playerGame.getRoleId());
        pgs.setRoleName(playerRole.getName());

        Hero hero = heroes.stream()
            .filter( h -> h.getId().equals(playerGame.getHeroId()))
            .findFirst()
            .orElse(null);
        log.debug("hero {}", hero);
        pgs.setHeroId(playerGame.getHeroId());
        pgs.setHeroName(hero.getName());
        pgs.setHeroImageName(hero.getImageName());

        pgs.setHeroLevel(playerGame.getLevel());
        pgs.setKdaKill(playerGame.getKdaKill());
        pgs.setKdaDeath(playerGame.getKdaDeath());
        pgs.setKdaAssist(playerGame.getKdaAssist());

        pgs.setNetworth(playerGame.getNetworth());
        pgs.setGpm(playerGame.getGoldPerMinute());
        pgs.setXpm(playerGame.getExperiencePerMinute());

        pgs.setDamageToHero(playerGame.getDamageHero());
        pgs.setDamageToBuilding(playerGame.getDamageBuilding());
        pgs.setHealing(playerGame.getHealing());

        log.debug("return pgs");
        return pgs;
    }
}
