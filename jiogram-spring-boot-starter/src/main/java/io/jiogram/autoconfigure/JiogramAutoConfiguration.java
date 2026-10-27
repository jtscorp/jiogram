package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.bot.DefaultBotProperties;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.handler.HandlerRegistry;
import io.jiogram.middleware.ErrorMiddleware;
import io.jiogram.session.TelegramSession;
import io.jiogram.session.TokenMaskingObservationConvention;
import io.jiogram.session.WebClientTelegramSession;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.util.unit.DataSize;
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
            ObjectProvider<WebClient.Builder> webClientBuilder, JiogramProperties properties, Environment environment) {
        // The WebClient is built here rather than exposed as a bean, so the application's own
        // WebClient beans are neither replaced by nor injected into the Telegram session.
        // Boot's WebClient.Builder (when present) carries the app's codec/connector customizers.
        // To customize the HTTP client further, define your own TelegramSession bean.
        //
        // Intentionally does NOT depend on the application's shared ObjectMapper.
        // The Telegram Bot API rejects null-valued optional parameters, so this
        // session uses its own NON_NULL-configured ObjectMapper internally.
        //
        // The token is part of every request URL, so the observation convention masks it in the
        // metrics and traces of the client. The response size limit replaces the builder's codec
        // limit: a full getUpdates batch does not fit into the default 256 KB.
        JiogramProperties.ApiProperties api = properties.api();
        DataSize maxResponseSize = api != null
            ? api.maxResponseSize()
            : JiogramProperties.ApiProperties.DEFAULT_MAX_RESPONSE_SIZE;
        String observationName = environment.getProperty(
            "management.observations.http.client.requests.name", "http.client.requests");
        WebClient webClient = webClientBuilder.getIfAvailable(WebClient::builder)
            .observationConvention(new TokenMaskingObservationConvention(observationName))
            .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(Math.toIntExact(maxResponseSize.toBytes())))
            .build();
        return new WebClientTelegramSession(webClient, WebClientTelegramSession.defaultObjectMapper(),
            api != null ? api.baseUrl() : null,
            api != null ? api.requestTimeout() : WebClientTelegramSession.DEFAULT_REQUEST_TIMEOUT);
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

    /**
     * The registry is a BeanPostProcessor, so it is created before ordinary beans. Hence the
     * static method (no early instance of this configuration class), the lazily resolved
     * dispatcher and the setting read straight from the environment: anything injected eagerly
     * here would be created too early to be processed by the other post-processors.
     */
    @Bean
    @ConditionalOnMissingBean
    public static HandlerRegistry handlerRegistry(ObjectProvider<Dispatcher> dispatcher, Environment environment) {
        boolean virtualThreads = Binder.get(environment)
            .bind("telegram.handlers.virtual-threads", Boolean.class)
            .orElse(true);
        return virtualThreads
            ? HandlerRegistry.withVirtualThreads(dispatcher::getObject)
            : new HandlerRegistry(dispatcher::getObject);
    }
}
