package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to add a message to the list of pinned messages in a chat. In private chats and
 * channel direct messages chats, all non-service messages can be pinned. Conversely, the bot must
 * be an administrator with the 'can_pin_messages' right or the 'can_edit_messages' right to pin
 * messages in groups and channels respectively. Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message will be pinned
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageId Identifier of a message to pin
 * @param disableNotification Pass True if it is not necessary to send a notification to all chat
 *     members about the new pinned message. Notifications are always disabled in channels and
 *     private chats.
 * @see <a href="https://core.telegram.org/bots/api#pinchatmessage">pinChatMessage in the Bot API</a>
 */
public record PinChatMessage(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "pinChatMessage";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static PinChatMessage of(ChatId chatId, long messageId) {
        return new PinChatMessage(null, chatId, messageId, null);
    }

    public PinChatMessage withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new PinChatMessage(businessConnectionId, chatId, messageId, disableNotification);
    }

    public PinChatMessage withChatId(ChatId chatId) {
        return new PinChatMessage(businessConnectionId, chatId, messageId, disableNotification);
    }

    public PinChatMessage withMessageId(long messageId) {
        return new PinChatMessage(businessConnectionId, chatId, messageId, disableNotification);
    }

    public PinChatMessage withDisableNotification(@Nullable Boolean disableNotification) {
        return new PinChatMessage(businessConnectionId, chatId, messageId, disableNotification);
    }
}
