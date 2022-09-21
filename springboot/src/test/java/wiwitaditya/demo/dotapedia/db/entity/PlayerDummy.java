package wiwitaditya.demo.dotapedia.db.entity;

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

    public static Player findById() {
        return get();
    }
}
