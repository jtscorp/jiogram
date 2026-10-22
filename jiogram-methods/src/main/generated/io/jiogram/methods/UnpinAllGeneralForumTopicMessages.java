package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to clear the list of pinned messages in a General forum topic. The bot must be an
 * administrator in the chat for this to work and must have the can_pin_messages administrator right
 * in the supergroup. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#unpinallgeneralforumtopicmessages">unpinAllGeneralForumTopicMessages in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UnpinAllGeneralForumTopicMessages implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    /**
     * Creates a new {@code UnpinAllGeneralForumTopicMessages} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     */
    @JsonCreator
    public UnpinAllGeneralForumTopicMessages(
            @JsonProperty("chat_id") ChatId chatId) {
        this.chatId = chatId;
    }

    @Override
    public String apiMethod() {
        return "unpinAllGeneralForumTopicMessages";
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

    public UnpinAllGeneralForumTopicMessages withChatId(ChatId chatId) {
        return new UnpinAllGeneralForumTopicMessages(chatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UnpinAllGeneralForumTopicMessages)) {
            return false;
        }
        UnpinAllGeneralForumTopicMessages that = (UnpinAllGeneralForumTopicMessages) o;
        return Objects.equals(this.chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId);
    }

    @Override
    public String toString() {
        return "UnpinAllGeneralForumTopicMessages[chatId=" + this.chatId
                + "]";
    }
}
