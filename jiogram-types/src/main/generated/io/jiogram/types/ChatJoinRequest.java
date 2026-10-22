package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Represents a join request sent to a chat.
 *
 * @param chat Chat to which the request was sent
 * @param from User that sent the join request
 * @param userChatId Identifier of a private chat with the user who sent the join request. This
 *     number may have more than 32 significant bits and some programming languages may have
 *     difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a
 *     64-bit integer or double-precision float type are safe for storing this identifier. The bot
 *     can use this identifier for 5 minutes to send messages until the join request is processed,
 *     assuming no other administrator contacted the user.
 * @param date Date the request was sent in Unix time
 * @param bio Bio of the user.
 * @param inviteLink Chat invite link that was used by the user to send the join request
 * @see <a href="https://core.telegram.org/bots/api#chatjoinrequest">ChatJoinRequest in the Bot API</a>
 */
public record ChatJoinRequest(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("from") User from,
    @JsonProperty("user_chat_id") long userChatId,
    @JsonProperty("date") long date,
    @JsonProperty("bio") @Nullable String bio,
    @JsonProperty("invite_link") @Nullable ChatInviteLink inviteLink
) {}
