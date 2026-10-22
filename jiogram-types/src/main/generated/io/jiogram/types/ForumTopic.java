package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a forum topic.
 *
 * @see <a href="https://core.telegram.org/bots/api#forumtopic">ForumTopic in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ForumTopic {

    @JsonProperty("message_thread_id")
    private final long messageThreadId;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("icon_color")
    private final long iconColor;

    @JsonProperty("icon_custom_emoji_id")
    private final @Nullable String iconCustomEmojiId;

    @JsonProperty("is_name_implicit")
    private final @Nullable Boolean isNameImplicit;

    /**
     * Creates a new {@code ForumTopic} instance.
     *
     * @param messageThreadId Unique identifier of the forum topic
     * @param name Name of the topic
     * @param iconColor Color of the topic icon in RGB format
     * @param iconCustomEmojiId Unique identifier of the custom emoji shown as the topic icon
     * @param isNameImplicit True, if the name of the topic wasn't specified explicitly by its
     *     creator and likely needs to be changed by the bot
     */
    @JsonCreator
    public ForumTopic(
            @JsonProperty("message_thread_id") long messageThreadId,
            @JsonProperty("name") String name,
            @JsonProperty("icon_color") long iconColor,
            @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId,
            @JsonProperty("is_name_implicit") @Nullable Boolean isNameImplicit) {
        this.messageThreadId = messageThreadId;
        this.name = name;
        this.iconColor = iconColor;
        this.iconCustomEmojiId = iconCustomEmojiId;
        this.isNameImplicit = isNameImplicit;
    }

    public static ForumTopic of(long messageThreadId, String name, long iconColor) {
        return new ForumTopic(messageThreadId, name, iconColor, null, null);
    }

    /**
     * Unique identifier of the forum topic
     */
    public long messageThreadId() {
        return messageThreadId;
    }

    /**
     * Name of the topic
     */
    public String name() {
        return name;
    }

    /**
     * Color of the topic icon in RGB format
     */
    public long iconColor() {
        return iconColor;
    }

    /**
     * Unique identifier of the custom emoji shown as the topic icon
     */
    public @Nullable String iconCustomEmojiId() {
        return iconCustomEmojiId;
    }

    /**
     * True, if the name of the topic wasn't specified explicitly by its creator and likely needs to
     * be changed by the bot
     */
    public @Nullable Boolean isNameImplicit() {
        return isNameImplicit;
    }

    public ForumTopic withMessageThreadId(long messageThreadId) {
        return new ForumTopic(messageThreadId, name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopic withName(String name) {
        return new ForumTopic(messageThreadId, name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopic withIconColor(long iconColor) {
        return new ForumTopic(messageThreadId, name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopic withIconCustomEmojiId(@Nullable String iconCustomEmojiId) {
        return new ForumTopic(messageThreadId, name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopic withIsNameImplicit(@Nullable Boolean isNameImplicit) {
        return new ForumTopic(messageThreadId, name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ForumTopic)) {
            return false;
        }
        ForumTopic that = (ForumTopic) o;
        return this.messageThreadId == that.messageThreadId
                && Objects.equals(this.name, that.name)
                && this.iconColor == that.iconColor
                && Objects.equals(this.iconCustomEmojiId, that.iconCustomEmojiId)
                && Objects.equals(this.isNameImplicit, that.isNameImplicit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.messageThreadId, this.name, this.iconColor, this.iconCustomEmojiId, this.isNameImplicit);
    }

    @Override
    public String toString() {
        return "ForumTopic[messageThreadId=" + this.messageThreadId
                + ", name=" + this.name
                + ", iconColor=" + this.iconColor
                + ", iconCustomEmojiId=" + this.iconCustomEmojiId
                + ", isNameImplicit=" + this.isNameImplicit
                + "]";
    }
}
