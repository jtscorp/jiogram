package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record EditForumTopic(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") long messageThreadId,
    @JsonProperty("name") @Nullable String name,
    @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "editForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static EditForumTopic of(ChatId chatId, long messageThreadId) {
        return new EditForumTopic(chatId, messageThreadId, null, null);
    }
}
