package wiwitaditya.demo.dotapedia.db.entity;

import java.util.Arrays;
import java.util.List;

public class PlayerDummy {

    public static Player get() {
        Player p = new Player();
        p.setId(1);
        p.setNickName("nick-name");
        p.setFullName("full-name");
        p.setRoles("roles");
        p.setDateOfBirth(2l);
        p.setCountry("country");
        p.setTotalEarnings("123456");
        return p;
    }

    public static Player getById(int playerId) {
        Player p = new Player();
        p.setId(playerId);
        p.setNickName("nick-name");
        p.setFullName("full-name");
        p.setRoles("roles");
        p.setDateOfBirth(2l);
        p.setCountry("country");
        p.setTotalEarnings("123456");
        return p;
    }

    public static Player findById() {
        return get();
    }

    public static List<Player> findByPlayerIds() {
        return Arrays.asList(getById(4));
    }
}
