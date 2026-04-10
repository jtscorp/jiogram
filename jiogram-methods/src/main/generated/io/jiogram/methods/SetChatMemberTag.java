package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetChatMemberTag implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("tag") @Nullable private final String tag;

    @JsonCreator
    public SetChatMemberTag(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId,
            @JsonProperty("tag") @Nullable String tag
    ) {
        this.chatId = chatId;
        this.userId = userId;
        this.tag = tag;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long userId() {
        return this.userId;
    }

    public String tag() {
        return this.tag;
    }

    @Override
    public String apiMethod() {
        return "setChatMemberTag";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetChatMemberTag of(ChatId chatId, long userId) {
        return new SetChatMemberTag(chatId, userId, null);
    }
}
