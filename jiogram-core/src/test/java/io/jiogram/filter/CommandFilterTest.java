package io.jiogram.filter;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.methods.GetMe;
import io.jiogram.session.TelegramSession;
import io.jiogram.session.WebClientTelegramSession;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatType;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.User;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class CommandFilterTest {

    private final AtomicInteger getMeCalls = new AtomicInteger();
    private final CommandFilter start = new CommandFilter("start");

    @Test
    void commandAddressedToThisBot_matchesCaseInsensitively() {
        UpdateContext context = contextFor(botNamed("JiogramBot"));

        assertInstanceOf(FilterResult.Passed.class, apply("/start@jiogrambot hi", context));
    }

    @Test
    void commandAddressedToAnotherBot_doesNotMatch() {
        UpdateContext context = contextFor(botNamed("JiogramBot"));

        assertInstanceOf(FilterResult.Failed.class, apply("/start@OtherBot", context));
    }

    @Test
    void commandWithoutMention_doesNotCallGetMe() {
        UpdateContext context = contextFor(botNamed("JiogramBot"));

        assertInstanceOf(FilterResult.Passed.class, apply("/start", context));
        assertEquals(0, getMeCalls.get());
    }

    @Test
    void getMe_isFetchedOnceAndCached() {
        Bot bot = botNamed("JiogramBot");

        apply("/start@JiogramBot", contextFor(bot));
        apply("/start@JiogramBot", contextFor(bot));

        assertEquals(1, getMeCalls.get());
    }

    @Test
    void failingGetMe_acceptsTheCommandAndIsRetriedLater() {
        Bot bot = new Bot("123:abc", session(Mono.error(new IllegalStateException("network down"))));

        assertInstanceOf(FilterResult.Passed.class, apply("/start@AnyBot", contextFor(bot)));
        apply("/start@AnyBot", contextFor(bot));

        assertEquals(2, getMeCalls.get(), "errors must not be cached");
    }

    @Test
    void commandInAPhotoCaption_matches() throws Exception {
        Message photo = WebClientTelegramSession.defaultObjectMapper().readValue(
                "{\"message_id\": 1, \"date\": 1775538971, \"chat\": {\"id\": 1, \"type\": \"private\"},\n"
                + " \"photo\": [{\"file_id\": \"f\", \"file_unique_id\": \"u\", \"width\": 1, \"height\": 1}],\n"
                + " \"caption\": \"/start from a photo\"}", Message.class);

        FilterResult result = start.apply(photo, contextFor(botNamed("JiogramBot"))).block();

        assertInstanceOf(FilterResult.Passed.class, result);
        assertEquals("from a photo", ((FilterResult.Passed) result).data().get("command_args"));
    }

    private FilterResult apply(String text, UpdateContext context) {
        var chat = new Chat(1L, ChatType.GROUP, null, null, null, null, null, null);
        var message = new Message(
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
        return start.apply(message, context).block();
    }

    private Bot botNamed(String username) {
        User me = new User(123L, true, "Bot", null, username, null, null, null, null, null, null, null, null, null, null, null);
        return new Bot("123:abc", session(Mono.just(me)));
    }

    private TelegramSession session(Mono<User> getMeResult) {
        return new TelegramSession() {
            @Override
            @SuppressWarnings("unchecked")
            public <T> Mono<T> makeRequest(String token, TelegramMethod<T> method) {
                if (method instanceof GetMe) {
                    return Mono.defer(() -> {
                        getMeCalls.incrementAndGet();
                        return (Mono<T>) getMeResult;
                    });
                }
                return Mono.empty();
            }

            @Override
            public Mono<Void> close() {
                return Mono.empty();
            }
        };
    }

    private static UpdateContext contextFor(Bot bot) {
        return new UpdateContext(bot, null);
    }
}
