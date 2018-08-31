package alex;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
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
public class MyDirectExchange {

    public static final String DIRECT_EXCHANGE_NAME = "my-direct-exchange";
    public static final String DIRECT_ROUTING_KEY1 = "direct-queue.1";
    public static final String DIRECT_ROUTING_KEY2 = "direct-queue.2";

    @Bean
    public Queue directQueue1() {
        return new Queue("direct-queue.1");
    }

    @Bean
    public Queue directQueue2() {
        return new Queue("direct-queue.2");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingDirectExchangeMessage1(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with(DIRECT_ROUTING_KEY1);
    }

    @Bean
    public Binding bindingDirectExchangeMessage2(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with(DIRECT_ROUTING_KEY2);
    }
}
