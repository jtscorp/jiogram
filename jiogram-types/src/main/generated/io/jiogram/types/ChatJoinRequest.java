package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class ChatJoinRequest {
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("from") private final User from;
    @JsonProperty("user_chat_id") private final long userChatId;
    @JsonProperty("date") private final long date;
    @JsonProperty("bio") @Nullable private final String bio;
    @JsonProperty("invite_link") @Nullable private final ChatInviteLink inviteLink;

    @JsonCreator
    public ChatJoinRequest(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("from") User from,
            @JsonProperty("user_chat_id") long userChatId,
            @JsonProperty("date") long date,
            @JsonProperty("bio") @Nullable String bio,
            @JsonProperty("invite_link") @Nullable ChatInviteLink inviteLink
    ) {
        this.chat = chat;
        this.from = from;
        this.userChatId = userChatId;
        this.date = date;
        this.bio = bio;
        this.inviteLink = inviteLink;
    }

    public Chat chat() {
        return this.chat;
    }

    public User from() {
        return this.from;
    }

    public long userChatId() {
        return this.userChatId;
    }

    public long date() {
        return this.date;
    }

    public String bio() {
        return this.bio;
    }

    public ChatInviteLink inviteLink() {
        return this.inviteLink;
    }
}
