package wiwitaditya.demo.dotapedia.controller.news.model;

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
}
