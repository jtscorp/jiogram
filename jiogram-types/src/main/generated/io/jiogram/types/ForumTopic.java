package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record ForumTopic(
    @JsonProperty("message_thread_id") long messageThreadId,
    @JsonProperty("name") String name,
    @JsonProperty("icon_color") long iconColor,
    @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId,
    @JsonProperty("is_name_implicit") @Nullable Boolean isNameImplicit
) {}
