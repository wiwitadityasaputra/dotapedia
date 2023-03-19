package wiwitaditya.demo.dotapedia.controller.series.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlayerGameResponse {
    private Integer playerGameId;

    private Integer playerId;
    private String playerNickname;

    private Integer roleId;
    private String roleName;

    private Integer heroId;
    private String heroName;
    private String heroImageName;

    private int heroLevel;
    private int kdaKill;
    private int kdaDeath;
    private int kdaAssist;

    private int networth;
    private int gpm;
    private int xpm;

    private int damageToHero;
    private int damageToBuilding;
    private int healing;
}
