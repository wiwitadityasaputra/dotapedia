package wiwitaditya.demo.dotapedia.controller.player.model;

import java.util.Arrays;
import java.util.List;

public class PlayerQuoteResponseDummy {

    public static PlayerQuoteResponse get() {
        return new PlayerQuoteResponse() {
            @Override public String getContent() { return "content"; }
            @Override public String getAuthor() { return "authoer"; }
            @Override public long getCreatedDate() { return 1; }
        };
    }

    public static List<PlayerQuoteResponse> findPlayerId() {
        return Arrays.asList(get());
    }
}
