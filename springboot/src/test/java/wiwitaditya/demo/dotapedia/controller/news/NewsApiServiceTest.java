package wiwitaditya.demo.dotapedia.controller.news;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import wiwitaditya.demo.dotapedia.controller.news.model.NewsApiArticle;
import wiwitaditya.demo.dotapedia.controller.news.model.NewsApiResponse;
import wiwitaditya.demo.dotapedia.controller.news.model.NewsApiResponseDummy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class NewsApiServiceTest {

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private NewsApiConfig newsApiConfig;

    @InjectMocks
    private NewsApiService newsApiService;

    @Test
    public void getNews() {
        NewsApiResponse newsApiResponse = NewsApiResponseDummy.get();
        Mockito.when(restTemplate.getForEntity(any(), any())).thenReturn(new ResponseEntity(newsApiResponse, HttpStatus.OK));
        Mockito.when(newsApiConfig.getUpdateInterval()).thenReturn(10);
        List<NewsApiArticle> articles =  newsApiService.getNews();
        assertEquals(articles, newsApiResponse.getArticles());
    }

    @Test
    public void getNews_doUpdate_true() {
        NewsApiResponse newsApiResponse = NewsApiResponseDummy.get();
        Mockito.when(restTemplate.getForEntity(any(), any())).thenReturn(new ResponseEntity(newsApiResponse, HttpStatus.OK));
        Mockito.when(newsApiConfig.getUpdateInterval()).thenReturn(0);

        // call two times for coverage purpose
        newsApiService.getNews();
        List<NewsApiArticle> articles =  newsApiService.getNews();

        assertEquals(articles, newsApiResponse.getArticles());
    }
}
