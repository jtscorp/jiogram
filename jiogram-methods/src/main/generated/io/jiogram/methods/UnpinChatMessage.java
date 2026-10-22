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
 * Use this method to remove a message from the list of pinned messages in a chat. In private chats
 * and channel direct messages chats, all messages can be unpinned. Conversely, the bot must be an
 * administrator with the 'can_pin_messages' right or the 'can_edit_messages' right to unpin
 * messages in groups and channels respectively. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#unpinchatmessage">unpinChatMessage in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UnpinChatMessage implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_id")
    private final @Nullable Long messageId;

    /**
     * Creates a new {@code UnpinChatMessage} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be unpinned
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageId Identifier of the message to unpin. Required if business_connection_id is
     *     specified. If not specified, the most recent pinned message (by sending date) will be
     *     unpinned.
     */
    @JsonCreator
    public UnpinChatMessage(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_id") @Nullable Long messageId) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
    }

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

    /**
     * Unique identifier of the business connection on behalf of which the message will be unpinned
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
     * Identifier of the message to unpin. Required if business_connection_id is specified. If not
     * specified, the most recent pinned message (by sending date) will be unpinned.
     */
    public @Nullable Long messageId() {
        return messageId;
    }

    public UnpinChatMessage withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new UnpinChatMessage(businessConnectionId, chatId, messageId);
    }

    public UnpinChatMessage withChatId(ChatId chatId) {
        return new UnpinChatMessage(businessConnectionId, chatId, messageId);
    }

    public UnpinChatMessage withMessageId(@Nullable Long messageId) {
        return new UnpinChatMessage(businessConnectionId, chatId, messageId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UnpinChatMessage)) {
            return false;
        }
        UnpinChatMessage that = (UnpinChatMessage) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageId, that.messageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageId);
    }

    @Override
    public String toString() {
        return "UnpinChatMessage[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + "]";
    }
}
