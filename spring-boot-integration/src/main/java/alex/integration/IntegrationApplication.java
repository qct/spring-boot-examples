package alex.integration;

import java.io.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.transformer.GenericTransformer;

@SpringBootApplication
public class IntegrationApplication {

    @Bean
    IntegrationFlow files(@Value("${input-directory:${HOME}/Desktop/in}") File in) {
        return IntegrationFlows.from(Files.inboundAdapter(in).autoCreateDirectory(true).preventDuplicates(true))
            .transform(File.class, new GenericTransformer<File, String>() {
                @Override
                public String transform(File file) {
                    return null;
                }
            })
            .handle()
            .get();
    }

    public static void main(String[] args) {
        SpringApplication.run(IntegrationApplication.class, args);
    }
}
