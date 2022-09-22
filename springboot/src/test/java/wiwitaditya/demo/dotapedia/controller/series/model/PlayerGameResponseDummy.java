package wiwitaditya.demo.dotapedia.controller.series.model;

public class PlayerGameResponseDummy {

    public static PlayerGameResponse get() {
        PlayerGameResponse pg = new PlayerGameResponse();

        pg.setPlayerGameId(1);
        pg.setPlayerNickname("nick-name");

        pg.setRoleId(2);
        pg.setRoleName("role-name");

        pg.setHeroId(3);
        pg.setHeroName("hero-name");
        pg.setHeroImageName("hero-image-name");

        pg.setHeroLevel(4);
        pg.setKdaKill(5);
        pg.setKdaDeath(6);
        pg.setKdaAssist(7);

        pg.setNetworth(8);
        pg.setGpm(9);
        pg.setXpm(10);

        pg.setDamageToHero(11);
        pg.setDamageToBuilding(12);
        pg.setHealing(13);
        return pg;
    }
}
