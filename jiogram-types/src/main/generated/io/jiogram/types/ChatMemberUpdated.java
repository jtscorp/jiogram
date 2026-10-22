package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.ChatMember;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * This object represents changes in the status of a chat member.
 *
 * @param chat Chat the user belongs to
 * @param from Performer of the action, which resulted in the change
 * @param date Date the change was done in Unix time
 * @param oldChatMember Previous information about the chat member
 * @param newChatMember New information about the chat member
 * @param inviteLink Chat invite link, which was used by the user to join the chat; for joining by
 *     invite link events only.
 * @param viaJoinRequest True, if the user joined the chat after sending a direct join request
 *     without using an invite link and being approved by an administrator
 * @param viaChatFolderInviteLink True, if the user joined the chat via a chat folder invite link
 * @see <a href="https://core.telegram.org/bots/api#chatmemberupdated">ChatMemberUpdated in the Bot API</a>
 */
public record ChatMemberUpdated(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("from") User from,
    @JsonProperty("date") long date,
    @JsonProperty("old_chat_member") ChatMember oldChatMember,
    @JsonProperty("new_chat_member") ChatMember newChatMember,
    @JsonProperty("invite_link") @Nullable ChatInviteLink inviteLink,
    @JsonProperty("via_join_request") @Nullable Boolean viaJoinRequest,
    @JsonProperty("via_chat_folder_invite_link") @Nullable Boolean viaChatFolderInviteLink
) {

    public ChatMemberUpdated withChat(Chat chat) {
        return new ChatMemberUpdated(chat, from, date, oldChatMember, newChatMember, inviteLink, viaJoinRequest, viaChatFolderInviteLink);
    }

    public ChatMemberUpdated withFrom(User from) {
        return new ChatMemberUpdated(chat, from, date, oldChatMember, newChatMember, inviteLink, viaJoinRequest, viaChatFolderInviteLink);
    }

    public ChatMemberUpdated withDate(long date) {
        return new ChatMemberUpdated(chat, from, date, oldChatMember, newChatMember, inviteLink, viaJoinRequest, viaChatFolderInviteLink);
    }

    public ChatMemberUpdated withOldChatMember(ChatMember oldChatMember) {
        return new ChatMemberUpdated(chat, from, date, oldChatMember, newChatMember, inviteLink, viaJoinRequest, viaChatFolderInviteLink);
    }

    public ChatMemberUpdated withNewChatMember(ChatMember newChatMember) {
        return new ChatMemberUpdated(chat, from, date, oldChatMember, newChatMember, inviteLink, viaJoinRequest, viaChatFolderInviteLink);
    }

    public ChatMemberUpdated withInviteLink(@Nullable ChatInviteLink inviteLink) {
        return new ChatMemberUpdated(chat, from, date, oldChatMember, newChatMember, inviteLink, viaJoinRequest, viaChatFolderInviteLink);
    }

    public ChatMemberUpdated withViaJoinRequest(@Nullable Boolean viaJoinRequest) {
        return new ChatMemberUpdated(chat, from, date, oldChatMember, newChatMember, inviteLink, viaJoinRequest, viaChatFolderInviteLink);
    }

    public ChatMemberUpdated withViaChatFolderInviteLink(@Nullable Boolean viaChatFolderInviteLink) {
        return new ChatMemberUpdated(chat, from, date, oldChatMember, newChatMember, inviteLink, viaJoinRequest, viaChatFolderInviteLink);
    }
}
