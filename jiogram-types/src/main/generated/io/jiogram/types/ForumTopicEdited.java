package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a service message about an edited forum topic.
 *
 * @see <a href="https://core.telegram.org/bots/api#forumtopicedited">ForumTopicEdited in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ForumTopicEdited {

    @JsonProperty("name")
    private final @Nullable String name;

    @JsonProperty("icon_custom_emoji_id")
    private final @Nullable String iconCustomEmojiId;

    /**
     * Creates a new {@code ForumTopicEdited} instance.
     *
     * @param name New name of the topic, if it was edited
     * @param iconCustomEmojiId New identifier of the custom emoji shown as the topic icon, if it
     *     was edited; an empty string if the icon was removed
     */
    @JsonCreator
    public ForumTopicEdited(
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId) {
        this.name = name;
        this.iconCustomEmojiId = iconCustomEmojiId;
    }

    public static ForumTopicEdited of() {
        return new ForumTopicEdited(null, null);
    }

    /**
     * New name of the topic, if it was edited
     */
    public @Nullable String name() {
        return name;
    }

    /**
     * New identifier of the custom emoji shown as the topic icon, if it was edited; an empty string
     * if the icon was removed
     */
    public @Nullable String iconCustomEmojiId() {
        return iconCustomEmojiId;
    }

    public ForumTopicEdited withName(@Nullable String name) {
        return new ForumTopicEdited(name, iconCustomEmojiId);
    }

    public ForumTopicEdited withIconCustomEmojiId(@Nullable String iconCustomEmojiId) {
        return new ForumTopicEdited(name, iconCustomEmojiId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ForumTopicEdited)) {
            return false;
        }
        ForumTopicEdited that = (ForumTopicEdited) o;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.iconCustomEmojiId, that.iconCustomEmojiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.iconCustomEmojiId);
    }

    @Override
    public String toString() {
        return "ForumTopicEdited[name=" + this.name
                + ", iconCustomEmojiId=" + this.iconCustomEmojiId
                + "]";
    }
}
