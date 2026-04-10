package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class EditChatSubscriptionInviteLink implements TelegramMethod<ChatInviteLink> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("invite_link") private final String inviteLink;
    @JsonProperty("name") @Nullable private final String name;

    @JsonCreator
    public EditChatSubscriptionInviteLink(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("invite_link") String inviteLink,
            @JsonProperty("name") @Nullable String name
    ) {
        this.chatId = chatId;
        this.inviteLink = inviteLink;
        this.name = name;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public String inviteLink() {
        return this.inviteLink;
    }

    public String name() {
        return this.name;
    }

    @Override
    public String apiMethod() {
        return "editChatSubscriptionInviteLink";
    }

    @Override
    public String apiReturnType() {
        return "ChatInviteLink";
    }

    public static EditChatSubscriptionInviteLink of(ChatId chatId, String inviteLink) {
        return new EditChatSubscriptionInviteLink(chatId, inviteLink, null);
    }
}
