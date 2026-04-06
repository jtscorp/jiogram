package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record UnbanChatMember(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId,
    @JsonProperty("only_if_banned") @Nullable Boolean onlyIfBanned
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "unbanChatMember";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static UnbanChatMember of(ChatId chatId, long userId) {
        return new UnbanChatMember(chatId, userId, null);
    }
}
