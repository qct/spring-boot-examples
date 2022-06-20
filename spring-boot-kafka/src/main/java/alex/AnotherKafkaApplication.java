package alex;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * default description.
 *
 * @author qct
 * @since 1.0
 */
/*@SpringBootApplication
public class AnotherKafkaApplication implements CommandLineRunner {

    private final Producer producer;

    @Autowired
    public AnotherKafkaApplication(Producer producer) {
        this.producer = producer;
    }

    public static void main(String[] args) {
        SpringApplication.run(AnotherKafkaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // producer.sendMessage();
        producer.sendMessageToPartition();
    }
}*/

@Component
class Receiver {

  @KafkaListener(
      topics = "${topic.name.message}",
      groupId = "foo",
      containerFactory = "fooKafkaListenerContainerFactory")
  public void listenGroupFoo(String msg) {
    System.out.println("Received Message in group 'foo': " + msg);
  }

  @KafkaListener(
      topicPartitions =
          @TopicPartition(
              topic = "${topic.name.partitioned}",
              partitions = {"2", "3"}))
  public void listenToPartition(
      @Payload String msg, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
    System.out.println("Received Message: " + msg + " from partition: " + partition);
  }
}

@Component
class Producer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Value("${topic.name.message}")
  private String topicName;

  @Value("${topic.name.partitioned}")
  private String partitionedTopicName;

  @Autowired
  public Producer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage() {
    Executors.newSingleThreadScheduledExecutor()
        .scheduleWithFixedDelay(
            () -> {
              String msg = "test-message" + new Random().nextInt(10000);
              System.out.println("sending msg: " + msg + ", to: " + topicName);
              kafkaTemplate.send(topicName, msg);
            },
            10L,
            10L,
            TimeUnit.SECONDS);
  }

  public void sendMessageToPartition() {
    Executors.newSingleThreadScheduledExecutor()
        .scheduleWithFixedDelay(
            () -> {
              String message = "Hello to Partitioned Topic!" + new Random().nextInt(10000);
              for (int i = 0; i < 5; i++) {
                System.out.println("sending msg: " + message + ", to: " + partitionedTopicName);
                kafkaTemplate.send(partitionedTopicName, i, message, message);
              }
            },
            10L,
            10L,
            TimeUnit.SECONDS);
  }
}
