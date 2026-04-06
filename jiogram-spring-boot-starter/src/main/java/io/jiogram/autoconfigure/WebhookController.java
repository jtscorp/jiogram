package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
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

/**
 * REST controller that receives Telegram webhook updates.
 * Validates the secret token header if configured, then feeds the update to the dispatcher.
 */
@RestController
public class WebhookController {

    private static final Logger log = LoggerFactory.getLogger(WebhookController.class);
    private static final String SECRET_TOKEN_HEADER = "X-Telegram-Bot-Api-Secret-Token";

    private final Bot bot;
    private final Dispatcher dispatcher;
    private final String secretToken;

    public WebhookController(Bot bot, Dispatcher dispatcher, JiogramProperties properties) {
        this.bot = bot;
        this.dispatcher = dispatcher;
        this.secretToken = properties.webhook() != null ? properties.webhook().secretToken() : null;
    }

    @PostMapping("${telegram.webhook.path:/bot/webhook}")
    public Mono<ResponseEntity<Void>> handleUpdate(
            @RequestBody Update update,
            @RequestHeader(value = SECRET_TOKEN_HEADER, required = false) String headerToken) {

        if (secretToken != null && !secretToken.isBlank()) {
            if (!secretToken.equals(headerToken)) {
                log.warn("Rejected webhook update {}: invalid secret token", update.updateId());
                return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
            }
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
