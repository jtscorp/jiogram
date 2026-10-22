package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to add a message to the list of pinned messages in a chat. In private chats and
 * channel direct messages chats, all non-service messages can be pinned. Conversely, the bot must
 * be an administrator with the 'can_pin_messages' right or the 'can_edit_messages' right to pin
 * messages in groups and channels respectively. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#pinchatmessage">pinChatMessage in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PinChatMessage implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_id")
    private final long messageId;

    @JsonProperty("disable_notification")
    private final @Nullable Boolean disableNotification;

    /**
     * Creates a new {@code PinChatMessage} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be pinned
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageId Identifier of a message to pin
     * @param disableNotification Pass True if it is not necessary to send a notification to all
     *     chat members about the new pinned message. Notifications are always disabled in channels
     *     and private chats.
     */
    @JsonCreator
    public PinChatMessage(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.disableNotification = disableNotification;
    }

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

    /**
     * Unique identifier of the business connection on behalf of which the message will be pinned
     */
    public @Nullable String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Identifier of a message to pin
     */
    public long messageId() {
        return messageId;
    }

    /**
     * Pass True if it is not necessary to send a notification to all chat members about the new
     * pinned message. Notifications are always disabled in channels and private chats.
     */
    public @Nullable Boolean disableNotification() {
        return disableNotification;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PinChatMessage)) {
            return false;
        }
        PinChatMessage that = (PinChatMessage) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && this.messageId == that.messageId
                && Objects.equals(this.disableNotification, that.disableNotification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageId, this.disableNotification);
    }

    @Override
    public String toString() {
        return "PinChatMessage[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", disableNotification=" + this.disableNotification
                + "]";
    }
}
