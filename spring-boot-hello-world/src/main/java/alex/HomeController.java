package alex;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** Created by qct on 2017/10/20. */
@Controller
public class HomeController {

    private final GreetingService greetingService;

    private AtomicInteger count = new AtomicInteger(0);

    public HomeController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return greetingService.greeting() + count.incrementAndGet();
    }
}
