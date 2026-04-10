package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;

public class RevokeChatInviteLink implements TelegramMethod<ChatInviteLink> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("invite_link") private final String inviteLink;

    @JsonCreator
    public RevokeChatInviteLink(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("invite_link") String inviteLink
    ) {
        this.chatId = chatId;
        this.inviteLink = inviteLink;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public String inviteLink() {
        return this.inviteLink;
    }

    @Override
    public String apiMethod() {
        return "revokeChatInviteLink";
    }

    @Override
    public String apiReturnType() {
        return "ChatInviteLink";
    }
}
