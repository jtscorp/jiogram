package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ForumTopic;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record CreateForumTopic(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("name") String name,
    @JsonProperty("icon_color") @Nullable Long iconColor,
    @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId
) implements TelegramMethod<ForumTopic> {

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
