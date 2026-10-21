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
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.core.annotation.Order;
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

    enum Form {
        WAITING_FOR_NAME
    }

    @TelegramController
    static class EnumStateController {
        final List<String> handled = new ArrayList<>();

        @OnMessage
        @StateFilter(enumClass = Form.class, value = "WAITING_FOR_NAME")
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

    /** Mirrors the container: post-process the bean, then register once singletons exist. */
    private void register(Object... controllers) {
        for (Object controller : controllers) {
            registry.postProcessAfterInitialization(controller, controller.getClass().getSimpleName());
        }
        registry.afterSingletonsInstantiated();
    }

    // -- Tests --

    @Test
    void registersSimpleMessageHandler() {
        var controller = new SimpleMessageController();
        register(controller);

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
        register(controller);

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
        register(controller);

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
        register(controller);

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
        register(controller);

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
        register(controller);

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
    void enumStateFilterRestrictsHandler() {
        var controller = new EnumStateController();
        register(controller);

        var ctx1 = new UpdateContext(null, null);
        StepVerifier.create(router.propagateEvent("message", testMessage("John"), ctx1))
                .expectNext(false)
                .verifyComplete();

        assertTrue(controller.handled.isEmpty());

        var ctx2 = new UpdateContext(null, null);
        ctx2.put("raw_state", "HandlerRegistryTest.Form.WAITING_FOR_NAME");
        StepVerifier.create(router.propagateEvent("message", testMessage("John"), ctx2))
                .expectNext(true)
                .verifyComplete();

        assertEquals(List.of("John"), controller.handled);
    }

    @Test
    void voidReturnTypeHandlerWorks() {
        var controller = new VoidReturnController();
        register(controller);

        var ctx = new UpdateContext(null, null);
        StepVerifier.create(router.propagateEvent("message", testMessage("test"), ctx))
                .expectNext(true)
                .verifyComplete();

        assertEquals(List.of("test"), controller.handled);
    }

    @Test
    void nonControllerBeanIsIgnored() {
        var notController = new NotAController();
        register(notController);

        assertFalse(router.messageObserver().hasHandlers());
    }

    @Test
    void returnsBeanUnchanged() {
        var controller = new SimpleMessageController();
        Object result = registry.postProcessAfterInitialization(controller, "test");
        assertSame(controller, result);
    }

    // -- Matching order --

    @TelegramController
    static class FormController {
        final List<String> handled = new ArrayList<>();

        // Sorts before startRegistration by name, so only the command rank keeps /register a command.
        @OnMessage
        @StateFilter("Form.NAME")
        public void processName(Message message) {
            handled.add("name:" + message.text());
        }

        @OnMessage
        @Command("register")
        public void startRegistration(Message message) {
            handled.add("register");
        }
    }

    @Test
    void commandHandler_winsOverStateHandler_whileTheStateWaitsForText() {
        var controller = new FormController();
        register(controller);

        var ctx = new UpdateContext(null, null);
        ctx.put("raw_state", "Form.NAME");
        StepVerifier.create(router.propagateEvent("message", testMessage("/register"), ctx))
                .expectNext(true)
                .verifyComplete();
        var ctx2 = new UpdateContext(null, null);
        ctx2.put("raw_state", "Form.NAME");
        StepVerifier.create(router.propagateEvent("message", testMessage("Ali"), ctx2))
                .expectNext(true)
                .verifyComplete();

        assertEquals(List.of("register", "name:Ali"), controller.handled);
    }

    @Test
    void catchAllHandlerRunsAfterFilteredHandlers_regardlessOfBeanCreationOrder() {
        var catchAll = new SimpleMessageController();
        var commands = new CommandController();
        register(catchAll, commands); // catch-all bean created first

        dispatch(testMessage("/start"));
        dispatch(testMessage("plain text"));

        assertEquals(List.of("/start"), commands.handled);
        assertEquals(List.of("plain text"), catchAll.handled);
    }

    @TelegramController
    @Order(1)
    static class HighPriorityCatchAll {
        final List<String> handled = new ArrayList<>();

        @OnMessage
        public void onMessage(Message message) {
            handled.add(message.text());
        }
    }

    @Test
    void classLevelOrder_winsOverDefaultOrder() {
        var commands = new CommandController();
        var highPriority = new HighPriorityCatchAll();
        register(commands, highPriority);

        dispatch(testMessage("/start"));

        assertEquals(List.of("/start"), highPriority.handled);
        assertTrue(commands.handled.isEmpty());
    }

    @TelegramController
    @Order(1)
    static class MethodOrderController {
        final List<String> handled = new ArrayList<>();

        @OnMessage
        @Order(0)
        public void first(Message message) {
            handled.add("first");
        }

        @OnMessage
        public void second(Message message) {
            handled.add("second");
        }
    }

    @Test
    void methodLevelOrder_overridesClassLevelOrder() {
        var controller = new MethodOrderController();
        var highPriority = new HighPriorityCatchAll();
        register(highPriority, controller);

        dispatch(testMessage("x"));

        assertEquals(List.of("first"), controller.handled);
        assertTrue(highPriority.handled.isEmpty());
    }

    // -- Proxies --

    interface Greeter {
        Mono<Void> onMessage(Message message);
    }

    @TelegramController
    static class GreeterController implements Greeter {
        final List<String> handled = new ArrayList<>();

        @Override
        @OnMessage
        public Mono<Void> onMessage(Message message) {
            handled.add(message.text());
            return Mono.empty();
        }
    }

    @Test
    void cglibProxiedController_isInvokedThroughTheProxy() {
        assertHandledThroughProxy(true);
    }

    @Test
    void jdkProxiedController_isDetectedAndInvokedThroughTheProxy() {
        assertHandledThroughProxy(false);
    }

    private void assertHandledThroughProxy(boolean proxyTargetClass) {
        var target = new GreeterController();
        var advised = new ArrayList<String>();
        var factory = new ProxyFactory(target);
        factory.setProxyTargetClass(proxyTargetClass);
        factory.addAdvice((MethodInterceptor) invocation -> {
            advised.add(invocation.getMethod().getName());
            return invocation.proceed();
        });
        Object proxy = factory.getProxy();

        register(proxy);
        dispatch(testMessage("hi"));

        assertEquals(List.of("hi"), target.handled);
        assertEquals(List.of("onMessage"), advised);
    }

    // -- Fail-fast --

    @TelegramController
    static class UnsupportedParameterController {
        @OnMessage
        public void onMessage(Message message, String unsupported) {
        }
    }

    @Test
    void unsupportedHandlerParameter_failsAtRegistration() {
        var error = assertThrows(IllegalStateException.class,
                () -> registry.postProcessAfterInitialization(new UnsupportedParameterController(), "bad"));

        assertTrue(error.getMessage().contains("UnsupportedParameterController#onMessage"), error.getMessage());
    }

    @Test
    void controllerCreatedAfterStartup_isRegisteredImmediately() {
        registry.afterSingletonsInstantiated();
        var lateController = new SimpleMessageController();

        registry.postProcessAfterInitialization(lateController, "late");
        dispatch(testMessage("late"));

        assertEquals(List.of("late"), lateController.handled);
    }

    // -- Virtual threads --

    @TelegramController
    static class BlockingController {
        final List<Boolean> ranOnVirtualThread = new ArrayList<>();

        @OnMessage
        public void onMessage(Message message) {
            // Blocking is allowed here; on a Netty event-loop thread block() would throw.
            Mono.delay(java.time.Duration.ofMillis(10)).block();
            ranOnVirtualThread.add(Thread.currentThread().isVirtual());
        }
    }

    @Test
    void withVirtualThreads_runsBlockingHandlersOnVirtualThreads() {
        var virtualRegistry = HandlerRegistry.withVirtualThreads(router);
        var controller = new BlockingController();
        try {
            virtualRegistry.postProcessAfterInitialization(controller, "blocking");
            virtualRegistry.afterSingletonsInstantiated();

            dispatch(testMessage("x"));

            assertEquals(List.of(true), controller.ranOnVirtualThread);
        } finally {
            virtualRegistry.destroy();
        }
    }

    // -- State names --

    enum CustomNamed implements io.jiogram.filter.NamedState {
        STEP;

        @Override
        public String fullName() {
            return "wizard:" + name();
        }
    }

    @TelegramController
    static class CustomStateController {
        final List<String> handled = new ArrayList<>();

        @OnMessage
        @StateFilter(enumClass = CustomNamed.class, value = "STEP")
        public void onStep(Message message) {
            handled.add(message.text());
        }
    }

    @Test
    void enumStateFilter_usesOverriddenFullName() {
        var controller = new CustomStateController();
        register(controller);

        var ctx = new UpdateContext(null, null);
        ctx.put("raw_state", "wizard:STEP");
        StepVerifier.create(router.propagateEvent("message", testMessage("go"), ctx))
                .expectNext(true)
                .verifyComplete();

        assertEquals(List.of("go"), controller.handled);
    }

    private void dispatch(Message message) {
        StepVerifier.create(router.propagateEvent("message", message, new UpdateContext(null, null)))
                .expectNextCount(1)
                .verifyComplete();
    }
}
