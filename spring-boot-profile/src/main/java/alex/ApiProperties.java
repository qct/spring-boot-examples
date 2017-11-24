package alex;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <p>Created by damon.q on 2017/11/18.
 */
@Component
@PropertySource("classpath:config-${spring.profiles.active}.yml")
@ConfigurationProperties(prefix = "finance.api")
public class ApiProperties {

    private int nodeThresholdDead;
    private int nodeThresholdDelete;
    private int port;

    public int getNodeThresholdDead() {
        return nodeThresholdDead;
    }

    public void setNodeThresholdDead(int nodeThresholdDead) {
        this.nodeThresholdDead = nodeThresholdDead;
    }

    public int getNodeThresholdDelete() {
        return nodeThresholdDelete;
    }

    public void setNodeThresholdDelete(int nodeThresholdDelete) {
        this.nodeThresholdDelete = nodeThresholdDelete;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
