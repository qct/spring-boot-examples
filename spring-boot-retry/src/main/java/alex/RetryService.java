package alex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * Created by quchentao on 2017/3/16.
 */
@Service
public class RetryService {

    private static final Logger logger = LoggerFactory.getLogger(RetryService.class);

    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000L, multiplier = 1))
    public String someService() throws Exception {
        int random = (int) (Math.random() * 10);
        if (random < 4) {
            logger.info("random={} Null Pointer Excep", random);
            throw new NullPointerException();
        } else if (random < 9) {
            logger.info("random={} Arithmetic Excep", random);
            throw new ArithmeticException();
        }
        logger.info("random={} ok !!!!", random);
        return "ok";
    }

    @Recover
    public String recover(NullPointerException e) {
        logger.info("{}", "NullPointerException");
        return "null pointer recover";
    }

    @Recover
    public String recover(ArithmeticException ne) {
        logger.info("{}", "ArithmeticException");
        return "ArithmeticException recover";
    }
}
