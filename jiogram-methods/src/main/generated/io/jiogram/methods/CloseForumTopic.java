package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to close an open topic in a forum supergroup chat. The bot must be an
 * administrator in the chat for this to work and must have the can_manage_topics administrator
 * rights, unless it is the creator of the topic. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#closeforumtopic">closeForumTopic in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class CloseForumTopic implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final long messageThreadId;

    /**
     * Creates a new {@code CloseForumTopic} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     * @param messageThreadId Unique identifier for the target message thread of the forum topic
     */
    @JsonCreator
    public CloseForumTopic(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") long messageThreadId) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
    }

    @Override
    public String apiMethod() {
        return "closeForumTopic";
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

    public CloseForumTopic withChatId(ChatId chatId) {
        return new CloseForumTopic(chatId, messageThreadId);
    }

    public CloseForumTopic withMessageThreadId(long messageThreadId) {
        return new CloseForumTopic(chatId, messageThreadId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CloseForumTopic)) {
            return false;
        }
        CloseForumTopic that = (CloseForumTopic) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.messageThreadId == that.messageThreadId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.messageThreadId);
    }

    @Override
    public String toString() {
        return "CloseForumTopic[chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + "]";
    }
}
