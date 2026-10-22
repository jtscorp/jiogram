package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;
import java.util.Base64;

/**
 * Auto-configuration for the webhook update receiver.
 * Active only when {@code telegram.mode=webhook}.
 * <p>
 * The webhook endpoint always requires Telegram's secret token header. If
 * {@code telegram.webhook.secret-token} is not set but {@code telegram.webhook.url} is, a random
 * token is generated and registered with {@code setWebhook}. Without either, startup fails:
 * an unauthenticated endpoint would accept forged updates from anyone.
 * <p>
 * The starter brings no web server; webhook mode needs one from the application (e.g.
 * {@code spring-boot-starter-webflux} or {@code spring-boot-starter-web}). Without it startup fails.
 */
@AutoConfiguration(after = JiogramAutoConfiguration.class)
@ConditionalOnBean(Bot.class)
@ConditionalOnProperty(prefix = "telegram", name = "mode", havingValue = "webhook")
public class WebhookAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(WebhookAutoConfiguration.class);

    /**
     * The secret token shared by the {@link WebhookController} (to verify requests) and the
     * {@link WebhookRegistrar} (to register it with Telegram).
     */
    public record WebhookSecretToken(String value) {
        @Override
        public String toString() {
            return "WebhookSecretToken[****]";
        }
    }

    @Bean
    @ConditionalOnMissingBean
    public WebhookSecretToken webhookSecretToken(JiogramProperties properties) {
        JiogramProperties.WebhookProperties webhook = properties.webhook();
        if (webhook.secretToken() != null && !webhook.secretToken().isBlank()) {
            return new WebhookSecretToken(webhook.secretToken());
        }
        if (webhook.url() == null || webhook.url().isBlank()) {
            throw new IllegalStateException(
                "telegram.mode=webhook requires telegram.webhook.secret-token when telegram.webhook.url "
                    + "is not set (the webhook is registered outside this application, so a generated "
                    + "token could not be passed to setWebhook)");
        }
        log.info("telegram.webhook.secret-token is not set; generated a random one for this run");
        return new WebhookSecretToken(generateToken());
    }

    @Bean
    @ConditionalOnWebApplication
    public WebhookController webhookController(Bot bot, Dispatcher dispatcher, WebhookSecretToken secretToken) {
        return new WebhookController(bot, dispatcher, secretToken.value());
    }

    @Bean
    @ConditionalOnProperty(prefix = "telegram.webhook", name = "url")
    public WebhookRegistrar webhookRegistrar(Bot bot, JiogramProperties properties, WebhookSecretToken secretToken) {
        return new WebhookRegistrar(bot, properties, secretToken.value());
    }

    /**
     * Fails startup instead of silently receiving nothing when there is no server for the webhook.
     */
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnNotWebApplication
    static class WebServerRequired {
        WebServerRequired() {
            throw new IllegalStateException(
                "telegram.mode=webhook needs a web server to receive updates, but this is not a web "
                    + "application. Add spring-boot-starter-webflux (or spring-boot-starter-web).");
        }
    }

    /**
     * 32 random bytes as URL-safe Base64: within Telegram's allowed alphabet (A-Z, a-z, 0-9, _ and -).
     */
    private static String generateToken() {
        byte[] bytes = new byte[32];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}
