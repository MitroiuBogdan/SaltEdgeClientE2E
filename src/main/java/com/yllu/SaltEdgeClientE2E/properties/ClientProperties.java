package com.yllu.SaltEdgeClientE2E.properties;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "e2e.client")
@Data
@Getter
public class ClientProperties {

    private String host;
    private String getConnection;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getGetConnection() {
        return getConnection;
    }

    public void setGetConnection(String getConnection) {
        this.getConnection = getConnection;
    }
}
