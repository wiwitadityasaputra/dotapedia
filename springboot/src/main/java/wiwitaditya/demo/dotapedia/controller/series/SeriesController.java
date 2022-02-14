package wiwitaditya.demo.dotapedia.controller.series;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wiwitaditya.demo.dotapedia.controller.series.model.SeriesResponse;

@RestController
@RequestMapping(path = "/api/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @GetMapping(path = "/{seriesId}")
    public SeriesResponse getSeries(@PathVariable(value = "seriesId") int seriesId) {
        return seriesService.getSeries(seriesId);
    }
}
