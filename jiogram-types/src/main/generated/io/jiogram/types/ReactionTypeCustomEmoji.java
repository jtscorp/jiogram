package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReactionTypeCustomEmoji(
    @JsonProperty("type") String type,
    @JsonProperty("custom_emoji_id") String customEmojiId
) implements ReactionType {}
