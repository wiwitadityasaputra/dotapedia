package wiwitaditya.demo.dotapedia.controller.series.model;

import wiwitaditya.demo.dotapedia.db.utility.GameSide;

import java.util.Arrays;

public class GameResponseDummy {

    public static GameResponse get() {
        GameResponse gr = new GameResponse();

        gr.setGameId(1);
        gr.setWinner(GameSide.RADIANT);
        gr.setStartDate(2);

        gr.setRadiantTeamId(3);
        gr.setRadiantTeamName("rad-team-name");
        gr.setRadiantScore(4);
        gr.setRadiantPlayers(Arrays.asList(PlayerGameResponseDummy.get()));

        gr.setDireTeamId(5);
        gr.setDireTeamName("dire-team-name");
        gr.setDireScore(6);
        gr.setDirePlayers(Arrays.asList(PlayerGameResponseDummy.get()));
        return gr;
    }
}
