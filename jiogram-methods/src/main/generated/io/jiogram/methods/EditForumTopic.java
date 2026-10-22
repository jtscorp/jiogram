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
 * Use this method to edit name and icon of a topic in a forum supergroup chat or a private chat
 * with a user. In the case of a supergroup chat the bot must be an administrator in the chat for
 * this to work and must have the can_manage_topics administrator rights, unless it is the creator
 * of the topic. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#editforumtopic">editForumTopic in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EditForumTopic implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final long messageThreadId;

    @JsonProperty("name")
    private final @Nullable String name;

    @JsonProperty("icon_custom_emoji_id")
    private final @Nullable String iconCustomEmojiId;

    /**
     * Creates a new {@code EditForumTopic} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     * @param messageThreadId Unique identifier for the target message thread of the forum topic
     * @param name New topic name, 0-128 characters. If not specified or empty, the current name of
     *     the topic will be kept
     * @param iconCustomEmojiId New unique identifier of the custom emoji shown as the topic icon.
     *     Use getForumTopicIconStickers to get all allowed custom emoji identifiers. Pass an empty
     *     string to remove the icon. If not specified, the current icon will be kept
     */
    @JsonCreator
    public EditForumTopic(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") long messageThreadId,
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.name = name;
        this.iconCustomEmojiId = iconCustomEmojiId;
    }

    @Override
    public String apiMethod() {
        return "editForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static EditForumTopic of(ChatId chatId, long messageThreadId) {
        return new EditForumTopic(chatId, messageThreadId, null, null);
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

    /**
     * New topic name, 0-128 characters. If not specified or empty, the current name of the topic
     * will be kept
     */
    public @Nullable String name() {
        return name;
    }

    /**
     * New unique identifier of the custom emoji shown as the topic icon. Use
     * getForumTopicIconStickers to get all allowed custom emoji identifiers. Pass an empty string
     * to remove the icon. If not specified, the current icon will be kept
     */
    public @Nullable String iconCustomEmojiId() {
        return iconCustomEmojiId;
    }

    public EditForumTopic withChatId(ChatId chatId) {
        return new EditForumTopic(chatId, messageThreadId, name, iconCustomEmojiId);
    }

    public EditForumTopic withMessageThreadId(long messageThreadId) {
        return new EditForumTopic(chatId, messageThreadId, name, iconCustomEmojiId);
    }

    public EditForumTopic withName(@Nullable String name) {
        return new EditForumTopic(chatId, messageThreadId, name, iconCustomEmojiId);
    }

    public EditForumTopic withIconCustomEmojiId(@Nullable String iconCustomEmojiId) {
        return new EditForumTopic(chatId, messageThreadId, name, iconCustomEmojiId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EditForumTopic)) {
            return false;
        }
        EditForumTopic that = (EditForumTopic) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.messageThreadId == that.messageThreadId
                && Objects.equals(this.name, that.name)
                && Objects.equals(this.iconCustomEmojiId, that.iconCustomEmojiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.messageThreadId, this.name, this.iconCustomEmojiId);
    }

    @Override
    public String toString() {
        return "EditForumTopic[chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", name=" + this.name
                + ", iconCustomEmojiId=" + this.iconCustomEmojiId
                + "]";
    }
}
