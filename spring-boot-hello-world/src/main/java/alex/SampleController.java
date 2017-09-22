package alex;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Created by Damon.Q on 2017/2/13.
 */
@Controller
@EnableAutoConfiguration
@EnableAsync
@SpringBootApplication
public class SampleController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    private AtomicInteger count = new AtomicInteger(0);

    @RequestMapping("/")
    @ResponseBody
    String home() {
        applicationEventPublisher.publishEvent(new EventA(count.incrementAndGet()));
        return "Hello, World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}
