package wiwitaditya.demo.dotapedia.controller.team.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeamPlayerResponse {

    private int playerId;
    private String fullName;
    private String nickName;

    private int playerRoleId;
    private String role;
}
