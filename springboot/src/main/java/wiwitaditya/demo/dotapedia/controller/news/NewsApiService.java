package wiwitaditya.demo.dotapedia.controller.news;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import wiwitaditya.demo.dotapedia.controller.news.model.NewsApiArticle;
import wiwitaditya.demo.dotapedia.controller.news.model.NewsApiResponse;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class NewsApiService {

    @Value(value = "${dotapedia.newsapi.apikey}")
    private String apikey;

    private List<NewsApiArticle> articles;
    private Date latestUpdate = new Date();

    private void checkUpdate() {
        log.debug("inside checkUpdate()");
        long diffInMillies = Math.abs(latestUpdate.getTime() - (new Date()).getTime());
        long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
        boolean doUpdate = diff >= 10;
        log.debug("this.articles == null = ", (this.articles == null));
        log.debug("inside diffInMillies({}), diff({}), doUpdate({})", diffInMillies, diff, doUpdate);

        if (this.articles == null || doUpdate) {
            RestTemplate restTemplate = new RestTemplate();
            UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host("newsapi.org")
                    .path("v2/top-headlines")
                    .queryParam("sources", "techcrunch")
                    .queryParam("apiKey", apikey);
            URI uri = builder.build().toUri();
            log.debug("uri = {}", uri);
            ResponseEntity<NewsApiResponse> response = restTemplate.getForEntity(uri, NewsApiResponse.class);
            this.articles = response.getBody().getArticles();
            this.latestUpdate = new Date();
        }
    }

    public List<NewsApiArticle> getNews() {
        log.debug("inside getNews()");
        checkUpdate();
        return this.articles;
    }
}
