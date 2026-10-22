package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit a non-primary invite link created by the bot. The bot must be an
 * administrator in the chat for this to work and must have the appropriate administrator rights.
 * Returns the edited invite link as a ChatInviteLink object.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param inviteLink The invite link to edit
 * @param name Invite link name; 0-32 characters
 * @param expireDate Point in time (Unix timestamp) when the link will expire
 * @param memberLimit The maximum number of users that can be members of the chat simultaneously
 *     after joining the chat via this invite link; 1-99999
 * @param createsJoinRequest True, if users joining the chat via the link need to be approved by
 *     chat administrators. If True, member_limit can't be specified
 * @see <a href="https://core.telegram.org/bots/api#editchatinvitelink">editChatInviteLink in the Bot API</a>
 */
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

    public EditChatInviteLink withChatId(ChatId chatId) {
        return new EditChatInviteLink(chatId, inviteLink, name, expireDate, memberLimit, createsJoinRequest);
    }

    public EditChatInviteLink withInviteLink(String inviteLink) {
        return new EditChatInviteLink(chatId, inviteLink, name, expireDate, memberLimit, createsJoinRequest);
    }

    public EditChatInviteLink withName(@Nullable String name) {
        return new EditChatInviteLink(chatId, inviteLink, name, expireDate, memberLimit, createsJoinRequest);
    }

    public EditChatInviteLink withExpireDate(@Nullable Long expireDate) {
        return new EditChatInviteLink(chatId, inviteLink, name, expireDate, memberLimit, createsJoinRequest);
    }

    public EditChatInviteLink withMemberLimit(@Nullable Long memberLimit) {
        return new EditChatInviteLink(chatId, inviteLink, name, expireDate, memberLimit, createsJoinRequest);
    }

    public EditChatInviteLink withCreatesJoinRequest(@Nullable Boolean createsJoinRequest) {
        return new EditChatInviteLink(chatId, inviteLink, name, expireDate, memberLimit, createsJoinRequest);
    }
}
