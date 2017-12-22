package alex;

import com.qianmi.ms.starter.rocketmq.annotation.RocketMQMessageListener;
import com.qianmi.ms.starter.rocketmq.core.RocketMQListener;
import com.qianmi.ms.starter.rocketmq.core.RocketMQTemplate;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Random;
import javax.annotation.Resource;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class RocketMqApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RocketMqApplication.class);

    @Resource
    private RocketMQTemplate rocketMQTemplate;


    public static void main(String[] args) {
        SpringApplication.run(RocketMqApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
//        rocketMQTemplate.convertAndSend("test-topic-1", "Hello, World!");
//        rocketMQTemplate.send("test-topic-1", MessageBuilder.withPayload("Hello, World! I'm from spring").build());
        while (true) {
            rocketMQTemplate.convertAndSend("test-topic-2", new OrderPaidEvent("T_001", new BigDecimal("88.00")));
            int i = new Random().nextInt(60);
            System.out.println("sleep " + i);
            Thread.sleep(1000L * i);
        }
    }

    public static class OrderPaidEvent implements Serializable {

        private String orderId;

        private BigDecimal paidMoney;

        public OrderPaidEvent() {
        }

        public OrderPaidEvent(String orderId, BigDecimal paidMoney) {
            this.orderId = orderId;
            this.paidMoney = paidMoney;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public BigDecimal getPaidMoney() {
            return paidMoney;
        }

        public void setPaidMoney(BigDecimal paidMoney) {
            this.paidMoney = paidMoney;
        }
    }

    @Service
    @RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "my-consumer_test-topic-1")
    public class MyConsumer1 implements RocketMQListener<String> {

        public void onMessage(String message) {
            logger.info("received message: {}", message);
        }
    }

    @Service
    @RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_test-topic-2", messageModel =
        MessageModel.BROADCASTING)
    public class MyConsumer2 implements RocketMQListener<OrderPaidEvent> {

        public void onMessage(OrderPaidEvent orderPaidEvent) {
            logger.info("MyConsumer2 received orderPaidEvent: {}", orderPaidEvent);
        }
    }

    @Service
    @RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_test-topic-3", messageModel =
        MessageModel.BROADCASTING)
    public class MyConsumer3 implements RocketMQListener<OrderPaidEvent> {

        public void onMessage(OrderPaidEvent orderPaidEvent) {
            logger.info("MyConsumer3 received orderPaidEvent: {}", orderPaidEvent);
        }
    }
}
