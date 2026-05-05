package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;

public class ReactionTypeCustomEmoji implements ReactionType {
    @JsonProperty("type") private final ReactionTypeType type;
    @JsonProperty("custom_emoji_id") private final String customEmojiId;

    @JsonCreator
    public ReactionTypeCustomEmoji(
            @JsonProperty("type") ReactionTypeType type,
            @JsonProperty("custom_emoji_id") String customEmojiId
    ) {
        this.type = type;
        this.customEmojiId = customEmojiId;
    }

    public ReactionTypeType type() {
        return this.type;
    }

    public String customEmojiId() {
        return this.customEmojiId;
    }
}
