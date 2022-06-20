package alex;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/** Created by qct on 2017/10/6. */
@SpringBootApplication
public class ProfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileApplication.class, args);
    }

    @Component
    public static class TestProperties implements InitializingBean {

        @Autowired private ApiProperties apiProperties;

        @Override
        public void afterPropertiesSet() {
            System.out.println(apiProperties.getName());
            System.out.println(apiProperties.getNode().getDeadThreshold());
            System.out.println(apiProperties.getNode().getDeleteThreshold());
            System.out.println(apiProperties.getNode().getPort());
        }
    }
}
