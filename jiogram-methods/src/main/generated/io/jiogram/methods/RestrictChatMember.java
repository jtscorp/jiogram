package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatPermissions;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record RestrictChatMember(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId,
    @JsonProperty("permissions") ChatPermissions permissions,
    @JsonProperty("use_independent_chat_permissions") @Nullable Boolean useIndependentChatPermissions,
    @JsonProperty("until_date") @Nullable Long untilDate
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "restrictChatMember";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static RestrictChatMember of(ChatId chatId, long userId, ChatPermissions permissions) {
        return new RestrictChatMember(chatId, userId, permissions, null, null);
    }
}
