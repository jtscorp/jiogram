package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.List;

/**
 * Delete messages on behalf of a business account. Requires the can_delete_sent_messages business
 * bot right to delete messages sent by the bot itself, or the can_delete_all_messages business bot
 * right to delete any message. Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which to
 *     delete the messages
 * @param messageIds A JSON-serialized list of 1-100 identifiers of messages to delete. All messages
 *     must be from the same chat. See deleteMessage for limitations on which messages can be
 *     deleted
 * @see <a href="https://core.telegram.org/bots/api#deletebusinessmessages">deleteBusinessMessages in the Bot API</a>
 */
public record DeleteBusinessMessages(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("message_ids") List<Long> messageIds
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteBusinessMessages";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public DeleteBusinessMessages withBusinessConnectionId(String businessConnectionId) {
        return new DeleteBusinessMessages(businessConnectionId, messageIds);
    }

    public DeleteBusinessMessages withMessageIds(List<Long> messageIds) {
        return new DeleteBusinessMessages(businessConnectionId, messageIds);
    }
}
