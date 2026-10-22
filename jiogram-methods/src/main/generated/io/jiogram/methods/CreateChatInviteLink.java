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
 * Use this method to create an additional invite link for a chat. The bot must be an administrator
 * in the chat for this to work and must have the appropriate administrator rights. The link can be
 * revoked using the method revokeChatInviteLink. Returns the new invite link as ChatInviteLink
 * object.
 *
 * @see <a href="https://core.telegram.org/bots/api#createchatinvitelink">createChatInviteLink in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class CreateChatInviteLink implements TelegramMethod<ChatInviteLink> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("name")
    private final @Nullable String name;

    @JsonProperty("expire_date")
    private final @Nullable Long expireDate;

    @JsonProperty("member_limit")
    private final @Nullable Long memberLimit;

    @JsonProperty("creates_join_request")
    private final @Nullable Boolean createsJoinRequest;

    /**
     * Creates a new {@code CreateChatInviteLink} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param name Invite link name; 0-32 characters
     * @param expireDate Point in time (Unix timestamp) when the link will expire
     * @param memberLimit The maximum number of users that can be members of the chat simultaneously
     *     after joining the chat via this invite link; 1-99999
     * @param createsJoinRequest True, if users joining the chat via the link need to be approved by
     *     chat administrators. If True, member_limit can't be specified
     */
    @JsonCreator
    public CreateChatInviteLink(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("expire_date") @Nullable Long expireDate,
            @JsonProperty("member_limit") @Nullable Long memberLimit,
            @JsonProperty("creates_join_request") @Nullable Boolean createsJoinRequest) {
        this.chatId = chatId;
        this.name = name;
        this.expireDate = expireDate;
        this.memberLimit = memberLimit;
        this.createsJoinRequest = createsJoinRequest;
    }

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

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CreateChatInviteLink)) {
            return false;
        }
        CreateChatInviteLink that = (CreateChatInviteLink) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.name, that.name)
                && Objects.equals(this.expireDate, that.expireDate)
                && Objects.equals(this.memberLimit, that.memberLimit)
                && Objects.equals(this.createsJoinRequest, that.createsJoinRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.name, this.expireDate, this.memberLimit, this.createsJoinRequest);
    }

    @Override
    public String toString() {
        return "CreateChatInviteLink[chatId=" + this.chatId
                + ", name=" + this.name
                + ", expireDate=" + this.expireDate
                + ", memberLimit=" + this.memberLimit
                + ", createsJoinRequest=" + this.createsJoinRequest
                + "]";
    }
}
