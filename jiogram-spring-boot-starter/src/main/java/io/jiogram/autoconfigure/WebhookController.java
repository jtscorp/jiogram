package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferLimitException;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * WebFlux controller that receives Telegram webhook updates. Spring MVC applications get
 * {@link ServletWebhookController} instead.
 * <p>
 * Every request must carry the secret token in the {@code X-Telegram-Bot-Api-Secret-Token}
 * header. It is checked before the body is read, and the body is read only up to
 * {@code telegram.webhook.max-body-size}; a bigger one is rejected with 413.
 */
@RestController
public class WebhookController {

    private final WebhookUpdateHandler handler;

    public WebhookController(Bot bot, Dispatcher dispatcher, String secretToken) {
        this(bot, dispatcher, secretToken, JiogramProperties.WebhookProperties.DEFAULT_MAX_BODY_SIZE);
    }

    public WebhookController(Bot bot, Dispatcher dispatcher, String secretToken, DataSize maxBodySize) {
        this.handler = new WebhookUpdateHandler(bot, dispatcher, secretToken, maxBodySize);
    }

    @PostMapping("${telegram.webhook.path:/bot/webhook}")
    public Mono<ResponseEntity<Void>> handleUpdate(ServerHttpRequest request) {
        if (!handler.isValidSecret(request.getHeaders().getFirst(WebhookUpdateHandler.SECRET_TOKEN_HEADER))) {
            return Mono.just(handler.unauthorized());
        }
        if (request.getHeaders().getContentLength() > handler.maxBodySize()) {
            return Mono.just(handler.payloadTooLarge());
        }
        // A chunked body has no Content-Length: join() stops reading once it exceeds the limit.
        return DataBufferUtils.join(request.getBody(), handler.maxBodySize())
            .map(WebhookController::readAndRelease)
            .defaultIfEmpty(new byte[0])
            .flatMap(handler::handle)
            .onErrorResume(DataBufferLimitException.class, e -> Mono.just(handler.payloadTooLarge()));
    }

    private static byte[] readAndRelease(DataBuffer buffer) {
        try {
            byte[] bytes = new byte[buffer.readableByteCount()];
            buffer.read(bytes);
            return bytes;
        } finally {
            DataBufferUtils.release(buffer);
        }
    }
}
