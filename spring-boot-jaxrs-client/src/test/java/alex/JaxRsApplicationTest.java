package alex;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import si.mazi.rescu.RestProxyFactory;

/** Created by qct on 2017/11/6. */
public class JaxRsApplicationTest {

    private static final String SERVICE_URI = "http://127.0.0.1:8080";
    public static final String EXPECTED = "world";

    /** works unless remove dependency of cxf-rt-rs-client */
    @Test
    public void testMessageWithJerseyProxyClient() throws Exception {
        ClientConfig c = new ClientConfig().register(Endpoint.class);
        Client resource = ClientBuilder.newClient(c);
        Endpoint proxy = WebResourceFactory.newResource(Endpoint.class, resource.target(SERVICE_URI));

        Greeting greeting = proxy.message();
        Assertions.assertEquals(EXPECTED, greeting.getMessage());
    }

    //    @Test
    //    public void testMessageWithCxfProxy() throws Exception {
    //        List<JacksonJsonProvider> providers = new ArrayList<>();
    //        Collections.addAll(providers, new JacksonJsonProvider());
    //        Endpoint proxy = JAXRSClientFactory.create(SERVICE_URI, Endpoint.class, providers);
    //
    //        Greeting greeting = proxy.message();
    //        Assert.assertEquals(EXPECTED, greeting.getMessage());
    //    }

    @Test
    public void testMessageWithRescu() throws Exception {
        Endpoint proxy = RestProxyFactory.createProxy(Endpoint.class, SERVICE_URI);

        Greeting greeting = proxy.message();
        Assertions.assertEquals(EXPECTED, greeting.getMessage());
    }
}
