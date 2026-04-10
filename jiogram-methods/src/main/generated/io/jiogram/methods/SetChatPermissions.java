package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatPermissions;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetChatPermissions implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("permissions") private final ChatPermissions permissions;
    @JsonProperty("use_independent_chat_permissions") @Nullable private final Boolean useIndependentChatPermissions;

    @JsonCreator
    public SetChatPermissions(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("permissions") ChatPermissions permissions,
            @JsonProperty("use_independent_chat_permissions") @Nullable Boolean useIndependentChatPermissions
    ) {
        this.chatId = chatId;
        this.permissions = permissions;
        this.useIndependentChatPermissions = useIndependentChatPermissions;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public ChatPermissions permissions() {
        return this.permissions;
    }

    public Boolean useIndependentChatPermissions() {
        return this.useIndependentChatPermissions;
    }

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
