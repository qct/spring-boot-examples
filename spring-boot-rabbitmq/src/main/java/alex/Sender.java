package alex;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
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
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
