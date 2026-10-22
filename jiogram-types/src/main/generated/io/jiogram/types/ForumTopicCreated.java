package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a service message about a new forum topic created in the chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#forumtopiccreated">ForumTopicCreated in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ForumTopicCreated {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("icon_color")
    private final long iconColor;

    @JsonProperty("icon_custom_emoji_id")
    private final @Nullable String iconCustomEmojiId;

    @JsonProperty("is_name_implicit")
    private final @Nullable Boolean isNameImplicit;

    /**
     * Creates a new {@code ForumTopicCreated} instance.
     *
     * @param name Name of the topic
     * @param iconColor Color of the topic icon in RGB format
     * @param iconCustomEmojiId Unique identifier of the custom emoji shown as the topic icon
     * @param isNameImplicit True, if the name of the topic wasn't specified explicitly by its
     *     creator and likely needs to be changed by the bot
     */
    @JsonCreator
    public ForumTopicCreated(
            @JsonProperty("name") String name,
            @JsonProperty("icon_color") long iconColor,
            @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId,
            @JsonProperty("is_name_implicit") @Nullable Boolean isNameImplicit) {
        this.name = name;
        this.iconColor = iconColor;
        this.iconCustomEmojiId = iconCustomEmojiId;
        this.isNameImplicit = isNameImplicit;
    }

    public static ForumTopicCreated of(String name, long iconColor) {
        return new ForumTopicCreated(name, iconColor, null, null);
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

    public ForumTopicCreated withName(String name) {
        return new ForumTopicCreated(name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopicCreated withIconColor(long iconColor) {
        return new ForumTopicCreated(name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopicCreated withIconCustomEmojiId(@Nullable String iconCustomEmojiId) {
        return new ForumTopicCreated(name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopicCreated withIsNameImplicit(@Nullable Boolean isNameImplicit) {
        return new ForumTopicCreated(name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ForumTopicCreated)) {
            return false;
        }
        ForumTopicCreated that = (ForumTopicCreated) o;
        return Objects.equals(this.name, that.name)
                && this.iconColor == that.iconColor
                && Objects.equals(this.iconCustomEmojiId, that.iconCustomEmojiId)
                && Objects.equals(this.isNameImplicit, that.isNameImplicit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.iconColor, this.iconCustomEmojiId, this.isNameImplicit);
    }

    @Override
    public String toString() {
        return "ForumTopicCreated[name=" + this.name
                + ", iconColor=" + this.iconColor
                + ", iconCustomEmojiId=" + this.iconCustomEmojiId
                + ", isNameImplicit=" + this.isNameImplicit
                + "]";
    }
}
