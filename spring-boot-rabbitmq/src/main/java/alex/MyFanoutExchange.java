package alex;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
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
public class MyFanoutExchange {

    public static final String FANOUT_EXCHANGE_NAME = "my-fanout-exchange";

    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout-queue.1");
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout-queue.2");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingFanoutExchangeMessage1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFanoutExchangeMessage2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
