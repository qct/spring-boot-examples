package alex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/** Created by qct on 2017/9/19. */
@SpringBootApplication
public class Oauth2Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }
}
