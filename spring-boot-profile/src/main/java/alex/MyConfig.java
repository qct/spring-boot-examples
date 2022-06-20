package alex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Created by qct on 2017/10/7. */
@Configuration
public class MyConfig {

    @Value("${user.dada}")
    private String name;

    @Value("${user.address}")
    private String address;

    @Bean
    public String test() {
        System.out.println("|||||||||||||||||||||||||||||||" + name);
        System.out.println("|||||||||||||||||||||||||||||||" + address);
        return null;
    }
}
