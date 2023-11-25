package alex;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

/** Created by qct on 2017/10/16. */
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        MessageProducer producer = context.getBean(MessageProducer.class);
        MessageListener listener = context.getBean(MessageListener.class);

        /*
         * Sending a Hello World message to topic 'myTopic'.
         * Must be received by both listeners with group foo
         * and bar with containerFactory fooKafkaListenerContainerFactory
         * and barKafkaListenerContainerFactory respectively.
         * It will also be received by the listener with
         * headersKafkaListenerContainerFactory as container factory
         */
        producer.sendMessage("Hello, World!");
        listener.latch.await(10, TimeUnit.SECONDS);

        /*
         * Sending message to a topic with 5 partition,
         * each message to a different partition. But as per
         * listener configuration, only the messages from
         * partition 0 and 3 will be consumed.
         */
        for (int i = 0; i < 5; i++) {
            producer.sendMessageToPartition("Hello to Partitioned Topic!", i);
        }
        listener.partitionLatch.await(10, TimeUnit.SECONDS);

        /*
         * Sending message to 'filtered' topic. As per listener
         * configuration,  all messages with char sequence
         * 'World' will be discarded.
         */
        producer.sendMessageToFiltered("Hello, bro!");
        producer.sendMessageToFiltered("Hello, World!");
        listener.filteredLatch.await(10, TimeUnit.SECONDS);

        /*
         * Sending message to 'greeting' topic. This will send
         * and received a java object with the help of
         * greetingKafkaListenerContainerFactory.
         */
        producer.sendGreetingMessage(new Greeting("Greetings", "World!"));
        listener.greetingLatch.await(10, TimeUnit.SECONDS);

        context.close();
    }

    @Bean
    public MessageProducer messageProducer() {
        return new MessageProducer();
    }

    @Bean
    public MessageListener messageListener() {
        return new MessageListener();
    }

    public static class MessageProducer {

        @Autowired
        private KafkaTemplate<String, String> kafkaTemplate;

        @Autowired
        private KafkaTemplate<String, Greeting> greetingKafkaTemplate;

        @Value("${topic.name.message}")
        private String topicName;

        @Value("${topic.name.partitioned}")
        private String partitionedTopicName;

        @Value("${topic.name.filtered}")
        private String filteredTopicName;

        @Value("${topic.name.greeting}")
        private String greetingTopicName;

        public void sendMessage(String msg) {
            System.out.println("sending msg: " + msg + ", to: " + topicName);
            kafkaTemplate.send(topicName, msg);
        }

        public void sendMessageToPartition(String msg, int partition) {
            kafkaTemplate.send(partitionedTopicName, partition, msg, msg);
        }

        public void sendMessageToFiltered(String msg) {
            kafkaTemplate.send(filteredTopicName, msg);
        }

        public void sendGreetingMessage(Greeting greeting) {
            greetingKafkaTemplate.send(greetingTopicName, greeting);
        }
    }

    public static class MessageListener {

        private CountDownLatch latch = new CountDownLatch(3);

        private CountDownLatch partitionLatch = new CountDownLatch(2);

        private CountDownLatch filteredLatch = new CountDownLatch(2);

        private CountDownLatch greetingLatch = new CountDownLatch(1);

        @KafkaListener(
                topics = "${topic.name.message}",
                groupId = "foo",
                containerFactory = "fooKafkaListenerContainerFactory")
        public void listenGroupFoo(String msg) {
            System.out.println("Received Message in group 'foo': " + msg);
            latch.countDown();
        }

        @KafkaListener(
                topics = "${topic.name.message}",
                groupId = "bar",
                containerFactory = "barKafkaListenerContainerFactory")
        public void listenGroupBar(String msg) {
            System.out.println("Received Message in group 'bar': " + msg);
            latch.countDown();
        }

        @KafkaListener(topics = "${topic.name.message}", containerFactory = "headersKafkaListenerContainerFactory")
        public void listenWithHeaders(@Payload String msg, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
            System.out.println("Received Message: " + msg + " from header(partition): " + partition);
            latch.countDown();
        }

        @KafkaListener(
                topicPartitions =
                        @TopicPartition(
                                topic = "${topic.name.partitioned}",
                                partitionOffsets = {
                                    @PartitionOffset(partition = "0", initialOffset = "0"),
                                    @PartitionOffset(partition = "3", initialOffset = "0")
                                }))
        //        @KafkaListener(topicPartitions = @TopicPartition(topic = "${topic.name.partitioned}",
        // partitions = {"2", "3"}))
        public void listenToPartition(@Payload String msg, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
            System.out.println("Received Message: " + msg + " from partition: " + partition);
            partitionLatch.countDown();
        }

        @KafkaListener(topics = "${topic.name.filtered}", containerFactory = "filterKafkaListenerContainerFactory")
        public void listenWithFilter(String msg) {
            System.out.println("Received Message in filtered listener: " + msg);
            filteredLatch.countDown();
        }

        @KafkaListener(topics = "${topic.name.greeting}", containerFactory = "greetingKafkaListenerContainerFactory")
        public void greetingListener(Greeting greeting) {
            System.out.println("Received greeting message: " + greeting);
            greetingLatch.countDown();
        }
    }
}
