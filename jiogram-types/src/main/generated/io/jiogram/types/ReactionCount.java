package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionType;
import java.util.Objects;

/**
 * Represents a reaction added to a message along with the number of times it was added.
 *
 * @see <a href="https://core.telegram.org/bots/api#reactioncount">ReactionCount in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ReactionCount {

    @JsonProperty("type")
    private final ReactionType type;

    @JsonProperty("total_count")
    private final long totalCount;

    /**
     * Creates a new {@code ReactionCount} instance.
     *
     * @param type Type of the reaction
     * @param totalCount Number of times the reaction was added
     */
    @JsonCreator
    public ReactionCount(
            @JsonProperty("type") ReactionType type,
            @JsonProperty("total_count") long totalCount) {
        this.type = type;
        this.totalCount = totalCount;
    }

    /**
     * Type of the reaction
     */
    public ReactionType type() {
        return type;
    }

    /**
     * Number of times the reaction was added
     */
    public long totalCount() {
        return totalCount;
    }

    public ReactionCount withType(ReactionType type) {
        return new ReactionCount(type, totalCount);
    }

    public ReactionCount withTotalCount(long totalCount) {
        return new ReactionCount(type, totalCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReactionCount)) {
            return false;
        }
        ReactionCount that = (ReactionCount) o;
        return Objects.equals(this.type, that.type)
                && this.totalCount == that.totalCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.totalCount);
    }

    @Override
    public String toString() {
        return "ReactionCount[type=" + this.type
                + ", totalCount=" + this.totalCount
                + "]";
    }
}
