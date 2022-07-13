package wiwitaditya.demo.dotapedia.controller.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiwitaditya.demo.dotapedia.controller.series.model.SeriesResponse;
import wiwitaditya.demo.dotapedia.db.entity.*;
import wiwitaditya.demo.dotapedia.db.repository.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduleService {

    @Autowired
    private SeriesRepository seriesRepository;

    public List<ScheduleResponse> findUpcomingSeries() {
        return seriesRepository.findUpcomingSeries();
    }
}
