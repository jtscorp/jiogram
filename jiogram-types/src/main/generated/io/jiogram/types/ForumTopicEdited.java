package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class ForumTopicEdited {
    @JsonProperty("name") @Nullable private final String name;
    @JsonProperty("icon_custom_emoji_id") @Nullable private final String iconCustomEmojiId;

    @JsonCreator
    public ForumTopicEdited(
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId
    ) {
        this.name = name;
        this.iconCustomEmojiId = iconCustomEmojiId;
    }

    public String name() {
        return this.name;
    }

    public String iconCustomEmojiId() {
        return this.iconCustomEmojiId;
    }
}
