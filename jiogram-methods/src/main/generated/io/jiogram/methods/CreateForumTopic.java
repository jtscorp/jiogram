package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ForumTopic;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to create a topic in a forum supergroup chat or a private chat with a user. In
 * the case of a supergroup chat the bot must be an administrator in the chat for this to work and
 * must have the can_manage_topics administrator right. Returns information about the created topic
 * as a ForumTopic object.
 *
 * @see <a href="https://core.telegram.org/bots/api#createforumtopic">createForumTopic in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class CreateForumTopic implements TelegramMethod<ForumTopic> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("icon_color")
    private final @Nullable Long iconColor;

    @JsonProperty("icon_custom_emoji_id")
    private final @Nullable String iconCustomEmojiId;

    /**
     * Creates a new {@code CreateForumTopic} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     * @param name Topic name, 1-128 characters
     * @param iconColor Color of the topic icon in RGB format. Currently, must be one of 7322096
     *     (0x6FB9F0), 16766590 (0xFFD67E), 13338331 (0xCB86DB), 9367192 (0x8EEE98), 16749490
     *     (0xFF93B2), or 16478047 (0xFB6F5F)
     * @param iconCustomEmojiId Unique identifier of the custom emoji shown as the topic icon. Use
     *     getForumTopicIconStickers to get all allowed custom emoji identifiers.
     */
    @JsonCreator
    public CreateForumTopic(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("name") String name,
            @JsonProperty("icon_color") @Nullable Long iconColor,
            @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId) {
        this.chatId = chatId;
        this.name = name;
        this.iconColor = iconColor;
        this.iconCustomEmojiId = iconCustomEmojiId;
    }

    @Override
    public String apiMethod() {
        return "createForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "ForumTopic";
    }

    public static CreateForumTopic of(ChatId chatId, String name) {
        return new CreateForumTopic(chatId, name, null, null);
    }

    /**
     * Unique identifier for the target chat or username of the target supergroup (in the format
     * &#64;supergroupusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Topic name, 1-128 characters
     */
    public String name() {
        return name;
    }

    /**
     * Color of the topic icon in RGB format. Currently, must be one of 7322096 (0x6FB9F0), 16766590
     * (0xFFD67E), 13338331 (0xCB86DB), 9367192 (0x8EEE98), 16749490 (0xFF93B2), or 16478047
     * (0xFB6F5F)
     */
    public @Nullable Long iconColor() {
        return iconColor;
    }

    /**
     * Unique identifier of the custom emoji shown as the topic icon. Use getForumTopicIconStickers
     * to get all allowed custom emoji identifiers.
     */
    public @Nullable String iconCustomEmojiId() {
        return iconCustomEmojiId;
    }

    public CreateForumTopic withChatId(ChatId chatId) {
        return new CreateForumTopic(chatId, name, iconColor, iconCustomEmojiId);
    }

    public CreateForumTopic withName(String name) {
        return new CreateForumTopic(chatId, name, iconColor, iconCustomEmojiId);
    }

    public CreateForumTopic withIconColor(@Nullable Long iconColor) {
        return new CreateForumTopic(chatId, name, iconColor, iconCustomEmojiId);
    }

    public CreateForumTopic withIconCustomEmojiId(@Nullable String iconCustomEmojiId) {
        return new CreateForumTopic(chatId, name, iconColor, iconCustomEmojiId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CreateForumTopic)) {
            return false;
        }
        CreateForumTopic that = (CreateForumTopic) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.name, that.name)
                && Objects.equals(this.iconColor, that.iconColor)
                && Objects.equals(this.iconCustomEmojiId, that.iconCustomEmojiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.name, this.iconColor, this.iconCustomEmojiId);
    }

    @Override
    public String toString() {
        return "CreateForumTopic[chatId=" + this.chatId
                + ", name=" + this.name
                + ", iconColor=" + this.iconColor
                + ", iconCustomEmojiId=" + this.iconCustomEmojiId
                + "]";
    }
}
