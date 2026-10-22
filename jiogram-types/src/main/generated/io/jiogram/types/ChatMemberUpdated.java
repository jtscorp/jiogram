package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.ChatMember;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents changes in the status of a chat member.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmemberupdated">ChatMemberUpdated in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatMemberUpdated {

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("from")
    private final User from;

    @JsonProperty("date")
    private final long date;

    @JsonProperty("old_chat_member")
    private final ChatMember oldChatMember;

    @JsonProperty("new_chat_member")
    private final ChatMember newChatMember;

    @JsonProperty("invite_link")
    private final @Nullable ChatInviteLink inviteLink;

    @JsonProperty("via_join_request")
    private final @Nullable Boolean viaJoinRequest;

    @JsonProperty("via_chat_folder_invite_link")
    private final @Nullable Boolean viaChatFolderInviteLink;

    /**
     * Creates a new {@code ChatMemberUpdated} instance.
     *
     * @param chat Chat the user belongs to
     * @param from Performer of the action, which resulted in the change
     * @param date Date the change was done in Unix time
     * @param oldChatMember Previous information about the chat member
     * @param newChatMember New information about the chat member
     * @param inviteLink Chat invite link, which was used by the user to join the chat; for joining
     *     by invite link events only.
     * @param viaJoinRequest True, if the user joined the chat after sending a direct join request
     *     without using an invite link and being approved by an administrator
     * @param viaChatFolderInviteLink True, if the user joined the chat via a chat folder invite
     *     link
     */
    @JsonCreator
    public ChatMemberUpdated(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("from") User from,
            @JsonProperty("date") long date,
            @JsonProperty("old_chat_member") ChatMember oldChatMember,
            @JsonProperty("new_chat_member") ChatMember newChatMember,
            @JsonProperty("invite_link") @Nullable ChatInviteLink inviteLink,
            @JsonProperty("via_join_request") @Nullable Boolean viaJoinRequest,
            @JsonProperty("via_chat_folder_invite_link") @Nullable Boolean viaChatFolderInviteLink) {
        this.chat = chat;
        this.from = from;
        this.date = date;
        this.oldChatMember = oldChatMember;
        this.newChatMember = newChatMember;
        this.inviteLink = inviteLink;
        this.viaJoinRequest = viaJoinRequest;
        this.viaChatFolderInviteLink = viaChatFolderInviteLink;
    }

    public static ChatMemberUpdated of(Chat chat, User from, long date, ChatMember oldChatMember, ChatMember newChatMember) {
        return new ChatMemberUpdated(chat, from, date, oldChatMember, newChatMember, null, null, null);
    }

    /**
     * Chat the user belongs to
     */
    public Chat chat() {
        return chat;
    }

    /**
     * Performer of the action, which resulted in the change
     */
    public User from() {
        return from;
    }

    /**
     * Date the change was done in Unix time
     */
    public long date() {
        return date;
    }

    /**
     * Previous information about the chat member
     */
    public ChatMember oldChatMember() {
        return oldChatMember;
    }

    /**
     * New information about the chat member
     */
    public ChatMember newChatMember() {
        return newChatMember;
    }

    /**
     * Chat invite link, which was used by the user to join the chat; for joining by invite link
     * events only.
     */
    public @Nullable ChatInviteLink inviteLink() {
        return inviteLink;
    }

    /**
     * True, if the user joined the chat after sending a direct join request without using an invite
     * link and being approved by an administrator
     */
    public @Nullable Boolean viaJoinRequest() {
        return viaJoinRequest;
    }

    /**
     * True, if the user joined the chat via a chat folder invite link
     */
    public @Nullable Boolean viaChatFolderInviteLink() {
        return viaChatFolderInviteLink;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatMemberUpdated)) {
            return false;
        }
        ChatMemberUpdated that = (ChatMemberUpdated) o;
        return Objects.equals(this.chat, that.chat)
                && Objects.equals(this.from, that.from)
                && this.date == that.date
                && Objects.equals(this.oldChatMember, that.oldChatMember)
                && Objects.equals(this.newChatMember, that.newChatMember)
                && Objects.equals(this.inviteLink, that.inviteLink)
                && Objects.equals(this.viaJoinRequest, that.viaJoinRequest)
                && Objects.equals(this.viaChatFolderInviteLink, that.viaChatFolderInviteLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chat, this.from, this.date, this.oldChatMember, this.newChatMember, this.inviteLink, this.viaJoinRequest, this.viaChatFolderInviteLink);
    }

    @Override
    public String toString() {
        return "ChatMemberUpdated[chat=" + this.chat
                + ", from=" + this.from
                + ", date=" + this.date
                + ", oldChatMember=" + this.oldChatMember
                + ", newChatMember=" + this.newChatMember
                + ", inviteLink=" + this.inviteLink
                + ", viaJoinRequest=" + this.viaJoinRequest
                + ", viaChatFolderInviteLink=" + this.viaChatFolderInviteLink
                + "]";
    }
}
