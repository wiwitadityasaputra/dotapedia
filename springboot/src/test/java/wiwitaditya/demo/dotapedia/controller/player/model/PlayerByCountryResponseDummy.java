package wiwitaditya.demo.dotapedia.controller.player.model;

public class PlayerByCountryResponseDummy {

    public static PlayerByCountryResponse get() {
        return new PlayerByCountryResponse() {
            @Override
            public int getId() {
                return 1;
            }

            @Override
            public String getNickName() {
                return "nick-name";
            }
        };
    }
}
