package io.jiogram.fsm.middleware;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.fsm.FSMContext;
import io.jiogram.fsm.FSMStrategy;
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

    private static final String CHANNEL_POST = """
        {"update_id": 3, "channel_post": {"message_id": 1, "sender_chat": {"id": -100900, "type": "channel"},
         "chat": {"id": -100900, "type": "channel", "title": "News"}, "date": 1775538971, "text": "post"}}""";

    private static final String FORUM_TOPIC_MESSAGE = """
        {"update_id": 4, "message": {"message_id": 10, "message_thread_id": 5, "is_topic_message": true,
         "from": {"id": 7, "is_bot": false, "first_name": "User"},
         "chat": {"id": -100555, "type": "supergroup", "title": "Forum", "is_forum": true},
         "date": 1775538971, "text": "hi"}}""";

    private static final String REPLY_IN_PLAIN_GROUP = """
        {"update_id": 5, "message": {"message_id": 11, "message_thread_id": 9,
         "from": {"id": 7, "is_bot": false, "first_name": "User"},
         "chat": {"id": -100666, "type": "supergroup", "title": "Group"},
         "date": 1775538971, "text": "reply"}}""";

    @Test
    void updateWithoutUser_skipsFsmForPerUserStrategies() throws Exception {
        assertNull(keyFor(CHANNEL_POST));
        assertNull(keyFor(FSMStrategy.USER, CHANNEL_POST));
    }

    @Test
    void updateWithoutUser_isScopedToTheChatForChatStrategy() throws Exception {
        StorageKey key = keyFor(FSMStrategy.CHAT, CHANNEL_POST);

        assertEquals(-100900L, key.chatId());
        assertEquals(0L, key.userId());
    }

    @Test
    void userInTopic_isolatesEachUserPerTopic() throws Exception {
        StorageKey key = keyFor(FSMStrategy.USER_IN_TOPIC, FORUM_TOPIC_MESSAGE);

        assertEquals(new StorageKey(123L, -100555L, 7L, 5L, "default"), key);
    }

    @Test
    void chatTopic_sharesStateWithinTheTopic() throws Exception {
        StorageKey key = keyFor(FSMStrategy.CHAT_TOPIC, FORUM_TOPIC_MESSAGE);

        assertEquals(new StorageKey(123L, -100555L, 0L, 5L, "default"), key);
    }

    @Test
    void replyThreadOutsideForum_isNotTreatedAsATopic() throws Exception {
        StorageKey key = keyFor(FSMStrategy.USER_IN_TOPIC, REPLY_IN_PLAIN_GROUP);

        assertNull(key.threadId());
    }

    @Test
    void messageReaction_isScopedToChatAndUser() throws Exception {
        StorageKey key = keyFor("""
            {"update_id": 6, "message_reaction": {"chat": {"id": -100555, "type": "supergroup", "title": "G"},
             "message_id": 1, "user": {"id": 7, "is_bot": false, "first_name": "User"}, "date": 1775538971,
             "old_reaction": [], "new_reaction": [{"type": "emoji", "emoji": "\uD83D\uDC4D"}]}}""");

        assertEquals(-100555L, key.chatId());
        assertEquals(7L, key.userId());
    }

    @Test
    void inlineQuery_isScopedToTheUsersPrivateChat() throws Exception {
        StorageKey key = keyFor("""
            {"update_id": 7, "inline_query": {"id": "q", "from": {"id": 7, "is_bot": false, "first_name": "U"},
             "query": "cats", "offset": ""}}""");

        assertEquals(7L, key.chatId());
        assertEquals(7L, key.userId());
    }

    private StorageKey keyFor(String updateJson) throws Exception {
        return keyFor(FSMStrategy.USER_IN_CHAT, updateJson);
    }

    /** Runs the middleware and returns the resolved key, or null when FSM was skipped. */
    private static StorageKey keyFor(FSMStrategy strategy, String updateJson) throws Exception {
        Update update = WebClientTelegramSession.defaultObjectMapper().readValue(updateJson, Update.class);
        UpdateContext context = new UpdateContext(bot(), update);

        new FSMMiddleware(new MemoryStateStorage(), strategy)
            .process(update, context, new MiddlewareChain(List.of(), Mono.empty())).block();

        FSMContext fsm = context.get("state", FSMContext.class);
        return fsm == null ? null : fsm.key();
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
