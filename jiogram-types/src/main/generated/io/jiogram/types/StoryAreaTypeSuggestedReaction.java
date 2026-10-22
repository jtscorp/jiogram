package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionType;
import io.jiogram.types.StoryAreaTypeType;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a story area pointing to a suggested reaction. Currently, a story can have up to 5
 * suggested reaction areas.
 *
 * @see <a href="https://core.telegram.org/bots/api#storyareatypesuggestedreaction">StoryAreaTypeSuggestedReaction in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class StoryAreaTypeSuggestedReaction implements StoryAreaType {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final StoryAreaTypeType type;

    @JsonProperty("reaction_type")
    private final ReactionType reactionType;

    @JsonProperty("is_dark")
    private final @Nullable Boolean isDark;

    @JsonProperty("is_flipped")
    private final @Nullable Boolean isFlipped;

    /**
     * Creates a new {@code StoryAreaTypeSuggestedReaction} instance.
     *
     * @param type Type of the area, always 'suggested_reaction'
     * @param reactionType Type of the reaction
     * @param isDark Pass True if the reaction area has a dark background
     * @param isFlipped Pass True if reaction area corner is flipped
     */
    @JsonCreator
    public StoryAreaTypeSuggestedReaction(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
            @JsonProperty("reaction_type") ReactionType reactionType,
            @JsonProperty("is_dark") @Nullable Boolean isDark,
            @JsonProperty("is_flipped") @Nullable Boolean isFlipped) {
        this.type = type;
        this.reactionType = reactionType;
        this.isDark = isDark;
        this.isFlipped = isFlipped;
    }

    public static StoryAreaTypeSuggestedReaction of(ReactionType reactionType) {
        return new StoryAreaTypeSuggestedReaction(StoryAreaTypeType.SUGGESTED_REACTION, reactionType, null, null);
    }

    /**
     * Type of the area, always 'suggested_reaction'
     */
    public StoryAreaTypeType type() {
        return type;
    }

    /**
     * Type of the reaction
     */
    public ReactionType reactionType() {
        return reactionType;
    }

    /**
     * Pass True if the reaction area has a dark background
     */
    public @Nullable Boolean isDark() {
        return isDark;
    }

    /**
     * Pass True if reaction area corner is flipped
     */
    public @Nullable Boolean isFlipped() {
        return isFlipped;
    }

    public StoryAreaTypeSuggestedReaction withReactionType(ReactionType reactionType) {
        return new StoryAreaTypeSuggestedReaction(type, reactionType, isDark, isFlipped);
    }

    public StoryAreaTypeSuggestedReaction withIsDark(@Nullable Boolean isDark) {
        return new StoryAreaTypeSuggestedReaction(type, reactionType, isDark, isFlipped);
    }

    public StoryAreaTypeSuggestedReaction withIsFlipped(@Nullable Boolean isFlipped) {
        return new StoryAreaTypeSuggestedReaction(type, reactionType, isDark, isFlipped);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoryAreaTypeSuggestedReaction)) {
            return false;
        }
        StoryAreaTypeSuggestedReaction that = (StoryAreaTypeSuggestedReaction) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.reactionType, that.reactionType)
                && Objects.equals(this.isDark, that.isDark)
                && Objects.equals(this.isFlipped, that.isFlipped);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.reactionType, this.isDark, this.isFlipped);
    }

    @Override
    public String toString() {
        return "StoryAreaTypeSuggestedReaction[type=" + this.type
                + ", reactionType=" + this.reactionType
                + ", isDark=" + this.isDark
                + ", isFlipped=" + this.isFlipped
                + "]";
    }
}
