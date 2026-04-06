package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record CreateChatInviteLink(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("name") @Nullable String name,
    @JsonProperty("expire_date") @Nullable Long expireDate,
    @JsonProperty("member_limit") @Nullable Long memberLimit,
    @JsonProperty("creates_join_request") @Nullable Boolean createsJoinRequest
) implements TelegramMethod<ChatInviteLink> {

    @Override
    public String apiMethod() {
        return "createChatInviteLink";
    }

    @Override
    public String apiReturnType() {
        return "ChatInviteLink";
    }

    public static CreateChatInviteLink of(ChatId chatId) {
        return new CreateChatInviteLink(chatId, null, null, null, null);
    }
}
