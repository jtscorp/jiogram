package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;

public record RevokeChatInviteLink(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("invite_link") String inviteLink
) implements TelegramMethod<ChatInviteLink> {

    @Override
    public String apiMethod() {
        return "revokeChatInviteLink";
    }

    @Override
    public String apiReturnType() {
        return "ChatInviteLink";
    }
}
