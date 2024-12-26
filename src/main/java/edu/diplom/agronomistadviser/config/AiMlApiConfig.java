package edu.diplom.agronomistadviser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiMlApiConfig {
    private final String apiKey;

    @Autowired
    public AiMlApiConfig(
            @Value("${aiml.api.key}")
            String apiKey
    ) {
        this.apiKey = apiKey;
    }
    @Bean
    public ApiKeyInterceptor interceptor() {
        return new ApiKeyInterceptor(apiKey);
    }
}
