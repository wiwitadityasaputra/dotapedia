package wiwitaditya.demo.dotapedia.db.entity;

import java.util.Arrays;
import java.util.List;

public class PlayerScreenshotDummy {

    public static PlayerScreenshot get() {
        PlayerScreenshot ps = new PlayerScreenshot();
        ps.setId(1);
        ps.setPlayerId(2);
        ps.setImageName("image-name");
        return ps;
    }

    public static List<PlayerScreenshot> findScreenshots() {
        return Arrays.asList(get());
    }
}
