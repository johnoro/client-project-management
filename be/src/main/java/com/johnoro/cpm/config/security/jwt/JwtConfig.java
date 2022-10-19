package com.johnoro.cpm.config.security.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.jwt")
@NoArgsConstructor @Getter @Setter
public class JwtConfig {
    private String secretKey;
    // figure out if/when to use these
    private String tokenPrefix;
    private Integer tokenExpirationAfterDays;

    public String getAuthorizationsHeader() {
        return "TODO";
    }
}