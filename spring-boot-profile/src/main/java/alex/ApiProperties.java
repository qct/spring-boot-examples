package alex;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <code>@PropertySource</code> only works with *.properties, not *.yml.
 *
 * <p>Created by qct on 2017/11/18.
 */
@Component
@PropertySource("classpath:config-${spring.profiles.active}.properties")
@ConfigurationProperties(prefix = "finance")
public class ApiProperties {

    private String name;

    private final Node node = new Node();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNode() {
        return node;
    }

    public static class Node {
        private int deadThreshold;
        private int deleteThreshold;
        private int port;

        public int getDeadThreshold() {
            return deadThreshold;
        }

        public void setDeadThreshold(int deadThreshold) {
            this.deadThreshold = deadThreshold;
        }

        public int getDeleteThreshold() {
            return deleteThreshold;
        }

        public void setDeleteThreshold(int deleteThreshold) {
            this.deleteThreshold = deleteThreshold;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }
}
