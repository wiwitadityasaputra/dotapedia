package wiwitaditya.demo.dotapedia.controller.player.model;

import java.util.Arrays;
import java.util.List;

public class PlayerCountryDummy {

    public static PlayerCountry get() {
        return new PlayerCountry() {
            @Override public String getCountry() { return "country"; }
            @Override public int getTotalPlayer() { return 3; };
        };
    }

    public static List<PlayerCountry> findPlayerCountries() {
        return Arrays.asList(get());
    }
}
