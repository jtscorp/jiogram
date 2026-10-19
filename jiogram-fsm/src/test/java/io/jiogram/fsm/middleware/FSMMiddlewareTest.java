package io.jiogram.fsm.middleware;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.fsm.FSMContext;
import io.jiogram.fsm.StorageKey;
import io.jiogram.fsm.storage.MemoryStateStorage;
import io.jiogram.middleware.MiddlewareChain;
import io.jiogram.session.TelegramSession;
import io.jiogram.session.WebClientTelegramSession;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.Update;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FSMMiddlewareTest {

    private final FSMMiddleware middleware = new FSMMiddleware(new MemoryStateStorage());

    @Test
    void businessMessage_keyIncludesBusinessConnection() throws Exception {
        StorageKey key = keyFor("""
            {"update_id": 1, "business_message": {"message_id": 1, "business_connection_id": "bc123",
             "from": {"id": 7, "is_bot": false, "first_name": "Customer"},
             "chat": {"id": 7, "type": "private"}, "date": 1775538971, "text": "hi"}}""");

        assertEquals("bc123", key.businessConnectionId());
        assertEquals(7L, key.chatId());
        assertEquals(7L, key.userId());
    }

    @Test
    void regularMessage_keyHasNoBusinessConnection() throws Exception {
        StorageKey key = keyFor("""
            {"update_id": 2, "message": {"message_id": 1,
             "from": {"id": 7, "is_bot": false, "first_name": "User"},
             "chat": {"id": 7, "type": "private"}, "date": 1775538971, "text": "hi"}}""");

        assertNull(key.businessConnectionId());
    }

    private StorageKey keyFor(String updateJson) throws Exception {
        Update update = WebClientTelegramSession.defaultObjectMapper().readValue(updateJson, Update.class);
        UpdateContext context = new UpdateContext(bot(), update);

        middleware.process(update, context, new MiddlewareChain(List.of(), Mono.empty())).block();

        return context.get("state", FSMContext.class).key();
    }

    private static Bot bot() {
        return new Bot("123:abc", new TelegramSession() {
            @Override
            public <T> Mono<T> makeRequest(String token, TelegramMethod<T> method) {
                return Mono.empty();
            }

            @Override
            public Mono<Void> close() {
                return Mono.empty();
            }
        });
    }
}
