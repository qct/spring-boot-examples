package alex;

import java.util.List;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/** Created by qct on 2017/2/16. */
@Component
public class Receiver {

    @RabbitListener(queues = "my.topic.queue.3", containerFactory = "myMessageListListenerContainerFactory")
    public void processObj(List<MyMessage> myMessages) {
        System.out.println("MyMessage List Receiver: " + myMessages.size());
        for (MyMessage myMessage : myMessages) {
            System.out.println("List Receiver: " + myMessage);
        }
    }

    @RabbitListener(queues = "my.topic.queue.2", containerFactory = "myMessageListenerContainerFactory")
    public void handleMyMessage(MyMessage myMessage) {
        System.out.println("MyMessage Receiver: " + myMessage);
    }

    @RabbitListener(queues = "my.topic.queue.1")
    public void handleString(String hello) {
        System.out.println("String Receiver: " + hello);
    }
}
