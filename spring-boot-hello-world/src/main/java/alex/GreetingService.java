package alex;

import org.springframework.stereotype.Service;

/**
 * <p>Created by Damon.Q on 2017/10/20.
 */
@Service
public class GreetingService {

    public String greeting() {
        return "Hello, World!";
    }
}
