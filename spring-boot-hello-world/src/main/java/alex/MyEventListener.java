package alex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * <p>Created by Damon.Q on 2017/2/25.
 */
@Component
public class MyEventListener {

    private static final Logger logger = LoggerFactory.getLogger(MyEventListener.class);

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Async
    @EventListener(classes = EventA.class)
    public void handleEventA(EventA event) {
        int i = 0;
        if (event.getId() % 2 == 0) {
            i = 10;
        }
        logger.info("received event A[{}], i={}", event.getId(), i);
        try {
            Thread.sleep(event.getId() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("after sleep, event A[{}], i={}", event.getId(), i);
        applicationEventPublisher.publishEvent(new EventB(999));
    }

    @EventListener(classes = EventB.class)
    @Async
    public void handleEventB(EventB event) {
        logger.info("received event B... {}", event);
    }
}

class EventA {

    private int id;

    public EventA(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class EventB {

    private int id;

    public EventB(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
