package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to delete a message, including service messages, with the following limitations:
 * <br>- A message can only be deleted if it was sent less than 48 hours ago.
 * <br>- Service messages about a supergroup, channel, or forum topic creation can't be deleted.
 * <br>- A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.
 * <br>- Bots can delete outgoing messages in private chats, groups, and supergroups.
 * <br>- Bots can delete incoming messages in private chats.
 * <br>- Bots granted can_post_messages permissions can delete outgoing messages in channels.
 * <br>- If the bot is an administrator of a group, it can delete any message there.
 * <br>- If the bot has can_delete_messages administrator right in a supergroup or a channel, it can
 * delete any message there.
 * <br>- If the bot has can_manage_direct_messages administrator right in a channel, it can delete
 * any message in the corresponding direct messages chat.
 * <br>Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletemessage">deleteMessage in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DeleteMessage implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_id")
    private final long messageId;

    /**
     * Creates a new {@code DeleteMessage} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageId Identifier of the message to delete
     */
    @JsonCreator
    public DeleteMessage(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_id") long messageId) {
        this.chatId = chatId;
        this.messageId = messageId;
    }

    @Override
    public String apiMethod() {
        return "deleteMessage";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Identifier of the message to delete
     */
    public long messageId() {
        return messageId;
    }

    public DeleteMessage withChatId(ChatId chatId) {
        return new DeleteMessage(chatId, messageId);
    }

    public DeleteMessage withMessageId(long messageId) {
        return new DeleteMessage(chatId, messageId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeleteMessage)) {
            return false;
        }
        DeleteMessage that = (DeleteMessage) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.messageId == that.messageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.messageId);
    }

    @Override
    public String toString() {
        return "DeleteMessage[chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + "]";
    }
}
