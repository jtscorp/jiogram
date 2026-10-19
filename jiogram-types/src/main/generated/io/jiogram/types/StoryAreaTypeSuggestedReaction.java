package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionType;
import io.jiogram.types.StoryAreaTypeType;
import org.jspecify.annotations.Nullable;

public record StoryAreaTypeSuggestedReaction(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
    @JsonProperty("reaction_type") ReactionType reactionType,
    @JsonProperty("is_dark") @Nullable Boolean isDark,
    @JsonProperty("is_flipped") @Nullable Boolean isFlipped
) implements StoryAreaType {}
