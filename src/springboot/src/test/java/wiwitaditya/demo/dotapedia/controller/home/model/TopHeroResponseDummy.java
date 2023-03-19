package wiwitaditya.demo.dotapedia.controller.home.model;

import java.util.Arrays;
import java.util.List;

public class TopHeroResponseDummy {

    public static TopHeroResponse get() {
        return new TopHeroResponse() {
            @Override
            public int getHeroId() {
                return 1;
            }

            @Override
            public String getName() {
                return "name";
            }

            @Override
            public String getImageName() {
                return "iamge-name";
            }

            @Override
            public int getTotal() {
                return 2;
            }
        };
    }

    public static List<TopHeroResponse> findTop6Hero() {
        return Arrays.asList(get(), get(), get(), get(), get(), get());
    }
}
