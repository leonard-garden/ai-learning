package org.leonard.garden.ai_learning.configuration;

import com.anthropic.client.AnthropicClient;
import com.anthropic.client.okhttp.AnthropicOkHttpClient;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.anthropic")
@Slf4j
@Setter
public class AnthropicConfiguration {
    private String apiKey;

    @Bean
    public AnthropicClient anthropicClient() {
        return new AnthropicOkHttpClient.Builder()
                .apiKey(apiKey)
                .build();
    }
}
