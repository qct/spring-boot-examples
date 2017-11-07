package alex;

import org.springframework.stereotype.Component;

/**
 * <p>Created by qct on 2017/11/6.
 */
@Component
public class EndpointImpl implements Endpoint {

    @Override
    public Greeting message() {
        return new Greeting("world");
    }
}
