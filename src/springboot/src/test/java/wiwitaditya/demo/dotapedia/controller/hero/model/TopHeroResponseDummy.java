package wiwitaditya.demo.dotapedia.controller.hero.model;

import wiwitaditya.demo.dotapedia.controller.home.model.TopHeroResponse;

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
                return "image-name";
            }

            @Override
            public int getTotal() {
                return 2;
            }
        };
    }
}
