package alex;

import javax.net.ssl.SSLContext;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.client.TestRestTemplate.HttpClientOption;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/** Created by qct on 2017/10/20. */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @Value("${server.ssl.key-store}")
    private Resource keyStore;

    @Value("${server.ssl.key-store-password}")
    private String keyStorePassword;

    @LocalServerPort private int port;

    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setup() throws Exception {
        SSLContext sslContext =
                new SSLContextBuilder()
                        .loadTrustMaterial(
                                keyStore.getURL(), keyStorePassword.toCharArray(), new TrustSelfSignedStrategy())
                        .build();
        SSLConnectionSocketFactory socketFactory =
                new SSLConnectionSocketFactory(
                        sslContext, new String[] {"TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
        HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplateBuilder rtb = new RestTemplateBuilder().requestFactory(() -> factory);
        this.restTemplate = new TestRestTemplate(rtb, null, null, HttpClientOption.SSL);
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        Assertions.assertThat(
                        this.restTemplate.getForObject("https://localhost:" + port + "/", String.class))
                .contains("Hello, World!");
    }
}
