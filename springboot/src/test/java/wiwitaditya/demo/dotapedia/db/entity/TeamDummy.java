package wiwitaditya.demo.dotapedia.db.entity;

import wiwitaditya.demo.dotapedia.db.utility.Region;

import java.util.ArrayList;
import java.util.List;

public class TeamDummy {

    public static List<Team> findTop3Teams() {
        List<Team> teams = new ArrayList();
        teams.add(get());
        teams.add(get());
        teams.add(get());
        return teams;
    }

    public static Team get() {
        Team team = new Team();
        team.setId(1);
        team.setName("name");
        team.setShortName("short-name");
        team.setImage("image");
        team.setRegion(Region.CHINA);
        team.setSponsors("sponsors");
        team.setTotalEarnings(2l);
        team.setBiography("biography");
        return team;
    }
}
