package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * Spring MVC controller that receives Telegram webhook updates. WebFlux applications get
 * {@link WebhookController} instead.
 * <p>
 * Every request must carry the secret token in the {@code X-Telegram-Bot-Api-Secret-Token}
 * header. It is checked before the body is read, and the body is read only up to
 * {@code telegram.webhook.max-body-size}; a bigger one is rejected with 413. (With
 * {@code @RequestBody} Spring MVC would read the whole body, of any size, before the check.)
 */
@RestController
public class ServletWebhookController {

    private final WebhookUpdateHandler handler;

    public ServletWebhookController(Bot bot, Dispatcher dispatcher, String secretToken, DataSize maxBodySize) {
        this.handler = new WebhookUpdateHandler(bot, dispatcher, secretToken, maxBodySize);
    }

    @PostMapping("${telegram.webhook.path:/bot/webhook}")
    public Mono<ResponseEntity<Void>> handleUpdate(HttpServletRequest request) throws IOException {
        if (!handler.isValidSecret(request.getHeader(WebhookUpdateHandler.SECRET_TOKEN_HEADER))) {
            return Mono.just(handler.unauthorized());
        }
        if (request.getContentLengthLong() > handler.maxBodySize()) {
            return Mono.just(handler.payloadTooLarge());
        }
        // A chunked body has no Content-Length: one byte more than the limit tells it is too big.
        byte[] body = request.getInputStream().readNBytes(handler.maxBodySize() + 1);
        if (body.length > handler.maxBodySize()) {
            return Mono.just(handler.payloadTooLarge());
        }
        return handler.handle(body);
    }
}
