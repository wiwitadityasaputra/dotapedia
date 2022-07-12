package wiwitaditya.demo.dotapedia;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@RestController
public class DotapediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DotapediaApplication.class, args);
        String message = "spring-boot starting...";
        log.trace("test trace log, {}", message);
        log.debug("test debug log, {}", message);
        log.info("test info log, {}", message);
        log.warn("test warn log, {}", message);
        log.error("test error log, {}", message);
    }

    @GetMapping("/hello-world")
    public String index() {
        return "Hello World!";
    }

}
