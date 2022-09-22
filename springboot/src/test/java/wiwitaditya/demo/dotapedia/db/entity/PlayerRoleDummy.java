package wiwitaditya.demo.dotapedia.db.entity;

import java.util.Arrays;
import java.util.List;

public class PlayerRoleDummy {

    public static PlayerRole get() {
        PlayerRole pg = new PlayerRole();
        pg.setId(1);
        pg.setName("name");
        pg.setActive(true);
        return pg;
    }

    public static List<PlayerRole> findAll() {
        return Arrays.asList(get());
    }
}
