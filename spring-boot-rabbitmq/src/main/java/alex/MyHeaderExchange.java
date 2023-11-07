package alex;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * default description.
 *
 * @author qct
 * @since 1.0
 */
@Configuration
public class MyHeaderExchange {

    public static final String HEADERS_EXCHANGE_NAME = "my-headers-exchange";

    @Bean
    public Queue headersQueue1() {
        return new Queue("my.headers.queue.1");
    }

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(HEADERS_EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingHeadersExchangeMessage1(Queue headersQueue1, HeadersExchange headersExchange) {
        return BindingBuilder.bind(headersQueue1)
                .to(headersExchange)
                .whereAny("age")
                .exist();
    }
}
