package alex;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import si.mazi.rescu.RestProxyFactory;

/** Created by qct on 2017/11/6. */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JaxRsApplicationTest {

    public static final String EXPECTED = "world";

    @LocalServerPort private int port;

    private String serviceUri;

    @BeforeEach
    void setUp() {
        serviceUri = "http://localhost:" + port;
    }

    /** works unless remove dependency of cxf-rt-rs-client */
    @Test
    public void testMessageWithJerseyProxyClient() throws Exception {
        ClientConfig c = new ClientConfig().register(Endpoint.class);
        Client resource = ClientBuilder.newClient(c);
        Endpoint proxy = WebResourceFactory.newResource(Endpoint.class, resource.target(serviceUri));

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
        Endpoint proxy = RestProxyFactory.createProxy(Endpoint.class, serviceUri);

        Greeting greeting = proxy.message();
        Assertions.assertEquals(EXPECTED, greeting.getMessage());
    }
}
