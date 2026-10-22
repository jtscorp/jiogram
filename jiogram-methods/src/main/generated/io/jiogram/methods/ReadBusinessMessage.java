package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Marks incoming message as read on behalf of a business account. Requires the can_read_messages
 * business bot right. Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which to
 *     read the message
 * @param chatId Unique identifier of the chat in which the message was received. The chat must have
 *     been active in the last 24 hours.
 * @param messageId Unique identifier of the message to mark as read
 * @see <a href="https://core.telegram.org/bots/api#readbusinessmessage">readBusinessMessage in the Bot API</a>
 */
public record ReadBusinessMessage(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("message_id") long messageId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "readBusinessMessage";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public ReadBusinessMessage withBusinessConnectionId(String businessConnectionId) {
        return new ReadBusinessMessage(businessConnectionId, chatId, messageId);
    }

    public ReadBusinessMessage withChatId(long chatId) {
        return new ReadBusinessMessage(businessConnectionId, chatId, messageId);
    }

    public ReadBusinessMessage withMessageId(long messageId) {
        return new ReadBusinessMessage(businessConnectionId, chatId, messageId);
    }
}
