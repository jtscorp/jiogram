package io.jiogram.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.session.WebClientTelegramSession;
import io.jiogram.types.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.unit.DataSize;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * What the WebFlux and the Spring MVC webhook endpoints share: the secret token check, the body
 * size limit, and parsing and dispatching the update. The endpoints only read the body, after
 * the secret token has been checked and no further than the limit.
 * <p>
 * The body is parsed with the session's Jackson 2 mapper rather than Spring's codecs, which on
 * Spring Boot 4 use Jackson 3 and ignore the databind annotations on the generated types (e.g.
 * the MaybeInaccessibleMessage resolver).
 */
final class WebhookUpdateHandler {

    static final String SECRET_TOKEN_HEADER = "X-Telegram-Bot-Api-Secret-Token";

    private static final Logger log = LoggerFactory.getLogger(WebhookUpdateHandler.class);

    private final Bot bot;
    private final Dispatcher dispatcher;
    private final byte[] secretToken;
    private final int maxBodySize;
    private final ObjectMapper objectMapper = WebClientTelegramSession.defaultObjectMapper();

    WebhookUpdateHandler(Bot bot, Dispatcher dispatcher, String secretToken, DataSize maxBodySize) {
        this.bot = bot;
        this.dispatcher = dispatcher;
        if (secretToken == null || secretToken.isBlank()) {
            throw new IllegalArgumentException("Webhook secret token must not be blank");
        }
        this.secretToken = secretToken.getBytes(StandardCharsets.UTF_8);
        long bytes = maxBodySize.toBytes();
        // One byte more than the limit is read to tell a body of exactly the limit from a bigger one.
        if (bytes <= 0 || bytes >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Webhook max body size must be between 1 byte and 2 GB, got "
                + maxBodySize);
        }
        this.maxBodySize = (int) bytes;
    }

    /** The largest body in bytes that is read. */
    int maxBodySize() {
        return maxBodySize;
    }

    boolean isValidSecret(String headerToken) {
        // Constant-time comparison so the token cannot be guessed byte by byte from timing.
        boolean valid = headerToken != null
            && MessageDigest.isEqual(secretToken, headerToken.getBytes(StandardCharsets.UTF_8));
        if (!valid) {
            log.warn("Rejected webhook request: missing or invalid secret token");
        }
        return valid;
    }

    ResponseEntity<Void> unauthorized() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    ResponseEntity<Void> payloadTooLarge() {
        log.warn("Rejected webhook request: body larger than {} bytes", maxBodySize);
        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).build();
    }

    /** Parses and dispatches an update whose request passed the secret token check. */
    Mono<ResponseEntity<Void>> handle(byte[] body) {
        Update update;
        try {
            update = objectMapper.readValue(body, Update.class);
        } catch (IOException e) {
            // Acknowledge anyway: Telegram would otherwise redeliver the same payload forever.
            log.error("Dropping unparseable webhook update: {}", e.getMessage(), e);
            return Mono.just(ResponseEntity.ok().build());
        }

        return dispatcher.feedUpdate(bot, update)
            .then(Mono.just(ResponseEntity.ok().<Void>build()))
            .onErrorResume(e -> {
                log.error("Error processing webhook update {}: {}",
                    update.updateId(), e.getMessage(), e);
                return Mono.just(ResponseEntity.ok().build());
            });
    }
}
