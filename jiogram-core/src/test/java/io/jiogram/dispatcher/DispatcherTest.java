package io.jiogram.dispatcher;

import io.jiogram.bot.Bot;
import io.jiogram.middleware.Middleware;
import io.jiogram.session.TelegramSession;
import io.jiogram.types.CallbackQuery;
import io.jiogram.types.Chat;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.Update;
import io.jiogram.types.User;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DispatcherTest {

    static class StubSession implements TelegramSession {
        @Override
        public <T> Mono<T> makeRequest(String token, TelegramMethod<T> method) {
            return Mono.empty();
        }

        @Override
        public Mono<Void> close() {
            return Mono.empty();
        }
    }

    private static final Bot TEST_BOT = new Bot("123456:ABC", new StubSession());

    static Message testMessage(String text) {
        var chat = new Chat(1L, "private", null, null, null, null, null, null);
        return new Message(
                1L, null, null, null, null, null, null, null,
                0L, null, chat, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null,
                text,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null
        );
    }

    static Update messageUpdate(Message message) {
        return new Update(1L, message,
                null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null);
    }

    static Update callbackQueryUpdate(CallbackQuery cq) {
        return new Update(2L, null,
                null, null, null, null, null, null, null, null, null,
                null, null, cq, null, null, null, null, null,
                null, null, null, null, null, null);
    }

    static Update emptyUpdate() {
        return new Update(3L, null,
                null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null);
    }

    @Test
    void feedUpdateWithMessageDispatchesToMessageHandler() {
        var dispatcher = new Dispatcher();
        var handled = new ArrayList<String>();

        dispatcher.onMessage().handle((msg, ctx) -> {
            handled.add(msg.text());
            return Mono.empty();
        });

        var msg = testMessage("hello");
        var update = messageUpdate(msg);

        StepVerifier.create(dispatcher.feedUpdate(TEST_BOT, update))
                .verifyComplete();

        assertEquals(1, handled.size());
        assertEquals("hello", handled.get(0));
    }

    @Test
    void feedUpdateWithCallbackQueryDispatchesToCallbackHandler() {
        var dispatcher = new Dispatcher();
        var handled = new ArrayList<String>();

        dispatcher.onCallbackQuery().handle((cq, ctx) -> {
            handled.add(cq.data());
            return Mono.empty();
        });

        var user = new User(1L, false, "Test", null, null, null, null, null, null, null, null, null, null, null, null, null);
        var cq = new CallbackQuery("cq1", user, null, null, "instance", "button_data", null);
        var update = callbackQueryUpdate(cq);

        StepVerifier.create(dispatcher.feedUpdate(TEST_BOT, update))
                .verifyComplete();

        assertEquals(1, handled.size());
        assertEquals("button_data", handled.get(0));
    }

    @Test
    void feedUpdateWithEmptyUpdateDoesNothing() {
        var dispatcher = new Dispatcher();
        var handled = new ArrayList<String>();

        dispatcher.onMessage().handle((msg, ctx) -> {
            handled.add("should not be called");
            return Mono.empty();
        });

        var update = emptyUpdate();

        StepVerifier.create(dispatcher.feedUpdate(TEST_BOT, update))
                .verifyComplete();

        assertTrue(handled.isEmpty());
    }

    @Test
    void feedUpdateSetsContextFields() {
        var dispatcher = new Dispatcher();

        dispatcher.onMessage().handle((msg, ctx) -> {
            assertNotNull(ctx.bot());
            assertNotNull(ctx.update());
            assertEquals("message", ctx.get("event_type"));
            assertSame(TEST_BOT, ctx.bot());
            return Mono.empty();
        });

        var msg = testMessage("test");
        var update = messageUpdate(msg);

        StepVerifier.create(dispatcher.feedUpdate(TEST_BOT, update))
                .verifyComplete();
    }

    @Test
    void outerMiddlewareExecutesAroundHandler() {
        var dispatcher = new Dispatcher();
        var order = new ArrayList<String>();

        Middleware logging = (event, ctx, chain) -> {
            order.add("middleware-before");
            return chain.next(event, ctx)
                    .doOnTerminate(() -> order.add("middleware-after"));
        };

        dispatcher.addOuterMiddleware(logging);

        dispatcher.onMessage().handle((msg, ctx) -> {
            order.add("handler");
            return Mono.empty();
        });

        var msg = testMessage("test");
        var update = messageUpdate(msg);

        StepVerifier.create(dispatcher.feedUpdate(TEST_BOT, update))
                .verifyComplete();

        assertEquals(3, order.size());
        assertEquals("middleware-before", order.get(0));
        assertEquals("handler", order.get(1));
        assertEquals("middleware-after", order.get(2));
    }

    @Test
    void multipleOuterMiddlewaresExecuteInOrder() {
        var dispatcher = new Dispatcher();
        var order = new ArrayList<String>();

        dispatcher.addOuterMiddleware((event, ctx, chain) -> {
            order.add("m1-before");
            return chain.next(event, ctx)
                    .doOnTerminate(() -> order.add("m1-after"));
        });

        dispatcher.addOuterMiddleware((event, ctx, chain) -> {
            order.add("m2-before");
            return chain.next(event, ctx)
                    .doOnTerminate(() -> order.add("m2-after"));
        });

        dispatcher.onMessage().handle((msg, ctx) -> {
            order.add("handler");
            return Mono.empty();
        });

        var msg = testMessage("test");
        var update = messageUpdate(msg);

        StepVerifier.create(dispatcher.feedUpdate(TEST_BOT, update))
                .verifyComplete();

        assertEquals(5, order.size());
        assertEquals("m1-before", order.get(0));
        assertEquals("m2-before", order.get(1));
        assertEquals("handler", order.get(2));
        assertEquals("m2-after", order.get(3));
        assertEquals("m1-after", order.get(4));
    }

    @Test
    void resolveEventTypeReturnsCorrectTypes() {
        var dispatcher = new Dispatcher();

        var msg = testMessage("test");

        assertEquals("message", dispatcher.resolveEventType(messageUpdate(msg)));
        assertNull(dispatcher.resolveEventType(emptyUpdate()));

        var user = new User(1L, false, "Test", null, null, null, null, null, null, null, null, null, null, null, null, null);
        var cq = new CallbackQuery("cq1", user, null, null, "instance", "data", null);
        assertEquals("callback_query", dispatcher.resolveEventType(callbackQueryUpdate(cq)));
    }

    @Test
    void subRouterReceivesEventsFromDispatcher() {
        var dispatcher = new Dispatcher();
        var subRouter = new Router("sub");
        var handled = new ArrayList<String>();

        subRouter.onMessage().handle((msg, ctx) -> {
            handled.add("sub:" + msg.text());
            return Mono.empty();
        });

        dispatcher.includeRouter(subRouter);

        var msg = testMessage("routed");
        var update = messageUpdate(msg);

        StepVerifier.create(dispatcher.feedUpdate(TEST_BOT, update))
                .verifyComplete();

        assertEquals(1, handled.size());
        assertEquals("sub:routed", handled.get(0));
    }
}
