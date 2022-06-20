package alex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * default description.
 *
 * @author qct
 * @date 2018/3/20
 * @since 1.0
 */
@SpringBootApplication
public class ExtensionExampleApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ExtensionExampleApplication.class);

    private final ApplicationContext applicationContext;

    @Autowired
    public ExtensionExampleApplication(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(ExtensionExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ExampleConfig bean = applicationContext.getBean(ExampleConfig.class);
        logger.info("result: {}", bean);
    }
}
