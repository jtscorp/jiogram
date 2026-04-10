package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.ChatMember;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class ChatMemberUpdated {
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("from") private final User from;
    @JsonProperty("date") private final long date;
    @JsonProperty("old_chat_member") private final ChatMember oldChatMember;
    @JsonProperty("new_chat_member") private final ChatMember newChatMember;
    @JsonProperty("invite_link") @Nullable private final ChatInviteLink inviteLink;
    @JsonProperty("via_join_request") @Nullable private final Boolean viaJoinRequest;
    @JsonProperty("via_chat_folder_invite_link") @Nullable private final Boolean viaChatFolderInviteLink;

    @JsonCreator
    public ChatMemberUpdated(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("from") User from,
            @JsonProperty("date") long date,
            @JsonProperty("old_chat_member") ChatMember oldChatMember,
            @JsonProperty("new_chat_member") ChatMember newChatMember,
            @JsonProperty("invite_link") @Nullable ChatInviteLink inviteLink,
            @JsonProperty("via_join_request") @Nullable Boolean viaJoinRequest,
            @JsonProperty("via_chat_folder_invite_link") @Nullable Boolean viaChatFolderInviteLink
    ) {
        this.chat = chat;
        this.from = from;
        this.date = date;
        this.oldChatMember = oldChatMember;
        this.newChatMember = newChatMember;
        this.inviteLink = inviteLink;
        this.viaJoinRequest = viaJoinRequest;
        this.viaChatFolderInviteLink = viaChatFolderInviteLink;
    }

    public Chat chat() {
        return this.chat;
    }

    public User from() {
        return this.from;
    }

    public long date() {
        return this.date;
    }

    public ChatMember oldChatMember() {
        return this.oldChatMember;
    }

    public ChatMember newChatMember() {
        return this.newChatMember;
    }

    public ChatInviteLink inviteLink() {
        return this.inviteLink;
    }

    public Boolean viaJoinRequest() {
        return this.viaJoinRequest;
    }

    public Boolean viaChatFolderInviteLink() {
        return this.viaChatFolderInviteLink;
    }
}
