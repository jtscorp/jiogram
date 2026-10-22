package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to reopen a closed 'General' topic in a forum supergroup chat. The bot must be an
 * administrator in the chat for this to work and must have the can_manage_topics administrator
 * rights. The topic will be automatically unhidden if it was hidden. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#reopengeneralforumtopic">reopenGeneralForumTopic in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ReopenGeneralForumTopic implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    /**
     * Creates a new {@code ReopenGeneralForumTopic} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     */
    @JsonCreator
    public ReopenGeneralForumTopic(
            @JsonProperty("chat_id") ChatId chatId) {
        this.chatId = chatId;
    }

    @Override
    public String apiMethod() {
        return "reopenGeneralForumTopic";
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

    public ReopenGeneralForumTopic withChatId(ChatId chatId) {
        return new ReopenGeneralForumTopic(chatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReopenGeneralForumTopic)) {
            return false;
        }
        ReopenGeneralForumTopic that = (ReopenGeneralForumTopic) o;
        return Objects.equals(this.chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId);
    }

    @Override
    public String toString() {
        return "ReopenGeneralForumTopic[chatId=" + this.chatId
                + "]";
    }
}
