package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.ChatMember;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record ChatMemberUpdated(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("from") User from,
    @JsonProperty("date") long date,
    @JsonProperty("old_chat_member") ChatMember oldChatMember,
    @JsonProperty("new_chat_member") ChatMember newChatMember,
    @JsonProperty("invite_link") @Nullable ChatInviteLink inviteLink,
    @JsonProperty("via_join_request") @Nullable Boolean viaJoinRequest,
    @JsonProperty("via_chat_folder_invite_link") @Nullable Boolean viaChatFolderInviteLink
) {}
