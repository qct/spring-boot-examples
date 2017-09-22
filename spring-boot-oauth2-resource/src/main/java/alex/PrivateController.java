package alex;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Created by damon.q on 2017/9/19.
 */
@RestController
@RequestMapping(value = "/private", method = RequestMethod.GET)
public class PrivateController {

    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping
    public String index() {
        return "hello, private!";
    }
}
