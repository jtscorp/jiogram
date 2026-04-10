package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class EditChatInviteLink implements TelegramMethod<ChatInviteLink> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("invite_link") private final String inviteLink;
    @JsonProperty("name") @Nullable private final String name;
    @JsonProperty("expire_date") @Nullable private final Long expireDate;
    @JsonProperty("member_limit") @Nullable private final Long memberLimit;
    @JsonProperty("creates_join_request") @Nullable private final Boolean createsJoinRequest;

    @JsonCreator
    public EditChatInviteLink(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("invite_link") String inviteLink,
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("expire_date") @Nullable Long expireDate,
            @JsonProperty("member_limit") @Nullable Long memberLimit,
            @JsonProperty("creates_join_request") @Nullable Boolean createsJoinRequest
    ) {
        this.chatId = chatId;
        this.inviteLink = inviteLink;
        this.name = name;
        this.expireDate = expireDate;
        this.memberLimit = memberLimit;
        this.createsJoinRequest = createsJoinRequest;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public String inviteLink() {
        return this.inviteLink;
    }

    public String name() {
        return this.name;
    }

    public Long expireDate() {
        return this.expireDate;
    }

    public Long memberLimit() {
        return this.memberLimit;
    }

    public Boolean createsJoinRequest() {
        return this.createsJoinRequest;
    }

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
}
