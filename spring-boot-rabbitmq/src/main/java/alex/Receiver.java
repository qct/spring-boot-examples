package alex;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>Created by qct on 2017/2/16.
 */
@Component
public class Receiver {

    @RabbitHandler
    @RabbitListener(queues = "hello")
    public void process(String hello) {
        System.out.println("Receiver: " + hello);
    }
}
