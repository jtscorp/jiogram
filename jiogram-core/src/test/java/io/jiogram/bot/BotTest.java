package io.jiogram.bot;

import io.jiogram.session.TelegramSession;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatId;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class BotTest {

    /**
     * A stub TelegramSession that captures the token and method passed to makeRequest,
     * and returns a predetermined result.
     */
    static class StubTelegramSession implements TelegramSession {
        String lastToken;
        TelegramMethod<?> lastMethod;
        Object resultToReturn;

        StubTelegramSession() {
            this(null);
        }

        StubTelegramSession(Object resultToReturn) {
            this.resultToReturn = resultToReturn;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T> Mono<T> makeRequest(String token, TelegramMethod<T> method) {
            this.lastToken = token;
            this.lastMethod = method;
            return resultToReturn != null ? Mono.just((T) resultToReturn) : Mono.empty();
        }

        @Override
        public Mono<Void> close() {
            return Mono.empty();
        }
    }

    /**
     * A simple test TelegramMethod implementation.
     */
    record TestMethod(String value) implements TelegramMethod<String> {
        @Override
        public String apiMethod() {
            return "testMethod";
        }

        @Override
        public String apiReturnType() {
            return "String";
        }
    }

    @Test
    void extractsBotIdFromValidToken() {
        var session = new StubTelegramSession();
        var bot = new Bot("123456789:ABCDEFghijklmnop", session);
        assertEquals(123456789L, bot.id());
    }

    @Test
    void extractsBotIdFromTokenWithLargeId() {
        var session = new StubTelegramSession();
        var bot = new Bot("9876543210:XYZabc123", session);
        assertEquals(9876543210L, bot.id());
    }

    @Test
    void rejectsTokenWithoutColon() {
        var session = new StubTelegramSession();
        assertThrows(IllegalArgumentException.class, () ->
            new Bot("invalid-token-no-colon", session)
        );
    }

    @Test
    void rejectsTokenWithColonButNonNumericPrefix() {
        var session = new StubTelegramSession();
        assertThrows(IllegalArgumentException.class, () ->
            new Bot("notanumber:ABCDEFghijklmnop", session)
        );
    }

    @Test
    void rejectsNullToken() {
        var session = new StubTelegramSession();
        assertThrows(IllegalArgumentException.class, () ->
            new Bot(null, session)
        );
    }

    @Test
    void rejectsBlankToken() {
        var session = new StubTelegramSession();
        assertThrows(IllegalArgumentException.class, () ->
            new Bot("  ", session)
        );
    }

    @Test
    void tokenAccessorReturnsProvidedToken() {
        var session = new StubTelegramSession();
        var bot = new Bot("123456789:ABCDEFghijklmnop", session);
        assertEquals("123456789:ABCDEFghijklmnop", bot.token());
    }

    @Test
    void sessionAccessorReturnsProvidedSession() {
        var session = new StubTelegramSession();
        var bot = new Bot("123456789:ABCDEFghijklmnop", session);
        assertSame(session, bot.session());
    }

    @Test
    void defaultsAreAppliedWhenNotProvided() {
        var session = new StubTelegramSession();
        var bot = new Bot("123456789:ABCDEFghijklmnop", session);
        var defaults = bot.defaults();
        assertNull(defaults.parseMode());
        assertFalse(defaults.protectContent());
        assertTrue(defaults.linkPreview());
    }

    @Test
    void customDefaultsAreUsed() {
        var session = new StubTelegramSession();
        var customDefaults = new DefaultBotProperties(ParseMode.HTML, true, false);
        var bot = new Bot("123456789:ABCDEFghijklmnop", session, customDefaults);
        assertEquals(ParseMode.HTML, bot.defaults().parseMode());
        assertTrue(bot.defaults().protectContent());
        assertFalse(bot.defaults().linkPreview());
    }

    @Test
    void executeAppliesDefaultsToSupportedNullFields() {
        var session = new StubTelegramSession();
        var defaults = new DefaultBotProperties(ParseMode.HTML, true, false);
        var bot = new Bot("123456789:ABCDEFghijklmnop", session, defaults);
        var method = SendMessage.of(ChatId.of(1L), "hello");

        StepVerifier.create(bot.execute(method))
            .verifyComplete();

        assertInstanceOf(SendMessage.class, session.lastMethod);
        var sent = (SendMessage) session.lastMethod;
        assertNotSame(method, sent);
        assertEquals(ParseMode.HTML, sent.parseMode());
        assertTrue(sent.protectContent());
        assertNotNull(sent.linkPreviewOptions());
        assertTrue(sent.linkPreviewOptions().isDisabled());
    }

    @Test
    void executeDoesNotOverrideExplicitValues() {
        var session = new StubTelegramSession();
        var defaults = new DefaultBotProperties(ParseMode.HTML, true, false);
        var bot = new Bot("123456789:ABCDEFghijklmnop", session, defaults);
        var method = new SendMessage(
            null,
            ChatId.of(1L),
            null,
            null,
            "hello",
            ParseMode.MARKDOWN_V2,
            null,
            null,
            null,
            false,
            null,
            null,
            null,
            null,
            null
        );

        StepVerifier.create(bot.execute(method))
            .verifyComplete();

        assertInstanceOf(SendMessage.class, session.lastMethod);
        var sent = (SendMessage) session.lastMethod;
        assertEquals(ParseMode.MARKDOWN_V2, sent.parseMode());
        assertFalse(sent.protectContent());
    }

    @Test
    void executeDelegatesToSessionMakeRequest() {
        var session = new StubTelegramSession("test-result");
        var bot = new Bot("123456789:ABCDEFghijklmnop", session);
        var method = new TestMethod("hello");

        StepVerifier.create(bot.execute(method))
            .expectNext("test-result")
            .verifyComplete();

        assertEquals("123456789:ABCDEFghijklmnop", session.lastToken);
        assertSame(method, session.lastMethod);
    }

    @Test
    void executeReturnsEmptyMonoWhenSessionReturnsEmpty() {
        var session = new StubTelegramSession();
        var bot = new Bot("123456789:ABCDEFghijklmnop", session);
        var method = new TestMethod("hello");

        StepVerifier.create(bot.execute(method))
            .verifyComplete();

        assertEquals("123456789:ABCDEFghijklmnop", session.lastToken);
        assertSame(method, session.lastMethod);
    }
}
