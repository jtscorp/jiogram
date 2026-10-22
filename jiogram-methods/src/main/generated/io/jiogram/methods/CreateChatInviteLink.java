package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to create an additional invite link for a chat. The bot must be an administrator
 * in the chat for this to work and must have the appropriate administrator rights. The link can be
 * revoked using the method revokeChatInviteLink. Returns the new invite link as ChatInviteLink
 * object.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param name Invite link name; 0-32 characters
 * @param expireDate Point in time (Unix timestamp) when the link will expire
 * @param memberLimit The maximum number of users that can be members of the chat simultaneously
 *     after joining the chat via this invite link; 1-99999
 * @param createsJoinRequest True, if users joining the chat via the link need to be approved by
 *     chat administrators. If True, member_limit can't be specified
 * @see <a href="https://core.telegram.org/bots/api#createchatinvitelink">createChatInviteLink in the Bot API</a>
 */
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

    public CreateChatInviteLink withChatId(ChatId chatId) {
        return new CreateChatInviteLink(chatId, name, expireDate, memberLimit, createsJoinRequest);
    }

    public CreateChatInviteLink withName(@Nullable String name) {
        return new CreateChatInviteLink(chatId, name, expireDate, memberLimit, createsJoinRequest);
    }

    public CreateChatInviteLink withExpireDate(@Nullable Long expireDate) {
        return new CreateChatInviteLink(chatId, name, expireDate, memberLimit, createsJoinRequest);
    }

    public CreateChatInviteLink withMemberLimit(@Nullable Long memberLimit) {
        return new CreateChatInviteLink(chatId, name, expireDate, memberLimit, createsJoinRequest);
    }

    public CreateChatInviteLink withCreatesJoinRequest(@Nullable Boolean createsJoinRequest) {
        return new CreateChatInviteLink(chatId, name, expireDate, memberLimit, createsJoinRequest);
    }
}
