package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ForumTopic;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class CreateForumTopic implements TelegramMethod<ForumTopic> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("name") private final String name;
    @JsonProperty("icon_color") @Nullable private final Long iconColor;
    @JsonProperty("icon_custom_emoji_id") @Nullable private final String iconCustomEmojiId;

    @JsonCreator
    public CreateForumTopic(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("name") String name,
            @JsonProperty("icon_color") @Nullable Long iconColor,
            @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId
    ) {
        this.chatId = chatId;
        this.name = name;
        this.iconColor = iconColor;
        this.iconCustomEmojiId = iconCustomEmojiId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public String name() {
        return this.name;
    }

    public Long iconColor() {
        return this.iconColor;
    }

    public String iconCustomEmojiId() {
        return this.iconCustomEmojiId;
    }

    @Override
    public String apiMethod() {
        return "createForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "ForumTopic";
    }

    public static CreateForumTopic of(ChatId chatId, String name) {
        return new CreateForumTopic(chatId, name, null, null);
    }
}
