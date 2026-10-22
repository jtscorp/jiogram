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
        String json =
                "{\n"
                + "  \"update_id\": 10,\n"
                + "  \"message\": {\n"
                + "    \"message_id\": 5,\n"
                + "    \"from\": {\"id\": 7000000000, \"is_bot\": false, \"first_name\": \"Alice\"},\n"
                + "    \"chat\": {\"id\": 7000000000, \"type\": \"private\", \"first_name\": \"Alice\"},\n"
                + "    \"date\": 1775538971,\n"
                + "    \"text\": \"/start hello\",\n"
                + "    \"entities\": [\n"
                + "      {\"type\": \"bot_command\", \"offset\": 0, \"length\": 6},\n"
                + "      {\"type\": \"brand_new_entity\", \"offset\": 7, \"length\": 5}\n"
                + "    ]\n"
                + "  }\n"
                + "}\n";

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
        String json =
                "{\n"
                + "  \"update_id\": 11,\n"
                + "  \"callback_query\": {\n"
                + "    \"id\": \"4382bfdwdsb323b2d9\",\n"
                + "    \"from\": {\"id\": 100, \"is_bot\": false, \"first_name\": \"Alice\"},\n"
                + "    \"message\": {\n"
                + "      \"message_id\": 6,\n"
                + "      \"chat\": {\"id\": -1001234567890, \"type\": \"supergroup\", \"title\": \"Group\"},\n"
                + "      \"date\": 1775538971,\n"
                + "      \"text\": \"Pick one\"\n"
                + "    },\n"
                + "    \"chat_instance\": \"-123456789\",\n"
                + "    \"data\": \"option_1\"\n"
                + "  }\n"
                + "}\n";

        Update update = mapper.readValue(json, Update.class);

        Message message = assertInstanceOf(Message.class, update.callbackQuery().message());
        assertEquals(-1001234567890L, message.chat().id());
        assertEquals("option_1", update.callbackQuery().data());
    }

    @Test
    void chatMember_knownStatusIsReadIntoRecord_unknownStatusFallsBack() throws Exception {
        String json =
                "{\n"
                + "  \"update_id\": 12,\n"
                + "  \"chat_member\": {\n"
                + "    \"chat\": {\"id\": -100555, \"type\": \"supergroup\", \"title\": \"Group\"},\n"
                + "    \"from\": {\"id\": 1, \"is_bot\": false, \"first_name\": \"Admin\"},\n"
                + "    \"date\": 1775538971,\n"
                + "    \"old_chat_member\": {\n"
                + "      \"status\": \"creator\",\n"
                + "      \"user\": {\"id\": 2, \"is_bot\": false, \"first_name\": \"Bob\"},\n"
                + "      \"is_anonymous\": false\n"
                + "    },\n"
                + "    \"new_chat_member\": {\n"
                + "      \"status\": \"super_admin\",\n"
                + "      \"user\": {\"id\": 2, \"is_bot\": false, \"first_name\": \"Bob\"},\n"
                + "      \"can_do_everything\": true\n"
                + "    }\n"
                + "  }\n"
                + "}\n";

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
        String unknownReaction = "{\"type\": \"brand_new_reaction\", \"sticker_id\": \"abc\", \"count\": 3}\n";
        String json = String.format(
                "{\n"
                + "  \"update_id\": 13,\n"
                + "  \"message_reaction\": {\n"
                + "    \"chat\": {\"id\": 300, \"type\": \"private\"},\n"
                + "    \"message_id\": 9,\n"
                + "    \"user\": {\"id\": 100, \"is_bot\": false, \"first_name\": \"Alice\"},\n"
                + "    \"date\": 1775538971,\n"
                + "    \"old_reaction\": [],\n"
                + "    \"new_reaction\": [\n"
                + "      {\"type\": \"emoji\", \"emoji\": \"👍\"},\n"
                + "      %s\n"
                + "    ]\n"
                + "  }\n"
                + "}\n", unknownReaction);

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
    void cachedInlineResult_usesTelegramsTypeValue() throws Exception {
        InlineQueryResult cached = new InlineQueryResultCachedPhoto(
                null, "r1", "AgADfileid", null, null, null, null, null, null, null, null);

        JsonNode written = mapper.readTree(mapper.writerFor(InlineQueryResult.class).writeValueAsString(cached));

        assertEquals("photo", written.get("type").asText());
        assertEquals("AgADfileid", written.get("photo_file_id").asText());
    }

    @Test
    void getUpdatesResponse_withUnknownChatType_doesNotFailTheBatch() throws Exception {
        String json =
                "{\n"
                + "  \"ok\": true,\n"
                + "  \"result\": [\n"
                + "    {\n"
                + "      \"update_id\": 20,\n"
                + "      \"message\": {\n"
                + "        \"message_id\": 1,\n"
                + "        \"chat\": {\"id\": 400, \"type\": \"brand_new_chat_type\"},\n"
                + "        \"date\": 1775538971,\n"
                + "        \"text\": \"hi\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"update_id\": 21,\n"
                + "      \"message\": {\n"
                + "        \"message_id\": 2,\n"
                + "        \"chat\": {\"id\": 401, \"type\": \"group\", \"title\": \"G\"},\n"
                + "        \"date\": 1775538972,\n"
                + "        \"text\": \"hello\"\n"
                + "      }\n"
                + "    }\n"
                + "  ]\n"
                + "}\n";

        TelegramApiResponse<List<Update>> response = mapper.readValue(json, mapper.getTypeFactory()
                .constructParametricType(TelegramApiResponse.class,
                        mapper.getTypeFactory().constructCollectionType(List.class, Update.class)));

        assertEquals(2, response.result().size());
        assertEquals(ChatType.UNKNOWN, response.result().get(0).message().chat().type());
        assertEquals(ChatType.GROUP, response.result().get(1).message().chat().type());
    }
}
