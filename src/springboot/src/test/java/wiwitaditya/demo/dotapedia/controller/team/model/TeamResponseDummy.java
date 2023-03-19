package wiwitaditya.demo.dotapedia.controller.team.model;

import wiwitaditya.demo.dotapedia.db.utility.Region;

import java.util.Arrays;
import java.util.List;

public class TeamResponseDummy {

    public static TeamResponse get() {
        TeamResponse teamResponse = new TeamResponse();
        teamResponse.setTeamId(1);
        teamResponse.setName("name");
        teamResponse.setShortName("short-name");
        teamResponse.setImage("image");
        teamResponse.setRegion(Region.NORTH_AMERICA);
        teamResponse.setSponsors("sponsors");
        teamResponse.setTotalEarnings(2);
        return teamResponse;
    }

    public static List<TeamResponse> getTeamAndRoster() {
        return Arrays.asList(get());
    }
}
