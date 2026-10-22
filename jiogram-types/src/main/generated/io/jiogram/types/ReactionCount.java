package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionType;

/**
 * Represents a reaction added to a message along with the number of times it was added.
 *
 * @param type Type of the reaction
 * @param totalCount Number of times the reaction was added
 * @see <a href="https://core.telegram.org/bots/api#reactioncount">ReactionCount in the Bot API</a>
 */
public record ReactionCount(
    @JsonProperty("type") ReactionType type,
    @JsonProperty("total_count") long totalCount
) {

    public ReactionCount withType(ReactionType type) {
        return new ReactionCount(type, totalCount);
    }

    public ReactionCount withTotalCount(long totalCount) {
        return new ReactionCount(type, totalCount);
    }
}
