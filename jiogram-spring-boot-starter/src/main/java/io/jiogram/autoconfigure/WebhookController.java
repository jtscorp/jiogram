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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * REST controller that receives Telegram webhook updates.
 * <p>
 * Every request must carry the secret token in {@value #SECRET_TOKEN_HEADER}; it is checked
 * before the body is parsed. The body is read with the session's Jackson 2 mapper rather than
 * Spring's codecs, which on Spring Boot 4 use Jackson 3 and ignore the databind annotations on
 * the generated types (e.g. the MaybeInaccessibleMessage resolver).
 */
@RestController
public class WebhookController {

    static final String SECRET_TOKEN_HEADER = "X-Telegram-Bot-Api-Secret-Token";

    private static final Logger log = LoggerFactory.getLogger(WebhookController.class);

    private final Bot bot;
    private final Dispatcher dispatcher;
    private final byte[] secretToken;
    private final ObjectMapper objectMapper = WebClientTelegramSession.defaultObjectMapper();

    public WebhookController(Bot bot, Dispatcher dispatcher, String secretToken) {
        this.bot = bot;
        this.dispatcher = dispatcher;
        if (secretToken == null || secretToken.isBlank()) {
            throw new IllegalArgumentException("Webhook secret token must not be blank");
        }
        this.secretToken = secretToken.getBytes(StandardCharsets.UTF_8);
    }

    @PostMapping("${telegram.webhook.path:/bot/webhook}")
    public Mono<ResponseEntity<Void>> handleUpdate(
            @RequestBody byte[] body,
            @RequestHeader(value = SECRET_TOKEN_HEADER, required = false) String headerToken) {

        if (!isValidSecret(headerToken)) {
            log.warn("Rejected webhook request: missing or invalid secret token");
            return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
        }

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

    private boolean isValidSecret(String headerToken) {
        // Constant-time comparison so the token cannot be guessed byte by byte from timing.
        return headerToken != null
            && MessageDigest.isEqual(secretToken, headerToken.getBytes(StandardCharsets.UTF_8));
    }
}
