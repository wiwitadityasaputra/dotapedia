package wiwitaditya.demo.dotapedia.controller.news.model;

import java.util.List;

public class NewsApiResponseDummy {

    public static NewsApiResponse get() {
        List<NewsApiArticle> articles = NewsApiArticleDummy.getNews();

        NewsApiResponse response = new NewsApiResponse();
        response.setStatus("OK");
        response.setTotalResults(articles.size());
        response.setArticles(articles);

        return response;
    }
}
