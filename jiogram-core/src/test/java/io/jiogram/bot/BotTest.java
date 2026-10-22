package io.jiogram.bot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.methods.AnswerInlineQuery;
import io.jiogram.methods.SendMediaGroup;
import io.jiogram.methods.SendMessage;
import io.jiogram.methods.SendPoll;
import io.jiogram.session.TelegramSession;
import io.jiogram.session.WebClientTelegramSession;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.InlineQueryResultArticle;
import io.jiogram.types.InputTextMessageContent;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BotTest {

    private static final ObjectMapper MAPPER = WebClientTelegramSession.defaultObjectMapper();

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
    static final class TestMethod implements TelegramMethod<String> {

        private final String value;

        TestMethod(String value) {
            this.value = value;
        }

        String value() {
            return value;
        }

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
    void parseMode_isNotAddedWhenEntitiesAreGiven() throws Exception {
        var session = new StubTelegramSession();
        var bot = new Bot("123456789:ABCDEFghijklmnop", session, new DefaultBotProperties(ParseMode.HTML, false, true));
        var method = MAPPER.readValue("{\"chat_id\": 1, \"text\": \"hi\", \"entities\": [{\"type\": \"bold\", \"offset\": 0, \"length\": 2}]}", SendMessage.class);

        StepVerifier.create(bot.execute(method)).verifyComplete();

        // Entities replace the parse mode; adding HTML would change how the text is read.
        assertSame(method, session.lastMethod);
    }

    @Test
    void defaults_reachCaptionsOfAMediaGroup_butNotExplicitOrEntityBearingOnes() throws Exception {
        var session = new StubTelegramSession();
        var bot = new Bot("123456789:ABCDEFghijklmnop", session, new DefaultBotProperties(ParseMode.HTML, false, true));
        var method = MAPPER.readValue(
                "{\"chat_id\": 1, \"media\": [\n"
                + "  {\"type\": \"photo\", \"media\": \"file-a\", \"caption\": \"<b>a</b>\"},\n"
                + "  {\"type\": \"photo\", \"media\": \"file-b\", \"caption\": \"*b*\", \"parse_mode\": \"MarkdownV2\"},\n"
                + "  {\"type\": \"video\", \"media\": \"file-c\", \"caption\": \"c\", \"caption_entities\": [{\"type\": \"bold\", \"offset\": 0, \"length\": 1}]}\n"
                + "]}", SendMediaGroup.class);

        StepVerifier.create(bot.execute(method)).verifyComplete();

        JsonNode media = sentJson(session).get("media");
        assertEquals("HTML", media.get(0).get("parse_mode").asText());
        assertEquals("MarkdownV2", media.get(1).get("parse_mode").asText());
        assertFalse(media.get(2).has("parse_mode"));
        assertEquals("video", media.get(2).get("type").asText());
    }

    @Test
    void defaults_reachInlineResultsAndTheirMessageContent() throws Exception {
        var session = new StubTelegramSession();
        var bot = new Bot("123456789:ABCDEFghijklmnop", session, new DefaultBotProperties(ParseMode.HTML, true, false));
        // Input-only types such as InputMessageContent cannot be read from JSON, so built directly.
        var article = new InlineQueryResultArticle(null, "1", "T",
            new InputTextMessageContent("<i>x</i>", null, null, null), null, null, null, null, null, null);
        var photo = MAPPER.readValue(
                "{\"type\": \"photo\", \"id\": \"2\", \"photo_url\": \"https://example.com/a.jpg\",\n"
                + " \"thumbnail_url\": \"https://example.com/t.jpg\", \"caption\": \"<b>p</b>\"}", InlineQueryResult.class);
        var method = AnswerInlineQuery.of("q", List.of(article, photo));

        StepVerifier.create(bot.execute(method)).verifyComplete();

        JsonNode sent = sentJson(session);
        JsonNode content = sent.get("results").get(0).get("input_message_content");
        assertEquals("HTML", content.get("parse_mode").asText());
        assertTrue(content.get("link_preview_options").get("is_disabled").asBoolean());
        assertEquals("HTML", sent.get("results").get(1).get("parse_mode").asText());
        // protect_content belongs to sending methods only; answerInlineQuery has none.
        assertFalse(sent.has("protect_content"));
    }

    @Test
    void defaults_reachPollQuestionExplanationAndOptions() throws Exception {
        var session = new StubTelegramSession();
        var bot = new Bot("123456789:ABCDEFghijklmnop", session, new DefaultBotProperties(ParseMode.HTML, false, true));
        var method = MAPPER.readValue(
                "{\"chat_id\": 1, \"question\": \"<b>Q</b>\", \"explanation\": \"e\",\n"
                + " \"options\": [{\"text\": \"<i>a</i>\"}, {\"text\": \"b\", \"text_parse_mode\": \"MarkdownV2\"}]}", SendPoll.class);

        StepVerifier.create(bot.execute(method)).verifyComplete();

        JsonNode sent = sentJson(session);
        assertEquals("HTML", sent.get("question_parse_mode").asText());
        assertEquals("HTML", sent.get("explanation_parse_mode").asText());
        assertEquals("HTML", sent.get("options").get(0).get("text_parse_mode").asText());
        assertEquals("MarkdownV2", sent.get("options").get(1).get("text_parse_mode").asText());
    }

    @Test
    void requestWithNothingToFill_isSentAsIs() throws Exception {
        var session = new StubTelegramSession();
        var bot = new Bot("123456789:ABCDEFghijklmnop", session, new DefaultBotProperties(ParseMode.HTML, true, false));
        var method = MAPPER.readValue(
                "{\"chat_id\": 1, \"media\": [{\"type\": \"photo\", \"media\": \"file-a\", \"parse_mode\": \"HTML\"}],\n"
                + " \"protect_content\": false}", SendMediaGroup.class);

        StepVerifier.create(bot.execute(method)).verifyComplete();

        assertSame(method, session.lastMethod);
    }

    /**
     * An application-defined request outside io.jiogram: like a generated type, a single
     * {@code @JsonCreator} constructor plus accessors named like its parameters' fields.
     */
    static final class CustomSend implements TelegramMethod<String> {

        @JsonProperty("text")
        private final String text;

        @JsonProperty("parse_mode")
        private final ParseMode mode;

        @JsonProperty("protect_content")
        private final Boolean protectContent;

        @JsonCreator
        CustomSend(@JsonProperty("text") String text,
                   @JsonProperty("parse_mode") ParseMode mode,
                   @JsonProperty("protect_content") Boolean protectContent) {
            this.text = text;
            this.mode = mode;
            this.protectContent = protectContent;
        }

        String text() {
            return text;
        }

        ParseMode mode() {
            return mode;
        }

        Boolean protectContent() {
            return protectContent;
        }

        @Override
        public String apiMethod() {
            return "customSend";
        }

        @Override
        public String apiReturnType() {
            return "String";
        }
    }

    @Test
    void defaults_reachApplicationDefinedJsonCreatorRequests() {
        var session = new StubTelegramSession();
        var bot = new Bot("123456789:ABCDEFghijklmnop", session, new DefaultBotProperties(ParseMode.HTML, true, true));
        var method = new CustomSend("<b>x</b>", null, null);

        StepVerifier.create(bot.execute(method)).verifyComplete();

        var sent = assertInstanceOf(CustomSend.class, session.lastMethod);
        assertNotSame(method, sent);
        assertEquals("<b>x</b>", sent.text());
        assertEquals(ParseMode.HTML, sent.mode());
        assertEquals(Boolean.TRUE, sent.protectContent());
    }

    private static JsonNode sentJson(StubTelegramSession session) {
        return MAPPER.valueToTree(session.lastMethod);
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
