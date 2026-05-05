package io.jiogram.filter;

import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.types.CallbackQuery;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatType;
import io.jiogram.types.Message;
import io.jiogram.types.User;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FiltersTest {

    private static final UpdateContext DUMMY_CONTEXT = new UpdateContext(null, null);

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

    // -- CommandFilter --

    @Test
    void commandFilterMatchesSimpleCommand() {
        var filter = Filters.command("start");

        StepVerifier.create(filter.apply(testMessage("/start"), DUMMY_CONTEXT))
                .assertNext(result -> {
                    assertInstanceOf(FilterResult.Passed.class, result);
                    var passed = (FilterResult.Passed) result;
                    assertEquals("start", passed.data().get("command"));
                    assertEquals("", passed.data().get("command_args"));
                })
                .verifyComplete();
    }

    @Test
    void commandFilterMatchesCommandWithArgs() {
        var filter = Filters.command("start");

        StepVerifier.create(filter.apply(testMessage("/start deep_link_payload"), DUMMY_CONTEXT))
                .assertNext(result -> {
                    assertInstanceOf(FilterResult.Passed.class, result);
                    var passed = (FilterResult.Passed) result;
                    assertEquals("start", passed.data().get("command"));
                    assertEquals("deep_link_payload", passed.data().get("command_args"));
                })
                .verifyComplete();
    }

    @Test
    void commandFilterMatchesCommandWithBotName() {
        var filter = Filters.command("start");

        StepVerifier.create(filter.apply(testMessage("/start@mybot some args"), DUMMY_CONTEXT))
                .assertNext(result -> {
                    assertInstanceOf(FilterResult.Passed.class, result);
                    var passed = (FilterResult.Passed) result;
                    assertEquals("start", passed.data().get("command"));
                    assertEquals("some args", passed.data().get("command_args"));
                })
                .verifyComplete();
    }

    @Test
    void commandFilterRejectsNonMatchingCommand() {
        var filter = Filters.command("start");

        StepVerifier.create(filter.apply(testMessage("/help"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    @Test
    void commandFilterRejectsNonCommandMessage() {
        var filter = Filters.command("start");

        StepVerifier.create(filter.apply(testMessage("hello world"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    @Test
    void commandFilterRejectsNullText() {
        var filter = Filters.command("start");

        StepVerifier.create(filter.apply(testMessage(null), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    @Test
    void commandFilterMatchesAnyCommandWhenNoneSpecified() {
        var filter = Filters.command();

        StepVerifier.create(filter.apply(testMessage("/anything"), DUMMY_CONTEXT))
                .assertNext(result -> {
                    assertInstanceOf(FilterResult.Passed.class, result);
                    var passed = (FilterResult.Passed) result;
                    assertEquals("anything", passed.data().get("command"));
                })
                .verifyComplete();
    }

    @Test
    void commandFilterMatchesMultipleCommands() {
        var filter = Filters.command("start", "help");

        StepVerifier.create(filter.apply(testMessage("/help"), DUMMY_CONTEXT))
                .assertNext(result -> {
                    assertInstanceOf(FilterResult.Passed.class, result);
                    var passed = (FilterResult.Passed) result;
                    assertEquals("help", passed.data().get("command"));
                })
                .verifyComplete();

        StepVerifier.create(filter.apply(testMessage("/start"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Passed.class, result))
                .verifyComplete();
    }

    // -- text() --

    @Test
    void textFilterMatchesExact() {
        var filter = Filters.text("hello");

        StepVerifier.create(filter.apply(testMessage("hello"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Passed.class, result))
                .verifyComplete();
    }

    @Test
    void textFilterRejectsPartialMatch() {
        var filter = Filters.text("hello");

        StepVerifier.create(filter.apply(testMessage("hello world"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    @Test
    void textFilterRejectsNullText() {
        var filter = Filters.text("hello");

        StepVerifier.create(filter.apply(testMessage(null), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    // -- textStartsWith() --

    @Test
    void textStartsWithFilterMatches() {
        var filter = Filters.textStartsWith("hello");

        StepVerifier.create(filter.apply(testMessage("hello world"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Passed.class, result))
                .verifyComplete();
    }

    @Test
    void textStartsWithFilterRejectsNonMatch() {
        var filter = Filters.textStartsWith("hello");

        StepVerifier.create(filter.apply(testMessage("world hello"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    // -- regex() --

    @Test
    void regexFilterMatches() {
        var filter = Filters.regex("\\d{3}-\\d{4}");

        StepVerifier.create(filter.apply(testMessage("Call 123-4567 now"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Passed.class, result))
                .verifyComplete();
    }

    @Test
    void regexFilterRejectsNonMatch() {
        var filter = Filters.regex("^\\d+$");

        StepVerifier.create(filter.apply(testMessage("not a number"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    // -- callbackData() --

    @Test
    void callbackDataMatchesExact() {
        var filter = Filters.callbackData("action_1");

        StepVerifier.create(filter.apply(testCallback("action_1"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Passed.class, result))
                .verifyComplete();
    }

    @Test
    void callbackDataRejectsNonMatch() {
        var filter = Filters.callbackData("action_1");

        StepVerifier.create(filter.apply(testCallback("action_2"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    @Test
    void callbackDataRejectsNull() {
        var filter = Filters.callbackData("action_1");

        StepVerifier.create(filter.apply(testCallback(null), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    // -- callbackDataPrefix() --

    @Test
    void callbackDataPrefixMatches() {
        var filter = Filters.callbackDataPrefix("action_");

        StepVerifier.create(filter.apply(testCallback("action_delete_5"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Passed.class, result))
                .verifyComplete();
    }

    @Test
    void callbackDataPrefixRejectsNonMatch() {
        var filter = Filters.callbackDataPrefix("action_");

        StepVerifier.create(filter.apply(testCallback("other_data"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    // -- state() --

    @Test
    void stateFilterMatchesCurrentState() {
        var context = new UpdateContext(null, null);
        context.put("raw_state", "waiting_for_name");

        var filter = Filters.<Message>state("waiting_for_name");

        StepVerifier.create(filter.apply(testMessage("John"), context))
                .assertNext(result -> {
                    assertInstanceOf(FilterResult.Passed.class, result);
                    var passed = (FilterResult.Passed) result;
                    assertTrue(passed.data().isEmpty());
                })
                .verifyComplete();
    }

    @Test
    void stateFilterRejectsNonMatchingState() {
        var context = new UpdateContext(null, null);
        context.put("raw_state", "waiting_for_name");

        var filter = Filters.<Message>state("waiting_for_email");

        StepVerifier.create(filter.apply(testMessage("test"), context))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    @Test
    void stateFilterRejectsWhenNoState() {
        var filter = Filters.<Message>state("waiting_for_name");

        StepVerifier.create(filter.apply(testMessage("test"), DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }
}
