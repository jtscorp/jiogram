package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to delete a forum topic along with all its messages in a forum supergroup chat or
 * a private chat with a user. In the case of a supergroup chat the bot must be an administrator in
 * the chat for this to work and must have the can_delete_messages administrator rights. Returns
 * True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deleteforumtopic">deleteForumTopic in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DeleteForumTopic implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final long messageThreadId;

    /**
     * Creates a new {@code DeleteForumTopic} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     * @param messageThreadId Unique identifier for the target message thread of the forum topic
     */
    @JsonCreator
    public DeleteForumTopic(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") long messageThreadId) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
    }

    @Override
    public String apiMethod() {
        return "deleteForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Unique identifier for the target chat or username of the target supergroup (in the format
     * &#64;supergroupusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Unique identifier for the target message thread of the forum topic
     */
    public long messageThreadId() {
        return messageThreadId;
    }

    public DeleteForumTopic withChatId(ChatId chatId) {
        return new DeleteForumTopic(chatId, messageThreadId);
    }

    public DeleteForumTopic withMessageThreadId(long messageThreadId) {
        return new DeleteForumTopic(chatId, messageThreadId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeleteForumTopic)) {
            return false;
        }
        DeleteForumTopic that = (DeleteForumTopic) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.messageThreadId == that.messageThreadId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.messageThreadId);
    }

    @Override
    public String toString() {
        return "DeleteForumTopic[chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + "]";
    }
}
