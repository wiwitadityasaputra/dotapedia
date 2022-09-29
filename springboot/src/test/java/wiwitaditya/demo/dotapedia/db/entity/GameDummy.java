package wiwitaditya.demo.dotapedia.db.entity;

import wiwitaditya.demo.dotapedia.db.utility.GameSide;

import java.util.Arrays;
import java.util.List;

public class GameDummy {

    public static Game get() {
        Game game = new Game();
        game.setId(1);
        game.setSeriesId(2);
        game.setRadiantTeamId(1);
        game.setDireTeamId(1);
        game.setMatchDate(5);
        game.setRadiantScore(6);
        game.setDireScore(7);
        game.setWinner(GameSide.RADIANT);
        return game;
    }

    private static Game get1(int radiantTeamId, int direTeamId) {
        Game game = new Game();
        game.setId(1);
        game.setSeriesId(2);
        game.setRadiantTeamId(radiantTeamId);
        game.setDireTeamId(direTeamId);
        game.setMatchDate(5);
        game.setRadiantScore(6);
        game.setDireScore(7);
        game.setWinner(GameSide.RADIANT);
        return game;
    }

    public static List<Game> findBySeriesId() {
        return Arrays.asList(get1(3, 2), get1(3, 2));
    }
}
