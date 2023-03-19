package wiwitaditya.demo.dotapedia.db.utility;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegionService {

    public List<String> getAllRegions() {
        List<String> result = new ArrayList();
        result.add(Region.WESTERN_EUROPE.toString());
        result.add(Region.EASTERN_EUROPE.toString());
        result.add(Region.CHINA.toString());
        result.add(Region.SOUTHEAST_ASIA.toString());
        result.add(Region.NORTH_AMERICA.toString());
        result.add(Region.SOUTH_AMERICA.toString());
        return result;
    }

    public List<String> toRegions(Region region) {
        List<String> result = new ArrayList();
        result.add(region.toString());
        return result;
    }
}
