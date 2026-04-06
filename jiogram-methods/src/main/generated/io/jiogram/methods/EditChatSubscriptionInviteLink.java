package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record EditChatSubscriptionInviteLink(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("invite_link") String inviteLink,
    @JsonProperty("name") @Nullable String name
) implements TelegramMethod<ChatInviteLink> {

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
