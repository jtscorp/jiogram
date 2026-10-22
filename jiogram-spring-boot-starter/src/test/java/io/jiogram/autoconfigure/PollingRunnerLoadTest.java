package io.jiogram.autoconfigure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.session.WebClientTelegramSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

/**
 * Polls a local stand-in for the Bot API over real HTTP: 1000 updates spread over 50 chats,
 * served in batches of up to 100, with handlers of random duration.
 */
class PollingRunnerLoadTest {

    private static final ObjectMapper MAPPER = WebClientTelegramSession.defaultObjectMapper();
    private static final int UPDATES = 1000;
    private static final int CHATS = 50;
    private static final int CONCURRENCY = 8;

    private final Map<Long, List<Long>> handledPerChat = new ConcurrentHashMap<>();
    private final AtomicInteger handled = new AtomicInteger();
    private final AtomicInteger running = new AtomicInteger();
    private final AtomicInteger maxRunning = new AtomicInteger();
    private final List<Long> requestedOffsets = new CopyOnWriteArrayList<>();
    private DisposableServer server;
    private PollingRunner runner;

    @AfterEach
    void tearDown() {
        if (runner != null) {
            runner.stop();
        }
        if (server != null) {
            server.disposeNow();
        }
    }

    @Test
    void thousandUpdatesOverFiftyChats_eachHandledOnceInChatOrder_withBoundedParallelism() {
        server = HttpServer.create().port(0)
            .route(routes -> routes.post("/bot{token}/getUpdates", (request, response) -> request.receive()
                .aggregate().asString(StandardCharsets.UTF_8)
                .flatMap(body -> {
                    JsonNode json = readTree(body);
                    long offset = json.path("offset").asLong(1);
                    int limit = json.path("limit").asInt(100);
                    requestedOffsets.add(offset);
                    String result = batch(offset, limit);
                    // Nothing left: behave like a long poll that times out empty.
                    Mono<String> reply = Mono.just("{\"ok\":true,\"result\":" + result + "}");
                    if (result.equals("[]")) {
                        reply = reply.delayElement(Duration.ofMillis(200));
                    }
                    return response.header("Content-Type", "application/json").sendString(reply).then();
                })))
            .bindNow();

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.onMessage().handle((message, context) -> Mono.defer(() -> {
                maxRunning.accumulateAndGet(running.incrementAndGet(), Math::max);
                return Mono.delay(Duration.ofMillis(ThreadLocalRandom.current().nextInt(1, 6)));
            })
            .doOnNext(ignored -> {
                handledPerChat.computeIfAbsent(message.chat().id(), chat -> new CopyOnWriteArrayList<>())
                    .add(message.messageId());
                handled.incrementAndGet();
            })
            // Before the completion travels downstream (doFinally would run after the next chat's
            // handler may already have started, overstating the parallelism).
            .doOnTerminate(running::decrementAndGet)
            .then());

        Bot bot = new Bot("123:abc",
            new WebClientTelegramSession(WebClient.create(), "http://localhost:" + server.port()));
        JiogramProperties properties = new JiogramProperties("123:abc", JiogramProperties.Mode.POLLING,
            new JiogramProperties.PollingProperties(1, 10, 100, null, CONCURRENCY, Duration.ofSeconds(10)),
            null, null, null, null, null);
        runner = new PollingRunner(bot, dispatcher, properties);
        runner.start();

        await().atMost(Duration.ofSeconds(30)).until(() -> handled.get() >= UPDATES);
        // The next poll confirms the last batch.
        await().atMost(Duration.ofSeconds(5)).until(() -> requestedOffsets.contains((long) UPDATES + 1));

        assertThat(handled.get()).isEqualTo(UPDATES);
        assertThat(handledPerChat).hasSize(CHATS);
        handledPerChat.forEach((chat, messageIds) -> {
            List<Long> expected = new ArrayList<>();
            for (long id = chat; id <= UPDATES; id += CHATS) {
                expected.add(id);
            }
            assertThat(messageIds).as("chat %d", chat).containsExactlyElementsOf(expected);
        });
        assertThat(maxRunning.get()).isGreaterThan(1).isLessThanOrEqualTo(CONCURRENCY);
        // Offsets only move forward, batch by batch.
        assertThat(requestedOffsets).isSortedAccordingTo(Long::compare);
    }

    /** Updates {@code offset..offset+limit-1}; update n is message n in chat {@code (n-1) % 50 + 1}. */
    private String batch(long offset, int limit) {
        List<String> updates = new ArrayList<>();
        for (long id = Math.max(offset, 1); id <= UPDATES && updates.size() < limit; id++) {
            long chat = (id - 1) % CHATS + 1;
            updates.add("""
                {"update_id":%d,"message":{"message_id":%d,"date":1775538971,"chat":{"id":%d,"type":"private"},"text":"m%d"}}"""
                .formatted(id, id, chat, id));
        }
        return "[" + String.join(",", updates) + "]";
    }

    private static JsonNode readTree(String body) {
        try {
            return MAPPER.readTree(body.isEmpty() ? "{}" : body);
        } catch (Exception e) {
            throw new IllegalArgumentException(body, e);
        }
    }
}
