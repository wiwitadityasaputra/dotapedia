package wiwitaditya.demo.dotapedia.controller.tournament.model.detail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamPlayerResponse {
    private Integer playerId;
    private String nickName;

    private Integer roleId;
    private String roleName;
}
