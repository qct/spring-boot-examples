package alex;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/** Created by qct on 2017/9/19. */
@RestController
@RequestMapping(value = "/public", method = RequestMethod.GET)
public class PublicController {

    @RequestMapping
    public String index() {
        return "hello, public!";
    }
}
