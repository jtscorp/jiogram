package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;

/**
 * Use this method to delete multiple messages simultaneously. If some of the specified messages
 * can't be found, they are skipped. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletemessages">deleteMessages in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DeleteMessages implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_ids")
    private final List<Long> messageIds;

    /**
     * Creates a new {@code DeleteMessages} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageIds A JSON-serialized list of 1-100 identifiers of messages to delete. See
     *     deleteMessage for limitations on which messages can be deleted
     */
    @JsonCreator
    public DeleteMessages(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_ids") List<Long> messageIds) {
        this.chatId = chatId;
        this.messageIds = messageIds;
    }

    @Override
    public String apiMethod() {
        return "deleteMessages";
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
     * A JSON-serialized list of 1-100 identifiers of messages to delete. See deleteMessage for
     * limitations on which messages can be deleted
     */
    public List<Long> messageIds() {
        return messageIds;
    }

    public DeleteMessages withChatId(ChatId chatId) {
        return new DeleteMessages(chatId, messageIds);
    }

    public DeleteMessages withMessageIds(List<Long> messageIds) {
        return new DeleteMessages(chatId, messageIds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeleteMessages)) {
            return false;
        }
        DeleteMessages that = (DeleteMessages) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageIds, that.messageIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.messageIds);
    }

    @Override
    public String toString() {
        return "DeleteMessages[chatId=" + this.chatId
                + ", messageIds=" + this.messageIds
                + "]";
    }
}
