package wiwitaditya.demo.dotapedia.db.entity;

import java.util.Arrays;
import java.util.List;

public class PlayerGameDummy {

    public static PlayerGame get() {
        PlayerGame pg = new PlayerGame();
        pg.setId(1);
        pg.setGameId(1);
        pg.setTeamId(3);
        pg.setPlayerId(4);
        pg.setHeroId(5);
        pg.setRoleId(6);
        pg.setLevel(7);
        pg.setKdaKill(8);
        pg.setKdaDeath(9);
        pg.setKdaAssist(10);
        pg.setNetworth(11);
        pg.setGoldPerMinute(12);
        pg.setExperiencePerMinute(13);
        pg.setDamageHero(14);
        pg.setDamageBuilding(15);
        pg.setHealing(16);
        return pg;
    }

    public static PlayerGame get1(int teamId) {
        PlayerGame pg = new PlayerGame();
        pg.setId(1);
        pg.setGameId(1);
        pg.setTeamId(teamId);
        pg.setPlayerId(4);
        pg.setHeroId(1);
        pg.setRoleId(6);
        pg.setLevel(7);
        pg.setKdaKill(8);
        pg.setKdaDeath(9);
        pg.setKdaAssist(10);
        pg.setNetworth(11);
        pg.setGoldPerMinute(12);
        pg.setExperiencePerMinute(13);
        pg.setDamageHero(14);
        pg.setDamageBuilding(15);
        pg.setHealing(16);
        return pg;
    }

    public static List<PlayerGame> findByGameId() {
        return Arrays.asList(get1(3), get1(2));
    }
}
