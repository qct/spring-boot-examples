package alex.integration;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ImageBanner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.Message;
import org.springframework.util.ReflectionUtils;

/**
 * default description.
 *
 * @author qct
 * @since 1.0
 */
// @Configuration
public class FileConvertConfig {

    @Bean
    IntegrationFlow files(@Value("${input-directory:${HOME}/Desktop/in}") File in, Environment environment) {
        GenericTransformer<File, Message<String>> genericTransformer = (File source) -> {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream printStream = new PrintStream(baos)) {
                ImageBanner imageBanner = new ImageBanner(new FileSystemResource(source));
                imageBanner.printBanner(environment, getClass(), printStream);
                return MessageBuilder.withPayload(new String(baos.toByteArray()))
                        .setHeader(
                                FileHeaders.FILENAME, source.getAbsoluteFile().getName())
                        .build();
            } catch (IOException e) {
                ReflectionUtils.rethrowRuntimeException(e);
            }
            return null;
        };
        return IntegrationFlows.from(
                        Files.inboundAdapter(in)
                                .autoCreateDirectory(true)
                                .preventDuplicates(true)
                                .patternFilter("*.jpg"),
                        poller -> poller.poller(pollerFactory -> pollerFactory.fixedRate(1000L)))
                .transform(File.class, genericTransformer)
                .handle(Files.outboundAdapter(in).fileNameGenerator(message -> {
                    Object o = message.getHeaders().get(FileHeaders.FILENAME);
                    String fileName = String.class.cast(o);
                    return fileName.split("\\.")[0] + ".txt";
                }))
                .get();
    }
}
