package alex;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

/**
 * <p>Created by qct on 2017/10/6.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Service
    public static class TestProperties implements InitializingBean{
        @Autowired
        private ApiProperties apiProperties;

        @Override
        public void afterPropertiesSet() throws Exception {
//            System.out.println(apiProperties.getNodeThresholdDead());
//            System.out.println(apiProperties.getNodeThresholdDelete());
//            System.out.println(apiProperties.getPort());
        }
    }
}
