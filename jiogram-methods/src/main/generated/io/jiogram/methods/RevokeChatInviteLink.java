package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to revoke an invite link created by the bot. If the primary link is revoked, a
 * new link is automatically generated. The bot must be an administrator in the chat for this to
 * work and must have the appropriate administrator rights. Returns the revoked invite link as
 * ChatInviteLink object.
 *
 * @param chatId Unique identifier of the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param inviteLink The invite link to revoke
 * @see <a href="https://core.telegram.org/bots/api#revokechatinvitelink">revokeChatInviteLink in the Bot API</a>
 */
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

    public RevokeChatInviteLink withChatId(ChatId chatId) {
        return new RevokeChatInviteLink(chatId, inviteLink);
    }

    public RevokeChatInviteLink withInviteLink(String inviteLink) {
        return new RevokeChatInviteLink(chatId, inviteLink);
    }
}
