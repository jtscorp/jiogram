package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record EditChatInviteLink(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("invite_link") String inviteLink,
    @JsonProperty("name") @Nullable String name,
    @JsonProperty("expire_date") @Nullable Long expireDate,
    @JsonProperty("member_limit") @Nullable Long memberLimit,
    @JsonProperty("creates_join_request") @Nullable Boolean createsJoinRequest
) implements TelegramMethod<ChatInviteLink> {

    @Override
    public String apiMethod() {
        return "editChatInviteLink";
    }

    @Override
    public String apiReturnType() {
        return "ChatInviteLink";
    }

    public static EditChatInviteLink of(ChatId chatId, String inviteLink) {
        return new EditChatInviteLink(chatId, inviteLink, null, null, null, null);
    }
}
