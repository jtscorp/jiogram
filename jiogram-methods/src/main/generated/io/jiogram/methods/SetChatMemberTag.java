package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetChatMemberTag(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId,
    @JsonProperty("tag") @Nullable String tag
) implements TelegramMethod<Boolean> {

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
