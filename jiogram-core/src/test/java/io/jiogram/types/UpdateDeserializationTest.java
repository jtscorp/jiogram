package io.jiogram.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.session.TelegramApiResponse;
import io.jiogram.session.WebClientTelegramSession;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Deserializes real-shaped Telegram Bot API payloads with the production mapper
 * ({@link WebClientTelegramSession#defaultObjectMapper()}). Values the Bot API may add
 * in the future (new entity types, member statuses, reaction types, chat types) must
 * map to the {@code UNKNOWN} / {@code *Unknown} fallbacks instead of failing the update.
 */
class UpdateDeserializationTest {

    private final ObjectMapper mapper = WebClientTelegramSession.defaultObjectMapper();

    @Test
    void message_withUnknownEntityType_keepsKnownEntitiesAndFallsBackToUnknown() throws Exception {
        String json = """
                {
                  "update_id": 10,
                  "message": {
                    "message_id": 5,
                    "from": {"id": 7000000000, "is_bot": false, "first_name": "Alice"},
                    "chat": {"id": 7000000000, "type": "private", "first_name": "Alice"},
                    "date": 1775538971,
                    "text": "/start hello",
                    "entities": [
                      {"type": "bot_command", "offset": 0, "length": 6},
                      {"type": "brand_new_entity", "offset": 7, "length": 5}
                    ]
                  }
                }
                """;

        Update update = mapper.readValue(json, Update.class);

        Message message = update.message();
        assertNotNull(message);
        assertEquals(7000000000L, message.from().id());
        assertEquals(ChatType.PRIVATE, message.chat().type());
        assertEquals(MessageEntityType.BOT_COMMAND, message.entities().get(0).type());
        assertEquals(MessageEntityType.UNKNOWN, message.entities().get(1).type());
    }

    @Test
    void callbackQuery_withAccessibleMessage_resolvesToMessage() throws Exception {
        String json = """
                {
                  "update_id": 11,
                  "callback_query": {
                    "id": "4382bfdwdsb323b2d9",
                    "from": {"id": 100, "is_bot": false, "first_name": "Alice"},
                    "message": {
                      "message_id": 6,
                      "chat": {"id": -1001234567890, "type": "supergroup", "title": "Group"},
                      "date": 1775538971,
                      "text": "Pick one"
                    },
                    "chat_instance": "-123456789",
                    "data": "option_1"
                  }
                }
                """;

        Update update = mapper.readValue(json, Update.class);

        Message message = assertInstanceOf(Message.class, update.callbackQuery().message());
        assertEquals(-1001234567890L, message.chat().id());
        assertEquals("option_1", update.callbackQuery().data());
    }

    @Test
    void chatMember_knownStatusIsReadIntoRecord_unknownStatusFallsBack() throws Exception {
        String json = """
                {
                  "update_id": 12,
                  "chat_member": {
                    "chat": {"id": -100555, "type": "supergroup", "title": "Group"},
                    "from": {"id": 1, "is_bot": false, "first_name": "Admin"},
                    "date": 1775538971,
                    "old_chat_member": {
                      "status": "creator",
                      "user": {"id": 2, "is_bot": false, "first_name": "Bob"},
                      "is_anonymous": false
                    },
                    "new_chat_member": {
                      "status": "super_admin",
                      "user": {"id": 2, "is_bot": false, "first_name": "Bob"},
                      "can_do_everything": true
                    }
                  }
                }
                """;

        Update update = mapper.readValue(json, Update.class);

        ChatMemberOwner owner = assertInstanceOf(ChatMemberOwner.class, update.chatMember().oldChatMember());
        assertEquals(ChatMemberType.CREATOR, owner.status());
        assertEquals(2L, owner.user().id());

        ChatMemberUnknown unknown = assertInstanceOf(ChatMemberUnknown.class, update.chatMember().newChatMember());
        assertEquals("super_admin", unknown.status());
        assertEquals("status", unknown.discriminatorName());
        assertEquals(true, unknown.data().get("can_do_everything"));
        assertEquals(Map.of("id", 2, "is_bot", false, "first_name", "Bob"), unknown.data().get("user"));
    }

    @Test
    void messageReaction_unknownReactionType_fallsBackAndSerializesBackUnchanged() throws Exception {
        String unknownReaction = """
                {"type": "brand_new_reaction", "sticker_id": "abc", "count": 3}
                """;
        String json = """
                {
                  "update_id": 13,
                  "message_reaction": {
                    "chat": {"id": 300, "type": "private"},
                    "message_id": 9,
                    "user": {"id": 100, "is_bot": false, "first_name": "Alice"},
                    "date": 1775538971,
                    "old_reaction": [],
                    "new_reaction": [
                      {"type": "emoji", "emoji": "👍"},
                      %s
                    ]
                  }
                }
                """.formatted(unknownReaction);

        Update update = mapper.readValue(json, Update.class);

        List<ReactionType> reactions = update.messageReaction().newReaction();
        ReactionTypeEmoji emoji = assertInstanceOf(ReactionTypeEmoji.class, reactions.get(0));
        assertEquals(ReactionTypeType.EMOJI, emoji.type());
        ReactionTypeUnknown unknown = assertInstanceOf(ReactionTypeUnknown.class, reactions.get(1));
        assertEquals("brand_new_reaction", unknown.type());

        JsonNode written = mapper.readTree(mapper.writerFor(ReactionType.class).writeValueAsString(unknown));
        assertEquals(mapper.readTree(unknownReaction), written);
    }

    @Test
    void knownSubtype_writesDiscriminatorOnceFromItsClass() throws Exception {
        String written = mapper.writerFor(ReactionType.class)
                .writeValueAsString(new ReactionTypeEmoji(null, "🔥"));

        assertEquals("{\"type\":\"emoji\",\"emoji\":\"🔥\"}", written);
    }

    @Test
    void getUpdatesResponse_withUnknownChatType_doesNotFailTheBatch() throws Exception {
        String json = """
                {
                  "ok": true,
                  "result": [
                    {
                      "update_id": 20,
                      "message": {
                        "message_id": 1,
                        "chat": {"id": 400, "type": "brand_new_chat_type"},
                        "date": 1775538971,
                        "text": "hi"
                      }
                    },
                    {
                      "update_id": 21,
                      "message": {
                        "message_id": 2,
                        "chat": {"id": 401, "type": "group", "title": "G"},
                        "date": 1775538972,
                        "text": "hello"
                      }
                    }
                  ]
                }
                """;

        TelegramApiResponse<List<Update>> response = mapper.readValue(json, mapper.getTypeFactory()
                .constructParametricType(TelegramApiResponse.class,
                        mapper.getTypeFactory().constructCollectionType(List.class, Update.class)));

        assertEquals(2, response.result().size());
        assertEquals(ChatType.UNKNOWN, response.result().get(0).message().chat().type());
        assertEquals(ChatType.GROUP, response.result().get(1).message().chat().type());
    }
}
