package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionType;
import io.jiogram.types.StoryAreaTypeType;
import org.jspecify.annotations.Nullable;

/**
 * Describes a story area pointing to a suggested reaction. Currently, a story can have up to 5
 * suggested reaction areas.
 *
 * @param type Type of the area, always 'suggested_reaction'
 * @param reactionType Type of the reaction
 * @param isDark Pass True if the reaction area has a dark background
 * @param isFlipped Pass True if reaction area corner is flipped
 * @see <a href="https://core.telegram.org/bots/api#storyareatypesuggestedreaction">StoryAreaTypeSuggestedReaction in the Bot API</a>
 */
public record StoryAreaTypeSuggestedReaction(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
    @JsonProperty("reaction_type") ReactionType reactionType,
    @JsonProperty("is_dark") @Nullable Boolean isDark,
    @JsonProperty("is_flipped") @Nullable Boolean isFlipped
) implements StoryAreaType {

    public StoryAreaTypeSuggestedReaction withReactionType(ReactionType reactionType) {
        return new StoryAreaTypeSuggestedReaction(type, reactionType, isDark, isFlipped);
    }

    public StoryAreaTypeSuggestedReaction withIsDark(@Nullable Boolean isDark) {
        return new StoryAreaTypeSuggestedReaction(type, reactionType, isDark, isFlipped);
    }

    public StoryAreaTypeSuggestedReaction withIsFlipped(@Nullable Boolean isFlipped) {
        return new StoryAreaTypeSuggestedReaction(type, reactionType, isDark, isFlipped);
    }
}
