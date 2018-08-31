package alex;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * default description.
 *
 * @author qct
 * @since 1.0
 */
@Configuration
public class MyTopicExchange {

    public static final String TOPIC_ROUTING_KEY = "topic-queue.#";

    public static final String TOPIC_EXCHANGE_NAME = "my-topic-exchange";

    @Bean
    public Queue topicQueue1() {
        return new Queue("my.topic.queue.1");
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("my.topic.queue.2");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingTopicExchangeMessage1(Queue topicQueue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with(TOPIC_ROUTING_KEY);
    }

    @Bean
    public Binding bindingTopicExchangeMessage2(Queue topicQueue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with(TOPIC_ROUTING_KEY);
    }
}
