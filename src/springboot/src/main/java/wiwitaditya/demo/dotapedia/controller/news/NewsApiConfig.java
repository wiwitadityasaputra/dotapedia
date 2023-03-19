package wiwitaditya.demo.dotapedia.controller.news;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "dotapedia.newsapi")
@Setter
@Getter
public class NewsApiConfig {
    private String scheme;
    private String host;
    private String path;
    private String apikey;
    private int updateInterval;
}
