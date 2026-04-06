package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record ChatJoinRequest(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("from") User from,
    @JsonProperty("user_chat_id") long userChatId,
    @JsonProperty("date") long date,
    @JsonProperty("bio") @Nullable String bio,
    @JsonProperty("invite_link") @Nullable ChatInviteLink inviteLink
) {}
