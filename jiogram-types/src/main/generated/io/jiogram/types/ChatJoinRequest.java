package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a join request sent to a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatjoinrequest">ChatJoinRequest in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatJoinRequest {

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("from")
    private final User from;

    @JsonProperty("user_chat_id")
    private final long userChatId;

    @JsonProperty("date")
    private final long date;

    @JsonProperty("bio")
    private final @Nullable String bio;

    @JsonProperty("invite_link")
    private final @Nullable ChatInviteLink inviteLink;

    /**
     * Creates a new {@code ChatJoinRequest} instance.
     *
     * @param chat Chat to which the request was sent
     * @param from User that sent the join request
     * @param userChatId Identifier of a private chat with the user who sent the join request. This
     *     number may have more than 32 significant bits and some programming languages may have
     *     difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so
     *     a 64-bit integer or double-precision float type are safe for storing this identifier. The
     *     bot can use this identifier for 5 minutes to send messages until the join request is
     *     processed, assuming no other administrator contacted the user.
     * @param date Date the request was sent in Unix time
     * @param bio Bio of the user.
     * @param inviteLink Chat invite link that was used by the user to send the join request
     */
    @JsonCreator
    public ChatJoinRequest(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("from") User from,
            @JsonProperty("user_chat_id") long userChatId,
            @JsonProperty("date") long date,
            @JsonProperty("bio") @Nullable String bio,
            @JsonProperty("invite_link") @Nullable ChatInviteLink inviteLink) {
        this.chat = chat;
        this.from = from;
        this.userChatId = userChatId;
        this.date = date;
        this.bio = bio;
        this.inviteLink = inviteLink;
    }

    public static ChatJoinRequest of(Chat chat, User from, long userChatId, long date) {
        return new ChatJoinRequest(chat, from, userChatId, date, null, null);
    }

    /**
     * Chat to which the request was sent
     */
    public Chat chat() {
        return chat;
    }

    /**
     * User that sent the join request
     */
    public User from() {
        return from;
    }

    /**
     * Identifier of a private chat with the user who sent the join request. This number may have
     * more than 32 significant bits and some programming languages may have difficulty/silent
     * defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or
     * double-precision float type are safe for storing this identifier. The bot can use this
     * identifier for 5 minutes to send messages until the join request is processed, assuming no
     * other administrator contacted the user.
     */
    public long userChatId() {
        return userChatId;
    }

    /**
     * Date the request was sent in Unix time
     */
    public long date() {
        return date;
    }

    /**
     * Bio of the user.
     */
    public @Nullable String bio() {
        return bio;
    }

    /**
     * Chat invite link that was used by the user to send the join request
     */
    public @Nullable ChatInviteLink inviteLink() {
        return inviteLink;
    }

    public ChatJoinRequest withChat(Chat chat) {
        return new ChatJoinRequest(chat, from, userChatId, date, bio, inviteLink);
    }

    public ChatJoinRequest withFrom(User from) {
        return new ChatJoinRequest(chat, from, userChatId, date, bio, inviteLink);
    }

    public ChatJoinRequest withUserChatId(long userChatId) {
        return new ChatJoinRequest(chat, from, userChatId, date, bio, inviteLink);
    }

    public ChatJoinRequest withDate(long date) {
        return new ChatJoinRequest(chat, from, userChatId, date, bio, inviteLink);
    }

    public ChatJoinRequest withBio(@Nullable String bio) {
        return new ChatJoinRequest(chat, from, userChatId, date, bio, inviteLink);
    }

    public ChatJoinRequest withInviteLink(@Nullable ChatInviteLink inviteLink) {
        return new ChatJoinRequest(chat, from, userChatId, date, bio, inviteLink);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatJoinRequest)) {
            return false;
        }
        ChatJoinRequest that = (ChatJoinRequest) o;
        return Objects.equals(this.chat, that.chat)
                && Objects.equals(this.from, that.from)
                && this.userChatId == that.userChatId
                && this.date == that.date
                && Objects.equals(this.bio, that.bio)
                && Objects.equals(this.inviteLink, that.inviteLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chat, this.from, this.userChatId, this.date, this.bio, this.inviteLink);
    }

    @Override
    public String toString() {
        return "ChatJoinRequest[chat=" + this.chat
                + ", from=" + this.from
                + ", userChatId=" + this.userChatId
                + ", date=" + this.date
                + ", bio=" + this.bio
                + ", inviteLink=" + this.inviteLink
                + "]";
    }
}
