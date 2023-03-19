package wiwitaditya.demo.dotapedia.controller.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.controller.LookupUtil;
import wiwitaditya.demo.dotapedia.controller.series.model.SeriesResponse;
import wiwitaditya.demo.dotapedia.db.entity.*;
import wiwitaditya.demo.dotapedia.db.repository.*;
import wiwitaditya.demo.dotapedia.db.utility.Region;
import wiwitaditya.demo.dotapedia.db.utility.RegionService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ScheduleService {

    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private RegionService regionService;

    public List<ScheduleResponse> findUpcomingMatch() {
        return seriesRepository.findUpcomingMatch();
    }

    public List<ScheduleResponse> findLatestMatch(String regionStr, int size, int page) {
        log.debug("findLatestMatch region = {}", regionStr);
        Region region = LookupUtil.lookup(Region.class, regionStr);

        List<String> regions = null;
        if (region != null) {
            regions = regionService.toRegions(region);
        } else {
            regions = regionService.getAllRegions();
        }
        log.debug("regions = {}", regions);

        return seriesRepository.findLatestSeries(regions, size, page);
    }

}
