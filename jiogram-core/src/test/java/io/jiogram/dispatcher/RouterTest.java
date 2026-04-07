package io.jiogram.dispatcher;

import io.jiogram.filter.Filter;
import io.jiogram.filter.FilterResult;
import io.jiogram.types.Chat;
import io.jiogram.types.Message;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RouterTest {

    private static final UpdateContext DUMMY_CONTEXT = new UpdateContext(null, null);

    /**
     * Creates a minimal Message for testing. All nullable fields are null.
     */
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

    @Test
    void handlerMatchesAndHandlesEvent() {
        var router = new Router("test");
        var handled = new ArrayList<String>();

        router.onMessage().handle((msg, ctx) -> {
            handled.add(msg.text());
            return Mono.empty();
        });

        var msg = testMessage("hello");

        StepVerifier.create(router.propagateEvent("message", msg, DUMMY_CONTEXT))
                .expectNext(true)
                .verifyComplete();

        assertEquals(1, handled.size());
        assertEquals("hello", handled.get(0));
    }

    @Test
    void subRouterHandlesWhenParentHasNoMatch() {
        var parent = new Router("parent");
        var child = new Router("child");
        var handled = new ArrayList<String>();

        // Parent has no message handlers
        // Child has a message handler
        child.onMessage().handle((msg, ctx) -> {
            handled.add("child:" + msg.text());
            return Mono.empty();
        });

        parent.includeRouter(child);

        var msg = testMessage("world");

        StepVerifier.create(parent.propagateEvent("message", msg, DUMMY_CONTEXT))
                .expectNext(true)
                .verifyComplete();

        assertEquals(1, handled.size());
        assertEquals("child:world", handled.get(0));
    }

    @Test
    void returnsFalseWhenNoHandlerMatches() {
        var router = new Router("test");

        var msg = testMessage("hello");

        StepVerifier.create(router.propagateEvent("message", msg, DUMMY_CONTEXT))
                .expectNext(false)
                .verifyComplete();
    }

    @Test
    void filterRejectsHandlerNotCalled() {
        var router = new Router("test");
        var handled = new ArrayList<String>();

        Filter<Message> rejectAll = (event, ctx) -> Mono.just(FilterResult.failed());

        router.onMessage()
                .filter(rejectAll)
                .handle((msg, ctx) -> {
                    handled.add(msg.text());
                    return Mono.empty();
                });

        var msg = testMessage("hello");

        StepVerifier.create(router.propagateEvent("message", msg, DUMMY_CONTEXT))
                .expectNext(false)
                .verifyComplete();

        assertTrue(handled.isEmpty());
    }

    @Test
    void filterPassesDataMergedIntoContext() {
        var context = new UpdateContext(null, null);
        var router = new Router("test");

        Filter<Message> addData = (event, ctx) ->
                Mono.just(FilterResult.passed(Map.of("text_length", event.text().length())));

        router.onMessage()
                .filter(addData)
                .handle((msg, ctx) -> {
                    assertEquals(5, ctx.get("text_length", Integer.class));
                    return Mono.empty();
                });

        var msg = testMessage("hello");

        StepVerifier.create(router.propagateEvent("message", msg, context))
                .expectNext(true)
                .verifyComplete();
    }

    @Test
    void parentHandlerTakesPriorityOverSubRouter() {
        var parent = new Router("parent");
        var child = new Router("child");
        var handled = new ArrayList<String>();

        parent.onMessage().handle((msg, ctx) -> {
            handled.add("parent");
            return Mono.empty();
        });

        child.onMessage().handle((msg, ctx) -> {
            handled.add("child");
            return Mono.empty();
        });

        parent.includeRouter(child);

        var msg = testMessage("hello");

        StepVerifier.create(parent.propagateEvent("message", msg, DUMMY_CONTEXT))
                .expectNext(true)
                .verifyComplete();

        assertEquals(1, handled.size());
        assertEquals("parent", handled.get(0));
    }

    @Test
    void multipleSubRoutersFirstMatchWins() {
        var parent = new Router("parent");
        var child1 = new Router("child1");
        var child2 = new Router("child2");
        var handled = new ArrayList<String>();

        child1.onMessage().handle((msg, ctx) -> {
            handled.add("child1");
            return Mono.empty();
        });

        child2.onMessage().handle((msg, ctx) -> {
            handled.add("child2");
            return Mono.empty();
        });

        parent.includeRouters(child1, child2);

        var msg = testMessage("hello");

        StepVerifier.create(parent.propagateEvent("message", msg, DUMMY_CONTEXT))
                .expectNext(true)
                .verifyComplete();

        assertEquals(1, handled.size());
        assertEquals("child1", handled.get(0));
    }

    @Test
    void includeRouterSetsParent() {
        var parent = new Router("parent");
        var child = new Router("child");

        parent.includeRouter(child);

        assertSame(parent, child.parent());
        assertEquals(1, parent.subRouters().size());
    }

    @Test
    void observerAccessReturnsCorrectTypes() {
        var router = new Router();

        assertNotNull(router.messageObserver());
        assertNotNull(router.callbackQueryObserver());
        assertNotNull(router.inlineQueryObserver());
        assertNotNull(router.editedMessageObserver());
        assertNotNull(router.channelPostObserver());
        assertNotNull(router.editedChannelPostObserver());
        assertNotNull(router.pollObserver());
        assertNotNull(router.pollAnswerObserver());
        assertNotNull(router.myChatMemberObserver());
        assertNotNull(router.chatMemberObserver());
        assertNotNull(router.chatJoinRequestObserver());

        assertEquals("message", router.observer("message").eventType());
        assertEquals("callback_query", router.observer("callback_query").eventType());
    }
}
