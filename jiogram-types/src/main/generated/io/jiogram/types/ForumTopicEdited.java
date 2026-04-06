package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record ForumTopicEdited(
    @JsonProperty("name") @Nullable String name,
    @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId
) {}
