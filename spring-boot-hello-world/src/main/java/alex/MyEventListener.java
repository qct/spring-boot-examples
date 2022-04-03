package alex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * <p>Created by qct on 2017/2/25.
 */
@Component
public class MyEventListener {

    private static final Logger logger = LoggerFactory.getLogger(MyEventListener.class);

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @EventListener(classes = EventA.class)
    public void handleEventA(EventA event) {
        logger.info("received event A, {}", event);
        try {
            logger.info("sleep {} seconds...", event.getId() % 3);
            Thread.sleep(event.getId() % 3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        applicationEventPublisher.publishEvent(new EventB(event.getId()));
    }


    @EventListener(classes = EventB.class)
    @Async
    public void handleEventB(EventB event) {
        logger.info("received event B, {}", event);
    }

    private static class EventA {

        private int id;

        EventA(int id) {
            this.id = id;
        }

        int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "EventA{" +
                "id=" + id +
                '}';
        }
    }

    private static class EventB {

        private int id;

        EventB(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "EventB{" +
                "id=" + id +
                '}';
        }
    }
}