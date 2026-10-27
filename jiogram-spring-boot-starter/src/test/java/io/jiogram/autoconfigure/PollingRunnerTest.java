package io.jiogram.autoconfigure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.methods.GetUpdates;
import io.jiogram.middleware.ErrorMiddleware;
import io.jiogram.session.TelegramSession;
import io.jiogram.session.WebClientTelegramSession;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.Update;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

class PollingRunnerTest {

    private static final ObjectMapper MAPPER = WebClientTelegramSession.defaultObjectMapper();

    private final List<GetUpdates> requests = new CopyOnWriteArrayList<>();
    private final List<String> handled = new CopyOnWriteArrayList<>();
    private PollingRunner runner;

    @AfterEach
    void stop() {
        if (runner != null) {
            runner.stop();
        }
    }

    @Test
    void chatsRunInParallel_butUpdatesOfOneChatKeepTheirOrder() {
        // Batch order: chat 1 (slow), chat 2, chat 1 again.
        List<Update> batch = List.of(message(1, 100, "A1"), message(2, 200, "B1"), message(3, 100, "A2"));
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.onMessage().handle((message, context) -> "A1".equals(message.text())
            ? Mono.delay(Duration.ofMillis(300)).then(Mono.fromRunnable(() -> handled.add("A1")))
            : Mono.fromRunnable(() -> handled.add(message.text())));

        runner = new PollingRunner(botServing(batch), dispatcher, properties(32, Duration.ofSeconds(10)));
        runner.start();

        await().atMost(Duration.ofSeconds(5)).until(() -> handled.size() == 3);
        // B1 did not wait for the slow A1; A2 still ran after A1.
        assertThat(handled).containsExactly("B1", "A1", "A2");
        // The next poll confirms the whole batch.
        await().atMost(Duration.ofSeconds(5)).until(() -> requests.size() >= 2);
        assertThat(requests.get(1).offset()).isEqualTo(4L);
    }

    @Test
    void stopWhileWaitingForTelegram_cancelsThePollAtOnce_andHasNothingToConfirm() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.onMessage().handle((message, context) -> Mono.fromRunnable(() -> handled.add(message.text())));

        runner = new PollingRunner(botServing(List.of(message(1, 100, "A1"))), dispatcher, properties(32, Duration.ofSeconds(10)));
        runner.start();
        // The second poll (offset 2) is pending, and it already confirms update 1.
        await().atMost(Duration.ofSeconds(5)).until(() -> requests.size() == 2);

        long started = System.nanoTime();
        runner.stop();

        assertThat(Duration.ofNanos(System.nanoTime() - started)).isLessThan(Duration.ofSeconds(2));
        assertThat(handled).containsExactly("A1");
        assertThat(requests).hasSize(2);
        assertThat(runner.isRunning()).isFalse();
    }

    @Test
    void stopDuringABatch_letsItFinish_thenConfirmsItWithoutWaitingForNewUpdates() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.onMessage().handle((message, context) -> Mono.delay(Duration.ofMillis(300))
            .then(Mono.fromRunnable(() -> handled.add(message.text()))));

        runner = new PollingRunner(botServing(List.of(message(1, 100, "A1"), message(2, 100, "A2"))),
            dispatcher, properties(32, Duration.ofSeconds(10)));
        runner.start();
        await().atMost(Duration.ofSeconds(5)).until(() -> requests.size() == 1);

        runner.stop();

        assertThat(handled).containsExactly("A1", "A2");
        assertThat(requests).hasSize(2);
        GetUpdates confirm = requests.get(1);
        assertThat(confirm.offset()).isEqualTo(3L);
        assertThat(confirm.limit()).isEqualTo(1L);
        assertThat(confirm.timeout()).isZero();
    }

    @Test
    void batchExceedingTheShutdownTimeout_isCancelled_andNotConfirmed() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.onMessage().handle((message, context) -> Mono.never());

        runner = new PollingRunner(botServing(List.of(message(1, 100, "A1"))), dispatcher,
            properties(32, Duration.ofMillis(200)));
        runner.start();
        await().atMost(Duration.ofSeconds(5)).until(() -> requests.size() == 1);

        long started = System.nanoTime();
        runner.stop();

        assertThat(Duration.ofNanos(System.nanoTime() - started)).isLessThan(Duration.ofSeconds(2));
        // Update 1 never finished: no confirmation, so Telegram delivers it again after a restart.
        assertThat(requests).hasSize(1);
    }

    @Test
    void sequenceKey_groupsByChatOrActingUser() {
        Update callbackInGroup = update("""
            {"update_id": 1, "callback_query": {"id": "q", "from": {"id": 7, "is_bot": false, "first_name": "U"},
             "chat_instance": "c", "message": {"message_id": 1, "chat": {"id": -100, "type": "group", "title": "G"},
             "date": 1775538971}}}""");
        Update inlineQuery = update("""
            {"update_id": 2, "inline_query": {"id": "i", "from": {"id": 7, "is_bot": false, "first_name": "U"},
             "query": "q", "offset": ""}}""");
        Update poll = update("""
            {"update_id": 3, "poll": {"id": "p", "question": "?", "options": [], "total_voter_count": 0,
             "is_closed": false, "is_anonymous": true, "type": "regular", "allows_multiple_answers": false}}""");

        Update anonymousVote = update("""
            {"update_id": 4, "poll_answer": {"poll_id": "p", "voter_chat": {"id": -200, "type": "channel"},
             "option_ids": [0]}}""");
        Update reactionCount = update("""
            {"update_id": 5, "message_reaction_count": {"chat": {"id": -300, "type": "channel"},
             "message_id": 1, "date": 1775538971, "reactions": []}}""");
        Update unknown = update("""
            {"update_id": 6, "some_future_update": {"id": 1}}""");
        Update voteWithoutVoter = update("""
            {"update_id": 7, "poll_answer": {"poll_id": "p", "option_ids": [0]}}""");

        assertThat(PollingRunner.sequenceKey(callbackInGroup)).isEqualTo(-100L);
        assertThat(PollingRunner.sequenceKey(inlineQuery)).isEqualTo(7L);
        assertThat(PollingRunner.sequenceKey(poll)).isEqualTo("update:3");
        assertThat(PollingRunner.sequenceKey(anonymousVote)).isEqualTo(-200L);
        assertThat(PollingRunner.sequenceKey(reactionCount)).isEqualTo(-300L);
        assertThat(PollingRunner.sequenceKey(unknown)).isEqualTo("update:6");
        // Neither user nor voter chat: an independent key, not a NullPointerException that would
        // fail the batch and stop polling at that offset.
        assertThat(PollingRunner.sequenceKey(voteWithoutVoter)).isEqualTo("update:7");
    }

    @Test
    void middlewareThrowingInsteadOfReturningAnError_doesNotStopPolling() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.addOuterMiddleware(new ErrorMiddleware());
        dispatcher.addOuterMiddleware((event, context, chain) -> {
            if (event instanceof Message message && "BAD".equals(message.text())) {
                throw new IllegalStateException("thrown by a middleware");
            }
            return chain.next(event, context);
        });
        dispatcher.onMessage().handle((message, context) -> Mono.fromRunnable(() -> handled.add(message.text())));

        runner = new PollingRunner(botServing(List.of(message(1, 100, "BAD"), message(2, 200, "OK"))),
            dispatcher, properties(32, Duration.ofSeconds(10)));
        runner.start();

        // The batch completes and is confirmed instead of being fetched again.
        await().atMost(Duration.ofSeconds(5)).until(() -> requests.size() >= 2);
        assertThat(requests.get(1).offset()).isEqualTo(3L);
        assertThat(handled).containsExactly("OK");
    }

    private Bot botServing(List<Update> firstBatch) {
        return botAnswering(List.of(Mono.just(firstBatch)));
    }

    /** A bot whose polls get the given answers in turn, and then no answer at all. */
    private Bot botAnswering(List<Mono<List<Update>>> answers) {
        AtomicInteger calls = new AtomicInteger();
        return new Bot("123:abc", new TelegramSession() {
            @Override
            @SuppressWarnings("unchecked")
            public <T> Mono<T> makeRequest(String token, TelegramMethod<T> method) {
                GetUpdates request = (GetUpdates) method;
                requests.add(request);
                if (Long.valueOf(0).equals(request.timeout()) && Long.valueOf(1).equals(request.limit())) {
                    return (Mono<T>) Mono.just(List.of()); // the confirming call on stop
                }
                int call = calls.getAndIncrement();
                return call < answers.size() ? (Mono<T>) answers.get(call) : Mono.never();
            }

            @Override
            public Mono<Void> close() {
                return Mono.empty();
            }
        });
    }

    private static JiogramProperties properties(int concurrency, Duration shutdownTimeout) {
        return new JiogramProperties("123:abc", JiogramProperties.Mode.POLLING,
            new JiogramProperties.PollingProperties(30, 10, 100, null, concurrency, shutdownTimeout),
            null, null, null, null, null);
    }

    private static Update message(long updateId, long chatId, String text) {
        return update("""
            {"update_id": %d, "message": {"message_id": %d, "chat": {"id": %d, "type": "private"},
             "date": 1775538971, "text": "%s"}}""".formatted(updateId, updateId, chatId, text));
    }

    private static Update update(String json) {
        try {
            return MAPPER.readValue(json, Update.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
