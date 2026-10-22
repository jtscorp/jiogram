package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to edit the name of the 'General' topic in a forum supergroup chat. The bot must
 * be an administrator in the chat for this to work and must have the can_manage_topics
 * administrator rights. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#editgeneralforumtopic">editGeneralForumTopic in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EditGeneralForumTopic implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("name")
    private final String name;

    /**
     * Creates a new {@code EditGeneralForumTopic} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     * @param name New topic name, 1-128 characters
     */
    @JsonCreator
    public EditGeneralForumTopic(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("name") String name) {
        this.chatId = chatId;
        this.name = name;
    }

    @Override
    public String apiMethod() {
        return "editGeneralForumTopic";
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
     * New topic name, 1-128 characters
     */
    public String name() {
        return name;
    }

    public EditGeneralForumTopic withChatId(ChatId chatId) {
        return new EditGeneralForumTopic(chatId, name);
    }

    public EditGeneralForumTopic withName(String name) {
        return new EditGeneralForumTopic(chatId, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EditGeneralForumTopic)) {
            return false;
        }
        EditGeneralForumTopic that = (EditGeneralForumTopic) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.name);
    }

    @Override
    public String toString() {
        return "EditGeneralForumTopic[chatId=" + this.chatId
                + ", name=" + this.name
                + "]";
    }
}
