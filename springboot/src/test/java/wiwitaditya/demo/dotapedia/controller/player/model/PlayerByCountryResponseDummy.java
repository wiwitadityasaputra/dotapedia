package wiwitaditya.demo.dotapedia.controller.player.model;

import java.util.Arrays;
import java.util.List;

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

    public static List<PlayerByCountryResponse> findTop3Players() {
        return Arrays.asList(get(), get(), get());
    }

    public static List<PlayerByCountryResponse> findByCountries() {
        return Arrays.asList(get());
    }
}
