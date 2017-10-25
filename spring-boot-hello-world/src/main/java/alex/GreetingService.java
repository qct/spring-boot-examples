package alex;

import org.springframework.stereotype.Service;

/**
 * <p>Created by qct on 2017/10/20.
 */
@Service
public class GreetingService {

    public String greeting() {
        return "Hello, World!";
    }
}
