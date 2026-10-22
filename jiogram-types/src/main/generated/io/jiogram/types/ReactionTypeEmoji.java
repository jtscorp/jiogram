package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;
import java.util.Objects;

/**
 * The reaction is based on an emoji.
 *
 * @see <a href="https://core.telegram.org/bots/api#reactiontypeemoji">ReactionTypeEmoji in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ReactionTypeEmoji implements ReactionType {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final ReactionTypeType type;

    @JsonProperty("emoji")
    private final String emoji;

    /**
     * Creates a new {@code ReactionTypeEmoji} instance.
     *
     * @param type Type of the reaction, always 'emoji'
     * @param emoji Reaction emoji. Currently, it can be one of "", "", "", "", "", "", "", "", "",
     *     "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
     *     "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
     *     "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
     */
    @JsonCreator
    public ReactionTypeEmoji(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) ReactionTypeType type,
            @JsonProperty("emoji") String emoji) {
        this.type = type;
        this.emoji = emoji;
    }

    public static ReactionTypeEmoji of(String emoji) {
        return new ReactionTypeEmoji(ReactionTypeType.EMOJI, emoji);
    }

    /**
     * Type of the reaction, always 'emoji'
     */
    public ReactionTypeType type() {
        return type;
    }

    /**
     * Reaction emoji. Currently, it can be one of "", "", "", "", "", "", "", "", "", "", "", "",
     * "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
     * "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
     * "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
     */
    public String emoji() {
        return emoji;
    }

    public ReactionTypeEmoji withEmoji(String emoji) {
        return new ReactionTypeEmoji(type, emoji);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReactionTypeEmoji)) {
            return false;
        }
        ReactionTypeEmoji that = (ReactionTypeEmoji) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.emoji, that.emoji);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.emoji);
    }

    @Override
    public String toString() {
        return "ReactionTypeEmoji[type=" + this.type
                + ", emoji=" + this.emoji
                + "]";
    }
}
