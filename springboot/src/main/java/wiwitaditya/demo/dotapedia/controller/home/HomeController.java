package wiwitaditya.demo.dotapedia.controller.home;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wiwitaditya.demo.dotapedia.controller.home.model.HomeResponse;

@Slf4j
@RestController
@RequestMapping(path = "/api/home")
public class HomeController {

    public final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping(name = "/")
    public HomeResponse getNews() {
        return this.homeService.getHome();
    }
}
