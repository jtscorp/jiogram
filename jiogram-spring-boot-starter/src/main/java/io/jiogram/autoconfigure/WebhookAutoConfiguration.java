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

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Objects;

/**
 * Auto-configuration for the webhook update receiver.
 * Active only when {@code telegram.mode=webhook}.
 * <p>
 * The webhook endpoint always requires Telegram's secret token header. If
 * {@code telegram.webhook.secret-token} is not set but {@code telegram.webhook.url} is, a token is
 * derived from the bot token and registered with {@code setWebhook}. Without either, startup fails:
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

    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final String SECRET_LABEL = "jiogram-webhook";

    /**
     * The secret token shared by the {@link WebhookController} (to verify requests) and the
     * {@link WebhookRegistrar} (to register it with Telegram).
     */
    public static final class WebhookSecretToken {

        private final String value;

        /**
         * Wraps the secret token.
         *
         * @param value the secret token
         */
        public WebhookSecretToken(String value) {
            this.value = value;
        }

        /** @return the secret token */
        public String value() {
            return value;
        }

        @Override
        public boolean equals(Object other) {
            return other instanceof WebhookSecretToken && Objects.equals(value, ((WebhookSecretToken) other).value);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }

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
        log.info("telegram.webhook.secret-token is not set; using one derived from the bot token, "
            + "the same on every instance of this bot");
        return new WebhookSecretToken(deriveToken(properties.token()));
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
     * HMAC-SHA256 of a fixed label keyed with the bot token, as URL-safe Base64 (within Telegram's
     * alphabet: A-Z, a-z, 0-9, _ and -). Every instance of the bot derives the same token, so all
     * of them accept the requests whichever instance called {@code setWebhook} last; a random
     * token per instance made the others reject them with 401. It cannot be computed without the
     * bot token.
     */
    static String deriveToken(String botToken) {
        try {
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            mac.init(new SecretKeySpec(botToken.getBytes(StandardCharsets.UTF_8), HMAC_ALGORITHM));
            byte[] digest = mac.doFinal(SECRET_LABEL.getBytes(StandardCharsets.UTF_8));
            return Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(HMAC_ALGORITHM + " is not available", e);
        }
    }
}
