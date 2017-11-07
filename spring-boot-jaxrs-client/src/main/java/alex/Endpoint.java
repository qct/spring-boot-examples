package alex;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * <p>Created by qct on 2017/11/6.
 */
@Path("/hello")
public interface Endpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Greeting message();
}
