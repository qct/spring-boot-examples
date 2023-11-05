package alex;

import static alex.MyDirectExchange.DIRECT_EXCHANGE_NAME;
import static alex.MyDirectExchange.DIRECT_ROUTING_KEY1;
import static alex.MyDirectExchange.DIRECT_ROUTING_KEY2;
import static alex.MyFanoutExchange.FANOUT_EXCHANGE_NAME;
import static alex.MyHeaderExchange.HEADERS_EXCHANGE_NAME;
import static alex.MyTopicExchange.TOPIC_EXCHANGE_NAME;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** Created by qct on 2017/2/16. */
@Component
public class Sender implements CommandLineRunner {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {
        String context = "hello" + new Date();
        //        this.rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, "topic-queue.login", context);

        this.rabbitTemplate.convertAndSend(FANOUT_EXCHANGE_NAME, "", context);
        this.rabbitTemplate.convertAndSend(DIRECT_EXCHANGE_NAME, DIRECT_ROUTING_KEY1, context);
        this.rabbitTemplate.convertAndSend(DIRECT_EXCHANGE_NAME, DIRECT_ROUTING_KEY2, context);

        Message headerMsg =
                MessageBuilder.withBody(context.getBytes()).setHeader("age", 21).build();
        this.rabbitTemplate.convertAndSend(HEADERS_EXCHANGE_NAME, "", headerMsg);

        MyMessage myMessage = new MyMessage();
        myMessage.setId("1");
        myMessage.setName("Lei");
        MyMessage myMessage2 = new MyMessage();
        myMessage2.setId("2");
        myMessage2.setName("Jin");

        List<MyMessage> messages = new ArrayList<>();
        messages.add(myMessage);
        messages.add(myMessage2);
        this.rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, "topic-queue.list.1", messages);
        this.rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, "topic-queue.my-message.1", myMessage);
        this.rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, "topic-queue.string.1", context);
    }
}
