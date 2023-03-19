package wiwitaditya.demo.dotapedia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("forward:/index.html");
        registry.addViewController("/tournament").setViewName("forward:/index.html");
        registry.addViewController("/team").setViewName("forward:/index.html");
        registry.addViewController("/player").setViewName("forward:/index.html");
        registry.addViewController("/hero").setViewName("forward:/index.html");
        registry.addViewController("/schedule").setViewName("forward:/index.html");
        registry.addViewController("/news").setViewName("forward:/index.html");
    }

}
