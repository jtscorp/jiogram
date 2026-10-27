package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.session.TelegramSession;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.unit.DataSize;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

class WebhookControllerTest {

    private static final String SECRET = "s3cret_token-1";
    private static final String UPDATE_JSON = """
            {
              "update_id": 1,
              "message": {
                "message_id": 5,
                "from": {"id": 7000000000, "is_bot": false, "first_name": "Alice"},
                "chat": {"id": 7000000000, "type": "private"},
                "date": 1775538971,
                "text": "hello"
              }
            }
            """;

    private final AtomicReference<Message> received = new AtomicReference<>();
    private final WebTestClient client = WebTestClient
            .bindToController(new WebhookController(bot(), dispatcher(), SECRET))
            .build();

    @Test
    void validSecret_dispatchesRealTelegramUpdate() {
        post(SECRET).expectStatus().isOk();

        assertThat(received.get()).isNotNull();
        assertThat(received.get().text()).isEqualTo("hello");
        assertThat(received.get().chat().id()).isEqualTo(7000000000L);
    }

    @Test
    void wrongSecret_isRejectedWithoutDispatching() {
        post("wrong").expectStatus().isUnauthorized();

        assertThat(received.get()).isNull();
    }

    @Test
    void missingSecret_isRejectedWithoutDispatching() {
        client.post().uri("/bot/webhook")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(UPDATE_JSON)
                .exchange()
                .expectStatus().isUnauthorized();

        assertThat(received.get()).isNull();
    }

    @Test
    void unparseableBody_isAcknowledgedSoTelegramDoesNotRetryForever() {
        client.post().uri("/bot/webhook")
                .header("X-Telegram-Bot-Api-Secret-Token", SECRET)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{not json")
                .exchange()
                .expectStatus().isOk();

        assertThat(received.get()).isNull();
    }

    @Test
    void bodyLargerThanTheLimit_isRejectedWith413WithoutDispatching() {
        WebTestClient limited = WebTestClient
                .bindToController(new WebhookController(bot(), dispatcher(), SECRET, DataSize.ofBytes(100)))
                .build();

        limited.post().uri("/bot/webhook")
                .header("X-Telegram-Bot-Api-Secret-Token", SECRET)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(UPDATE_JSON)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.PAYLOAD_TOO_LARGE);

        assertThat(received.get()).isNull();
    }

    @Test
    void chunkedBodyLargerThanTheLimit_isRejectedWith413() {
        var controller = new WebhookController(bot(), dispatcher(), SECRET, DataSize.ofBytes(100));
        // No Content-Length: the limit applies while the body is read.
        var request = MockServerHttpRequest.post("/bot/webhook")
                .header("X-Telegram-Bot-Api-Secret-Token", SECRET)
                .body(Flux.just(UPDATE_JSON.substring(0, 80), UPDATE_JSON.substring(80))
                        .map(part -> DefaultDataBufferFactory.sharedInstance.wrap(part.getBytes(StandardCharsets.UTF_8))));

        ResponseEntity<Void> response = controller.handleUpdate(request).block(Duration.ofSeconds(5));

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.PAYLOAD_TOO_LARGE);
        assertThat(received.get()).isNull();
    }

    @Test
    void wrongSecret_isRejectedBeforeTheBodyIsRead() {
        var controller = new WebhookController(bot(), dispatcher(), SECRET);
        AtomicBoolean bodyRead = new AtomicBoolean();
        var request = MockServerHttpRequest.post("/bot/webhook")
                .header("X-Telegram-Bot-Api-Secret-Token", "wrong")
                .body(Flux.defer(() -> {
                    bodyRead.set(true);
                    return Flux.just(DefaultDataBufferFactory.sharedInstance.wrap(UPDATE_JSON.getBytes(StandardCharsets.UTF_8)));
                }));

        ResponseEntity<Void> response = controller.handleUpdate(request).block(Duration.ofSeconds(5));

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
        assertThat(bodyRead).isFalse();
    }

    private WebTestClient.ResponseSpec post(String secret) {
        return client.post().uri("/bot/webhook")
                .header("X-Telegram-Bot-Api-Secret-Token", secret)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(UPDATE_JSON)
                .exchange();
    }

    private Dispatcher dispatcher() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.onMessage().handle((message, context) -> Mono.fromRunnable(() -> received.set(message)));
        return dispatcher;
    }

    private static Bot bot() {
        return new Bot("123:abc", new TelegramSession() {
            @Override
            public <T> Mono<T> makeRequest(String token, TelegramMethod<T> method) {
                return Mono.empty();
            }

            @Override
            public Mono<Void> close() {
                return Mono.empty();
            }
        });
    }
}
