package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to remove a message from the list of pinned messages in a chat. In private chats
 * and channel direct messages chats, all messages can be unpinned. Conversely, the bot must be an
 * administrator with the 'can_pin_messages' right or the 'can_edit_messages' right to unpin
 * messages in groups and channels respectively. Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message will be unpinned
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageId Identifier of the message to unpin. Required if business_connection_id is
 *     specified. If not specified, the most recent pinned message (by sending date) will be
 *     unpinned.
 * @see <a href="https://core.telegram.org/bots/api#unpinchatmessage">unpinChatMessage in the Bot API</a>
 */
public record UnpinChatMessage(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_id") @Nullable Long messageId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "unpinChatMessage";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static UnpinChatMessage of(ChatId chatId) {
        return new UnpinChatMessage(null, chatId, null);
    }
}
