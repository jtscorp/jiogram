package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class ForumTopicCreated {
    @JsonProperty("name") private final String name;
    @JsonProperty("icon_color") private final long iconColor;
    @JsonProperty("icon_custom_emoji_id") @Nullable private final String iconCustomEmojiId;
    @JsonProperty("is_name_implicit") @Nullable private final Boolean isNameImplicit;

    @JsonCreator
    public ForumTopicCreated(
            @JsonProperty("name") String name,
            @JsonProperty("icon_color") long iconColor,
            @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId,
            @JsonProperty("is_name_implicit") @Nullable Boolean isNameImplicit
    ) {
        this.name = name;
        this.iconColor = iconColor;
        this.iconCustomEmojiId = iconCustomEmojiId;
        this.isNameImplicit = isNameImplicit;
    }

    public String name() {
        return this.name;
    }

    public long iconColor() {
        return this.iconColor;
    }

    public String iconCustomEmojiId() {
        return this.iconCustomEmojiId;
    }

    public Boolean isNameImplicit() {
        return this.isNameImplicit;
    }
}
