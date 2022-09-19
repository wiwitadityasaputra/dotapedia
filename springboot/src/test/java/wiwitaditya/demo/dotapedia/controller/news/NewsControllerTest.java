package wiwitaditya.demo.dotapedia.controller.news;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import wiwitaditya.demo.dotapedia.controller.news.model.NewsApiArticle;
import wiwitaditya.demo.dotapedia.controller.news.model.NewsApiArticleDummy;
import wiwitaditya.demo.dotapedia.db.utility.HeroType;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class NewsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewsApiService newsApiService;

    @Test
    public void getNews() throws Exception {
        List<NewsApiArticle> news = NewsApiArticleDummy.getNews();
        Mockito.when(this.newsApiService.getNews()).thenReturn(news);

        this.mockMvc.perform(get("/api/news"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()", is(6)))
            .andExpect(jsonPath("$[0].author", is(news.get(0).getAuthor())))
            .andExpect(jsonPath("$[0].title", is(news.get(0).getTitle())))
            .andExpect(jsonPath("$[0].description", is(news.get(0).getDescription())))
            .andExpect(jsonPath("$[0].url", is(news.get(0).getUrl())))
            .andExpect(jsonPath("$[0].urlToImage", is(news.get(0).getUrlToImage())))
            .andExpect(jsonPath("$[0].publishedAt", is(news.get(0).getPublishedAt())))
            .andExpect(jsonPath("$[0].content", is(news.get(0).getContent())))
        ;
    }
}
