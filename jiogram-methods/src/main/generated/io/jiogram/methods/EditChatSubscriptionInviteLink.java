package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit a subscription invite link created by the bot. The bot must have the
 * can_invite_users administrator rights. Returns the edited invite link as a ChatInviteLink object.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param inviteLink The invite link to edit
 * @param name Invite link name; 0-32 characters
 * @see <a href="https://core.telegram.org/bots/api#editchatsubscriptioninvitelink">editChatSubscriptionInviteLink in the Bot API</a>
 */
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
