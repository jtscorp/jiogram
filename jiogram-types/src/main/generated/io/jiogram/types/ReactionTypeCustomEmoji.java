package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;
import java.util.Objects;

/**
 * The reaction is based on a custom emoji.
 *
 * @see <a href="https://core.telegram.org/bots/api#reactiontypecustomemoji">ReactionTypeCustomEmoji in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ReactionTypeCustomEmoji implements ReactionType {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final ReactionTypeType type;

    @JsonProperty("custom_emoji_id")
    private final String customEmojiId;

    /**
     * Creates a new {@code ReactionTypeCustomEmoji} instance.
     *
     * @param type Type of the reaction, always 'custom_emoji'
     * @param customEmojiId Custom emoji identifier
     */
    @JsonCreator
    public ReactionTypeCustomEmoji(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) ReactionTypeType type,
            @JsonProperty("custom_emoji_id") String customEmojiId) {
        this.type = type;
        this.customEmojiId = customEmojiId;
    }

    public static ReactionTypeCustomEmoji of(String customEmojiId) {
        return new ReactionTypeCustomEmoji(ReactionTypeType.CUSTOM_EMOJI, customEmojiId);
    }

    /**
     * Type of the reaction, always 'custom_emoji'
     */
    public ReactionTypeType type() {
        return type;
    }

    /**
     * Custom emoji identifier
     */
    public String customEmojiId() {
        return customEmojiId;
    }

    public ReactionTypeCustomEmoji withCustomEmojiId(String customEmojiId) {
        return new ReactionTypeCustomEmoji(type, customEmojiId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReactionTypeCustomEmoji)) {
            return false;
        }
        ReactionTypeCustomEmoji that = (ReactionTypeCustomEmoji) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.customEmojiId, that.customEmojiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.customEmojiId);
    }

    @Override
    public String toString() {
        return "ReactionTypeCustomEmoji[type=" + this.type
                + ", customEmojiId=" + this.customEmojiId
                + "]";
    }
}
