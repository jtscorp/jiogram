package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;

public record ReactionTypeCustomEmoji(
    @JsonProperty("type") ReactionTypeType type,
    @JsonProperty("custom_emoji_id") String customEmojiId
) implements ReactionType {}
