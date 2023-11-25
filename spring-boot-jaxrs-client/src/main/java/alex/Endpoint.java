package alex;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/** Created by qct on 2017/11/6. */
@Path("/hello")
public interface Endpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Greeting message();
}
