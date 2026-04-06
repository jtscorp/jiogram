package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatPermissions;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetChatPermissions(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("permissions") ChatPermissions permissions,
    @JsonProperty("use_independent_chat_permissions") @Nullable Boolean useIndependentChatPermissions
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatPermissions";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetChatPermissions of(ChatId chatId, ChatPermissions permissions) {
        return new SetChatPermissions(chatId, permissions, null);
    }
}
