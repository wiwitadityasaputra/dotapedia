package wiwitaditya.demo.dotapedia.controller.news.model;

import java.util.Arrays;
import java.util.List;

public class NewsApiArticleDummy {

    public static NewsApiArticle get() {
        NewsApiArticle article = new NewsApiArticle();
        article.setAuthor("author");
        article.setTitle("title");
        article.setDescription("description");
        article.setUrl("url");
        article.setUrlToImage("url-to-image");
        article.setPublishedAt("published-at");
        article.setContent("content");
        return article;
    }

    public static List<NewsApiArticle> getNews() {
        return Arrays.asList(get(), get(), get(), get(), get(), get());
    }
}
