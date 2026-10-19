package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.bot.DefaultBotProperties;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.handler.HandlerRegistry;
import io.jiogram.middleware.ErrorMiddleware;
import io.jiogram.session.TelegramSession;
import io.jiogram.session.WebClientTelegramSession;
import org.springframework.beans.factory.ObjectProvider;
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
    public TelegramSession telegramSession(
            ObjectProvider<WebClient.Builder> webClientBuilder, JiogramProperties properties) {
        // The WebClient is built here rather than exposed as a bean, so the application's own
        // WebClient beans are neither replaced by nor injected into the Telegram session.
        // Boot's WebClient.Builder (when present) carries the app's codec/connector customizers.
        // To customize the HTTP client further, define your own TelegramSession bean.
        //
        // Intentionally does NOT depend on the application's shared ObjectMapper.
        // The Telegram Bot API rejects null-valued optional parameters, so this
        // session uses its own NON_NULL-configured ObjectMapper internally.
        WebClient webClient = webClientBuilder.getIfAvailable(WebClient::builder).build();
        String baseUrl = properties.api() != null ? properties.api().baseUrl() : null;
        return new WebClientTelegramSession(webClient, baseUrl);
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
