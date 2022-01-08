package wiwitaditya.demo.dotapedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DotapediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DotapediaApplication.class, args);
    }

    @GetMapping("/hello-world")
    public String index() {
        return "Hello World!";
    }

}
