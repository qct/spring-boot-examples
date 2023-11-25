package alex;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qct on 2017/9/19.
 */
@RestController
@RequestMapping(value = "/private", method = RequestMethod.GET)
public class PrivateController {

    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping
    public String index() {
        return "hello, private!";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id: " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "order id: " + id;
    }
}
