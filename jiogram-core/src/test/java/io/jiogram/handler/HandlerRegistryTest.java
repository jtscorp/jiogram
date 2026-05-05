package io.jiogram.handler;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnCallbackQuery;
import io.jiogram.annotation.OnInlineQuery;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.StateFilter;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Router;
import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.types.CallbackQuery;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatType;
import io.jiogram.types.InlineQuery;
import io.jiogram.types.Message;
import io.jiogram.types.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandlerRegistryTest {

    private Router router;
    private HandlerRegistry registry;

    @BeforeEach
    void setUp() {
        router = new Router("test");
        registry = new HandlerRegistry(router);
    }

    // -- Test controller classes --

    @TelegramController
    static class SimpleMessageController {
        final List<String> handled = new ArrayList<>();

        @OnMessage
        public Mono<Void> onAnyMessage(Message message, UpdateContext ctx) {
            handled.add(message.text());
            return Mono.empty();
        }
    }

    @TelegramController
    static class CommandController {
        final List<String> handled = new ArrayList<>();

        @OnMessage
        @Command({"start", "help"})
        public Mono<Void> onStartOrHelp(Message message, UpdateContext ctx) {
            handled.add(message.text());
            return Mono.empty();
        }
    }

    @TelegramController
    static class CallbackController {
        final List<String> handled = new ArrayList<>();

        @OnCallbackQuery(data = "confirm")
        public Mono<Void> onConfirm(CallbackQuery query, UpdateContext ctx) {
            handled.add(query.data());
            return Mono.empty();
        }

        @OnCallbackQuery(prefix = "action_")
        public Mono<Void> onAction(CallbackQuery query, UpdateContext ctx) {
            handled.add(query.data());
            return Mono.empty();
        }
    }

    @TelegramController
    static class InlineController {
        final List<String> handled = new ArrayList<>();

        @OnInlineQuery
        public Mono<Void> onInline(InlineQuery query, UpdateContext ctx) {
            handled.add(query.query());
            return Mono.empty();
        }
    }

    @TelegramController
    static class StateController {
        final List<String> handled = new ArrayList<>();

        @OnMessage
        @StateFilter("waiting_for_name")
        public Mono<Void> onNameInput(Message message, UpdateContext ctx) {
            handled.add(message.text());
            return Mono.empty();
        }
    }

    @TelegramController
    static class VoidReturnController {
        final List<String> handled = new ArrayList<>();

        @OnMessage
        public void onMessage(Message message) {
            handled.add(message.text());
        }
    }

    static class NotAController {
        @OnMessage
        public Mono<Void> shouldNotBeRegistered(Message message, UpdateContext ctx) {
            return Mono.empty();
        }
    }

    // -- Helper methods --

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

    static CallbackQuery testCallback(String data) {
        var user = new User(1L, false, "Test", null, null, null, null, null, null, null, null, null, null, null, null, null);
        return new CallbackQuery("cb1", user, null, null, "instance", data, null);
    }

    static InlineQuery testInlineQuery(String query) {
        var user = new User(1L, false, "Test", null, null, null, null, null, null, null, null, null, null, null, null, null);
        return new InlineQuery("iq1", user, query, "", null, null);
    }

    // -- Tests --

    @Test
    void registersSimpleMessageHandler() {
        var controller = new SimpleMessageController();
        registry.postProcessAfterInitialization(controller, "simpleMessageController");

        assertTrue(router.messageObserver().hasHandlers());

        var ctx = new UpdateContext(null, null);
        StepVerifier.create(router.propagateEvent("message", testMessage("hello"), ctx))
                .expectNext(true)
                .verifyComplete();

        assertEquals(List.of("hello"), controller.handled);
    }

    @Test
    void registersCommandHandler() {
        var controller = new CommandController();
        registry.postProcessAfterInitialization(controller, "commandController");

        assertTrue(router.messageObserver().hasHandlers());

        // /start should match
        var ctx1 = new UpdateContext(null, null);
        StepVerifier.create(router.propagateEvent("message", testMessage("/start"), ctx1))
                .expectNext(true)
                .verifyComplete();

        assertEquals(1, controller.handled.size());

        // /help should match
        var ctx2 = new UpdateContext(null, null);
        StepVerifier.create(router.propagateEvent("message", testMessage("/help"), ctx2))
                .expectNext(true)
                .verifyComplete();

        assertEquals(2, controller.handled.size());

        // /other should NOT match
        var ctx3 = new UpdateContext(null, null);
        StepVerifier.create(router.propagateEvent("message", testMessage("/other"), ctx3))
                .expectNext(false)
                .verifyComplete();

        assertEquals(2, controller.handled.size());
    }

    @Test
    void registersCallbackQueryHandlers() {
        var controller = new CallbackController();
        registry.postProcessAfterInitialization(controller, "callbackController");

        assertTrue(router.callbackQueryObserver().hasHandlers());

        // Exact "confirm" should match
        var ctx1 = new UpdateContext(null, null);
        StepVerifier.create(router.propagateEvent("callback_query", testCallback("confirm"), ctx1))
                .expectNext(true)
                .verifyComplete();

        assertEquals(1, controller.handled.size());
        assertEquals("confirm", controller.handled.get(0));
    }

    @Test
    void registersCallbackQueryPrefixHandler() {
        var controller = new CallbackController();
        registry.postProcessAfterInitialization(controller, "callbackController");

        // "action_delete" should match the prefix handler
        var ctx = new UpdateContext(null, null);
        StepVerifier.create(router.propagateEvent("callback_query", testCallback("action_delete"), ctx))
                .expectNext(true)
                .verifyComplete();

        // It may have matched "confirm" first (which would fail) then "action_" prefix
        assertTrue(controller.handled.contains("action_delete"));
    }

    @Test
    void registersInlineQueryHandler() {
        var controller = new InlineController();
        registry.postProcessAfterInitialization(controller, "inlineController");

        assertTrue(router.inlineQueryObserver().hasHandlers());

        var ctx = new UpdateContext(null, null);
        StepVerifier.create(router.propagateEvent("inline_query", testInlineQuery("search term"), ctx))
                .expectNext(true)
                .verifyComplete();

        assertEquals(List.of("search term"), controller.handled);
    }

    @Test
    void stateFilterRestrictsHandler() {
        var controller = new StateController();
        registry.postProcessAfterInitialization(controller, "stateController");

        // Without state set, should not match
        var ctx1 = new UpdateContext(null, null);
        StepVerifier.create(router.propagateEvent("message", testMessage("John"), ctx1))
                .expectNext(false)
                .verifyComplete();

        assertTrue(controller.handled.isEmpty());

        // With correct state, should match
        var ctx2 = new UpdateContext(null, null);
        ctx2.put("raw_state", "waiting_for_name");
        StepVerifier.create(router.propagateEvent("message", testMessage("John"), ctx2))
                .expectNext(true)
                .verifyComplete();

        assertEquals(List.of("John"), controller.handled);
    }

    @Test
    void voidReturnTypeHandlerWorks() {
        var controller = new VoidReturnController();
        registry.postProcessAfterInitialization(controller, "voidReturnController");

        var ctx = new UpdateContext(null, null);
        StepVerifier.create(router.propagateEvent("message", testMessage("test"), ctx))
                .expectNext(true)
                .verifyComplete();

        assertEquals(List.of("test"), controller.handled);
    }

    @Test
    void nonControllerBeanIsIgnored() {
        var notController = new NotAController();
        registry.postProcessAfterInitialization(notController, "notAController");

        assertFalse(router.messageObserver().hasHandlers());
    }

    @Test
    void returnsBeanUnchanged() {
        var controller = new SimpleMessageController();
        Object result = registry.postProcessAfterInitialization(controller, "test");
        assertSame(controller, result);
    }
}
