package alex;

import static alex.MyDirectExchange.DIRECT_EXCHANGE_NAME;
import static alex.MyDirectExchange.DIRECT_ROUTING_KEY1;
import static alex.MyFanoutExchange.FANOUT_EXCHANGE_NAME;
import static alex.MyHeaderExchange.HEADERS_EXCHANGE_NAME;
import static alex.MyTopicExchange.TOPIC_EXCHANGE_NAME;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * <p>Created by qct on 2017/2/16.
 */
@Component
public class Sender implements CommandLineRunner {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {
        String context = "hello" + new Date();
        System.out.println("Sender: " + context);


        this.rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, "topic-queue.login", context);
        this.rabbitTemplate.convertAndSend(FANOUT_EXCHANGE_NAME, "", context);
        this.rabbitTemplate.convertAndSend(DIRECT_EXCHANGE_NAME, DIRECT_ROUTING_KEY1, context);
//        this.rabbitTemplate.convertAndSend(DIRECT_EXCHANGE_NAME, DIRECT_ROUTING_KEY2, context);

        Message headerMsg = MessageBuilder.<String>withBody(context.getBytes()).setHeader("age", 21)
            .build();
        this.rabbitTemplate.convertAndSend(HEADERS_EXCHANGE_NAME, "", headerMsg);
    }
}
