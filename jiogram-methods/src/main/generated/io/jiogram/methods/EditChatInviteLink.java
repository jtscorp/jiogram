package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit a non-primary invite link created by the bot. The bot must be an
 * administrator in the chat for this to work and must have the appropriate administrator rights.
 * Returns the edited invite link as a ChatInviteLink object.
 *
 * @see <a href="https://core.telegram.org/bots/api#editchatinvitelink">editChatInviteLink in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EditChatInviteLink implements TelegramMethod<ChatInviteLink> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("invite_link")
    private final String inviteLink;

    @JsonProperty("name")
    private final @Nullable String name;

    @JsonProperty("expire_date")
    private final @Nullable Long expireDate;

    @JsonProperty("member_limit")
    private final @Nullable Long memberLimit;

    @JsonProperty("creates_join_request")
    private final @Nullable Boolean createsJoinRequest;

    /**
     * Creates a new {@code EditChatInviteLink} instance.
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
     */
    @JsonCreator
    public EditChatInviteLink(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("invite_link") String inviteLink,
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("expire_date") @Nullable Long expireDate,
            @JsonProperty("member_limit") @Nullable Long memberLimit,
            @JsonProperty("creates_join_request") @Nullable Boolean createsJoinRequest) {
        this.chatId = chatId;
        this.inviteLink = inviteLink;
        this.name = name;
        this.expireDate = expireDate;
        this.memberLimit = memberLimit;
        this.createsJoinRequest = createsJoinRequest;
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

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * The invite link to edit
     */
    public String inviteLink() {
        return inviteLink;
    }

    /**
     * Invite link name; 0-32 characters
     */
    public @Nullable String name() {
        return name;
    }

    /**
     * Point in time (Unix timestamp) when the link will expire
     */
    public @Nullable Long expireDate() {
        return expireDate;
    }

    /**
     * The maximum number of users that can be members of the chat simultaneously after joining the
     * chat via this invite link; 1-99999
     */
    public @Nullable Long memberLimit() {
        return memberLimit;
    }

    /**
     * True, if users joining the chat via the link need to be approved by chat administrators. If
     * True, member_limit can't be specified
     */
    public @Nullable Boolean createsJoinRequest() {
        return createsJoinRequest;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EditChatInviteLink)) {
            return false;
        }
        EditChatInviteLink that = (EditChatInviteLink) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.inviteLink, that.inviteLink)
                && Objects.equals(this.name, that.name)
                && Objects.equals(this.expireDate, that.expireDate)
                && Objects.equals(this.memberLimit, that.memberLimit)
                && Objects.equals(this.createsJoinRequest, that.createsJoinRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.inviteLink, this.name, this.expireDate, this.memberLimit, this.createsJoinRequest);
    }

    @Override
    public String toString() {
        return "EditChatInviteLink[chatId=" + this.chatId
                + ", inviteLink=" + this.inviteLink
                + ", name=" + this.name
                + ", expireDate=" + this.expireDate
                + ", memberLimit=" + this.memberLimit
                + ", createsJoinRequest=" + this.createsJoinRequest
                + "]";
    }
}
