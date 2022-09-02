package wiwitaditya.demo.dotapedia.controller.news.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewsApiResponse {

    private String status;
    private int totalResults;
    private List<NewsApiArticle> articles;
}
