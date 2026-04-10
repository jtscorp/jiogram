package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatPermissions;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class RestrictChatMember implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("permissions") private final ChatPermissions permissions;
    @JsonProperty("use_independent_chat_permissions") @Nullable private final Boolean useIndependentChatPermissions;
    @JsonProperty("until_date") @Nullable private final Long untilDate;

    @JsonCreator
    public RestrictChatMember(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId,
            @JsonProperty("permissions") ChatPermissions permissions,
            @JsonProperty("use_independent_chat_permissions") @Nullable Boolean useIndependentChatPermissions,
            @JsonProperty("until_date") @Nullable Long untilDate
    ) {
        this.chatId = chatId;
        this.userId = userId;
        this.permissions = permissions;
        this.useIndependentChatPermissions = useIndependentChatPermissions;
        this.untilDate = untilDate;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long userId() {
        return this.userId;
    }

    public ChatPermissions permissions() {
        return this.permissions;
    }

    public Boolean useIndependentChatPermissions() {
        return this.useIndependentChatPermissions;
    }

    public Long untilDate() {
        return this.untilDate;
    }

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
