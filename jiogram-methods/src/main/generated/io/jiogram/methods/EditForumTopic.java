package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class EditForumTopic implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_thread_id") private final long messageThreadId;
    @JsonProperty("name") @Nullable private final String name;
    @JsonProperty("icon_custom_emoji_id") @Nullable private final String iconCustomEmojiId;

    @JsonCreator
    public EditForumTopic(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") long messageThreadId,
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId
    ) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.name = name;
        this.iconCustomEmojiId = iconCustomEmojiId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long messageThreadId() {
        return this.messageThreadId;
    }

    public String name() {
        return this.name;
    }

    public String iconCustomEmojiId() {
        return this.iconCustomEmojiId;
    }

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
