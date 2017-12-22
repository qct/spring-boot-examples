package alex;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>Created by qct on 2017/2/16.
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello" + new Date();
        System.out.println("Sender: " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
