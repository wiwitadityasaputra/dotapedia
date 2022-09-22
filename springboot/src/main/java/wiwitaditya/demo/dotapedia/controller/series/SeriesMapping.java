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

        List<GameResponse> gameResponses = new ArrayList();
        for (Game game: games) {
            GameResponse gameResponse = toGameResponse(game, teamA, teamB);
            playerGames.stream()
                .filter( pg -> pg.getGameId().equals(game.getId()) )
                .forEach( pg -> {
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
        GameResponse gameResponse = new GameResponse();
        gameResponse.setGameId(game.getId());
        gameResponse.setWinner(game.getWinner());
        gameResponse.setStartDate(game.getMatchDate());

        Team radiantTeam = findTeam(game.getRadiantTeamId(), teamA, teamB);
        gameResponse.setRadiantTeamId(radiantTeam.getId());
        gameResponse.setRadiantTeamName(radiantTeam.getShortName());
        gameResponse.setRadiantScore(game.getRadiantScore());
        gameResponse.setRadiantPlayers(new ArrayList());

        Team direTeam = findTeam(game.getDireTeamId(), teamA, teamB);
        gameResponse.setDireTeamId(direTeam.getId());
        gameResponse.setDireTeamName(direTeam.getShortName());
        gameResponse.setDireScore(game.getDireScore());
        gameResponse.setDirePlayers(new ArrayList());

        return gameResponse;
    }

    private static Team findTeam(Integer teamId, Team teamA, Team teamB) {
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

        PlayerGameResponse pgs = new PlayerGameResponse();
        pgs.setPlayerGameId(playerGame.getId());

        Player player = players.stream()
                .filter( p -> p.getId().equals(playerGame.getPlayerId()))
                .findFirst()
                .orElse(null);
        pgs.setPlayerId(playerGame.getPlayerId());
        pgs.setPlayerNickname(player.getNickName());

        PlayerRole playerRole = playerRoles.stream()
                        .filter( pl -> pl.getId().equals(playerGame.getRoleId()))
                        .findFirst()
                        .orElse(null);
        pgs.setRoleId(playerGame.getRoleId());
        pgs.setRoleName(playerRole.getName());

        Hero hero = heroes.stream()
                        .filter( h -> h.getId().equals(playerGame.getHeroId()))
                        .findFirst()
                        .orElse(null);
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

        return pgs;
    }
}
