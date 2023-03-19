package wiwitaditya.demo.dotapedia.controller.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(value = "/upcoming-match")
    private List<ScheduleResponse> findSeriesHasNotStart() {
        return scheduleService.findUpcomingMatch();
    }

    @GetMapping(value = "/latest-match")
    private List<ScheduleResponse> findLatestMatch(
            @RequestParam(name = "region", required = false) String region,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return scheduleService.findLatestMatch(region, size, page);
    }
}
