package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReactionTypeCustomEmoji implements ReactionType {
    @JsonProperty("type") private final String type;
    @JsonProperty("custom_emoji_id") private final String customEmojiId;

    @JsonCreator
    public ReactionTypeCustomEmoji(
            @JsonProperty("type") String type,
            @JsonProperty("custom_emoji_id") String customEmojiId
    ) {
        this.type = type;
        this.customEmojiId = customEmojiId;
    }

    public String type() {
        return this.type;
    }

    public String customEmojiId() {
        return this.customEmojiId;
    }
}
