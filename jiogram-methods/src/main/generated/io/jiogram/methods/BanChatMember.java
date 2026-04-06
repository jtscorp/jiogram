package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record BanChatMember(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId,
    @JsonProperty("until_date") @Nullable Long untilDate,
    @JsonProperty("revoke_messages") @Nullable Boolean revokeMessages
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "banChatMember";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static BanChatMember of(ChatId chatId, long userId) {
        return new BanChatMember(chatId, userId, null, null);
    }
}
