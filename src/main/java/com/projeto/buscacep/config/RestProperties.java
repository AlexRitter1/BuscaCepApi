package com.projeto.buscacep.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(value = "spring.backend")
public class RestProperties {

    private String host;

    public String getHost() {
        return host;
    }
}
