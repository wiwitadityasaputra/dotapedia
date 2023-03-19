package wiwitaditya.demo.dotapedia.controller.news;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wiwitaditya.demo.dotapedia.controller.news.model.NewsApiArticle;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/news")
public class NewsController {

    @Autowired
    private NewsApiService newsApiService;

    @GetMapping(name = "/")
    public List<NewsApiArticle> getNews() {
        return this.newsApiService.getNews();
    }
}
