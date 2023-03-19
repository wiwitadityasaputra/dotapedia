package wiwitaditya.demo.dotapedia.controller.news.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsApiArticle {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
}
