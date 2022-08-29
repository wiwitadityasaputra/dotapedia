package wiwitaditya.demo.dotapedia.controller.player.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayerDetailResponse {
    private Integer id;
    private String nickName;
    private String fullName;
    private String roles;
    private long dateOfBirth;
    private String country;
    private String totalEarnings;
    private List<PlayerScreenshotResponse> playerScreenshots;
    private List<PlayerQuoteResponse> quotes;
}
