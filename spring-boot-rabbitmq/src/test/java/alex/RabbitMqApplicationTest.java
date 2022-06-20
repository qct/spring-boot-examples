package alex;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/** Created by qct on 2017/2/16. */
@SpringBootTest(classes = RabbitMqApplication.class)
public class RabbitMqApplicationTest {

    @Autowired private AmqpTemplate sender;

    @Test
    public void hello() throws Exception {
        sender.convertAndSend("123", "");
    }
}
