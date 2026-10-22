package io.jiogram.dispatcher;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.bot.Bot;
import io.jiogram.middleware.Middleware;
import io.jiogram.session.TelegramSession;
import io.jiogram.types.CallbackQuery;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatType;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.Update;
import io.jiogram.types.UpdateType;
import io.jiogram.types.User;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.lang.reflect.Constructor;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
        var chat = new Chat(1L, ChatType.PRIVATE, null, null, null, null, null, null);
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
    void everyEventFieldOfUpdate_hasAnEventTypeThatReadsExactlyThatField() throws Exception {
        RecordComponent[] components = Update.class.getRecordComponents();
        Set<String> covered = new HashSet<>();
        for (int i = 0; i < components.length; i++) {
            String field = components[i].getAccessor().getAnnotation(JsonProperty.class).value();
            if (field.equals("update_id")) {
                continue;
            }
            Object event = blankInstance(components[i].getType());
            Object[] args = new Object[components.length];
            args[0] = 1L;
            args[i] = event;
            Update update = canonicalConstructor(Update.class).newInstance(args);

            EventType type = EventType.of(update);

            assertNotNull(type, "no EventType for Update." + field);
            assertEquals(field, type.apiName());
            assertSame(event, type.extract(update));
            assertTrue(type.eventClass().isInstance(event), field);
            covered.add(field);
        }
        assertEquals(EventType.values().length, covered.size(), "EventType constants without an Update field");
    }

    @Test
    void everyAllowedUpdateValue_hasAnEventType_andEveryEventTypeAnObserver() {
        Set<UpdateType> mapped = Arrays.stream(EventType.values()).map(EventType::updateType).collect(Collectors.toSet());
        Router router = new Router();

        for (UpdateType updateType : UpdateType.values()) {
            assertEquals(updateType != UpdateType.UNKNOWN, mapped.contains(updateType), updateType.name());
        }
        for (EventType type : EventType.values()) {
            assertEquals(type.apiName(), router.observer(type).eventType());
        }
    }

    /** A record of the given type with every component null, zero or false. */
    private static Object blankInstance(Class<?> type) throws Exception {
        Constructor<?> constructor = canonicalConstructor(type);
        Object[] args = Arrays.stream(constructor.getParameterTypes())
            .map(parameter -> parameter == boolean.class ? Boolean.FALSE
                : parameter == long.class ? (Object) 0L
                : parameter == double.class ? (Object) 0d
                : parameter.isPrimitive() ? (Object) 0
                : null)
            .toArray();
        return constructor.newInstance(args);
    }

    @SuppressWarnings("unchecked")
    private static <T> Constructor<T> canonicalConstructor(Class<T> type) throws NoSuchMethodException {
        Class<?>[] parameterTypes = Arrays.stream(type.getRecordComponents())
            .map(RecordComponent::getType)
            .toArray(Class<?>[]::new);
        return type.getDeclaredConstructor(parameterTypes);
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
