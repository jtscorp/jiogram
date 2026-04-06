package io.jiogram.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.bot.Bot;
import io.jiogram.bot.DefaultBotProperties;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.handler.HandlerRegistry;
import io.jiogram.middleware.ErrorMiddleware;
import io.jiogram.session.TelegramSession;
import io.jiogram.session.WebClientTelegramSession;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Auto-configuration for the core Jiogram Telegram bot components.
 * Creates {@link Bot}, {@link TelegramSession}, {@link Dispatcher}, and {@link HandlerRegistry}
 * beans when the {@code telegram.token} property is present.
 */
@AutoConfiguration
@EnableConfigurationProperties(JiogramProperties.class)
@ConditionalOnProperty(prefix = "telegram", name = "token")
public class JiogramAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public WebClient telegramWebClient() {
        return WebClient.builder().build();
    }

    @Bean
    @ConditionalOnMissingBean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    @ConditionalOnMissingBean
    public TelegramSession telegramSession(WebClient telegramWebClient, ObjectMapper objectMapper) {
        return new WebClientTelegramSession(telegramWebClient, objectMapper);
    }

    @Bean
    @ConditionalOnMissingBean
    public Bot bot(JiogramProperties properties, TelegramSession telegramSession) {
        JiogramProperties.DefaultsProperties defaults = properties.defaults();
        DefaultBotProperties botDefaults;
        if (defaults != null) {
            botDefaults = new DefaultBotProperties(
                defaults.parseMode(),
                defaults.protectContent(),
                defaults.linkPreview()
            );
        } else {
            botDefaults = DefaultBotProperties.defaults();
        }
        return new Bot(properties.token(), telegramSession, botDefaults);
    }

    @Bean
    @ConditionalOnMissingBean
    public Dispatcher dispatcher() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.addOuterMiddleware(new ErrorMiddleware());
        return dispatcher;
    }

    @Bean
    @ConditionalOnMissingBean
    public HandlerRegistry handlerRegistry(Dispatcher dispatcher) {
        return new HandlerRegistry(dispatcher);
    }
}
