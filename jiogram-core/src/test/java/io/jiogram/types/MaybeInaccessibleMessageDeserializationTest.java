package io.jiogram.types;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Regression tests for {@link MaybeInaccessibleMessage} polymorphism. The Telegram Bot API
 * discriminates {@link Message} from {@link InaccessibleMessage} by the value of the
 * {@code date} field ({@code 0} means inaccessible, any other Unix timestamp means a regular
 * message). Jackson's standard {@code @JsonSubTypes} cannot express this and previously caused
 * runtime deserialization failures such as
 * {@code "Could not resolve type id '1775538971' as a subtype of io.jiogram.types.Message"}.
 */
class MaybeInaccessibleMessageDeserializationTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void deserializeUpdate_withRealMessage_populatesMessageField() throws Exception {
        String json =
                "{\n"
                + "  \"update_id\": 999,\n"
                + "  \"message\": {\n"
                + "    \"message_id\": 1,\n"
                + "    \"from\": {\"id\": 100, \"is_bot\": false, \"first_name\": \"Alice\"},\n"
                + "    \"chat\": {\"id\": 200, \"type\": \"private\"},\n"
                + "    \"date\": 1775538971,\n"
                + "    \"text\": \"hello\"\n"
                + "  }\n"
                + "}\n";

        Update update = mapper.readValue(json, Update.class);

        assertNotNull(update.message(), "Update.message should be populated");
        assertEquals("hello", update.message().text());
        assertEquals(1775538971L, update.message().date());
        assertEquals(200L, update.message().chat().id());
    }

    @Test
    void deserializeMaybeInaccessibleMessage_withNonZeroDate_returnsMessage() throws Exception {
        String json =
                "{\n"
                + "  \"message_id\": 1,\n"
                + "  \"from\": {\"id\": 100, \"is_bot\": false, \"first_name\": \"Alice\"},\n"
                + "  \"chat\": {\"id\": 200, \"type\": \"private\"},\n"
                + "  \"date\": 1775538971,\n"
                + "  \"text\": \"hi\"\n"
                + "}\n";

        MaybeInaccessibleMessage result = mapper.readValue(json, MaybeInaccessibleMessage.class);

        Message message = assertInstanceOf(Message.class, result);
        assertEquals("hi", message.text());
    }

    @Test
    void deserializeMaybeInaccessibleMessage_withZeroDate_returnsInaccessibleMessage() throws Exception {
        String json =
                "{\n"
                + "  \"chat\": {\"id\": 200, \"type\": \"private\"},\n"
                + "  \"message_id\": 42,\n"
                + "  \"date\": 0\n"
                + "}\n";

        MaybeInaccessibleMessage result = mapper.readValue(json, MaybeInaccessibleMessage.class);

        InaccessibleMessage inaccessible = assertInstanceOf(InaccessibleMessage.class, result);
        assertEquals(42L, inaccessible.messageId());
        assertEquals(0L, inaccessible.date());
    }
}
