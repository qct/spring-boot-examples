package alex;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * <p>Created by qct on 2017/11/6.
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(Endpoint.class);
    }
}
