package alex;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.List;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
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

    public static final String TOPIC_ROUTING_KEY = "";

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
    public Queue topicQueue3() {
        return new Queue("my.topic.queue.3");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingTopicExchangeMessage1(Queue topicQueue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("topic-queue.string.#");
    }

    @Bean
    public Binding bindingTopicExchangeMessage2(Queue topicQueue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("topic-queue.my-message.#");
    }

    @Bean
    public Binding bindingTopicExchangeMessage3(Queue topicQueue3, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue3).to(topicExchange).with("topic-queue.list.#");
    }

    @Bean
    public RabbitListenerContainerFactory<?> myMessageListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }

    @Bean
    public RabbitListenerContainerFactory<?> myMessageListListenerContainerFactory(
            ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter() {
            @Override
            public void setJavaTypeMapper(Jackson2JavaTypeMapper javaTypeMapper) {
                super.setJavaTypeMapper(new DefaultJackson2JavaTypeMapper() {
                    @Override
                    public JavaType toJavaType(MessageProperties properties) {
                        JavaType javaType = super.toJavaType(properties);
                        if (javaType instanceof CollectionLikeType) {
                            return TypeFactory.defaultInstance()
                                    .constructCollectionLikeType(List.class, MyMessage.class);
                        } else {
                            return javaType;
                        }
                    }
                });
            }
        });
        return factory;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
