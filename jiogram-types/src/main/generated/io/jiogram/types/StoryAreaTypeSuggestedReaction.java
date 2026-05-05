package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionType;
import io.jiogram.types.StoryAreaTypeType;
import org.jspecify.annotations.Nullable;

public class StoryAreaTypeSuggestedReaction implements StoryAreaType {
    @JsonProperty("type") private final StoryAreaTypeType type;
    @JsonProperty("reaction_type") private final ReactionType reactionType;
    @JsonProperty("is_dark") @Nullable private final Boolean isDark;
    @JsonProperty("is_flipped") @Nullable private final Boolean isFlipped;

    @JsonCreator
    public StoryAreaTypeSuggestedReaction(
            @JsonProperty("type") StoryAreaTypeType type,
            @JsonProperty("reaction_type") ReactionType reactionType,
            @JsonProperty("is_dark") @Nullable Boolean isDark,
            @JsonProperty("is_flipped") @Nullable Boolean isFlipped
    ) {
        this.type = type;
        this.reactionType = reactionType;
        this.isDark = isDark;
        this.isFlipped = isFlipped;
    }

    public StoryAreaTypeType type() {
        return this.type;
    }

    public ReactionType reactionType() {
        return this.reactionType;
    }

    public Boolean isDark() {
        return this.isDark;
    }

    public Boolean isFlipped() {
        return this.isFlipped;
    }
}
