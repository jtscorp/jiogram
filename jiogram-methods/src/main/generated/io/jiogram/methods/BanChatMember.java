package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to ban a user in a group, a supergroup or a channel. In the case of supergroups
 * and channels, the user will not be able to return to the chat on their own using invite links,
 * etc., unless unbanned first. The bot must be an administrator in the chat for this to work and
 * must have the appropriate administrator rights. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#banchatmember">banChatMember in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BanChatMember implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("until_date")
    private final @Nullable Long untilDate;

    @JsonProperty("revoke_messages")
    private final @Nullable Boolean revokeMessages;

    /**
     * Creates a new {@code BanChatMember} instance.
     *
     * @param chatId Unique identifier for the target group or username of the target supergroup or
     *     channel (in the format &#64;channelusername)
     * @param userId Unique identifier of the target user
     * @param untilDate Date when the user will be unbanned; Unix time. If user is banned for more
     *     than 366 days or less than 30 seconds from the current time they are considered to be
     *     banned forever. Applied for supergroups and channels only.
     * @param revokeMessages Pass True to delete all messages from the chat for the user that is
     *     being removed. If False, the user will be able to see messages in the group that were
     *     sent before the user was removed. Always True for supergroups and channels.
     */
    @JsonCreator
    public BanChatMember(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId,
            @JsonProperty("until_date") @Nullable Long untilDate,
            @JsonProperty("revoke_messages") @Nullable Boolean revokeMessages) {
        this.chatId = chatId;
        this.userId = userId;
        this.untilDate = untilDate;
        this.revokeMessages = revokeMessages;
    }

    @Override
    public String apiMethod() {
        return "banChatMember";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static BanChatMember of(ChatId chatId, long userId) {
        return new BanChatMember(chatId, userId, null, null);
    }

    /**
     * Unique identifier for the target group or username of the target supergroup or channel (in
     * the format &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Unique identifier of the target user
     */
    public long userId() {
        return userId;
    }

    /**
     * Date when the user will be unbanned; Unix time. If user is banned for more than 366 days or
     * less than 30 seconds from the current time they are considered to be banned forever. Applied
     * for supergroups and channels only.
     */
    public @Nullable Long untilDate() {
        return untilDate;
    }

    /**
     * Pass True to delete all messages from the chat for the user that is being removed. If False,
     * the user will be able to see messages in the group that were sent before the user was
     * removed. Always True for supergroups and channels.
     */
    public @Nullable Boolean revokeMessages() {
        return revokeMessages;
    }

    public BanChatMember withChatId(ChatId chatId) {
        return new BanChatMember(chatId, userId, untilDate, revokeMessages);
    }

    public BanChatMember withUserId(long userId) {
        return new BanChatMember(chatId, userId, untilDate, revokeMessages);
    }

    public BanChatMember withUntilDate(@Nullable Long untilDate) {
        return new BanChatMember(chatId, userId, untilDate, revokeMessages);
    }

    public BanChatMember withRevokeMessages(@Nullable Boolean revokeMessages) {
        return new BanChatMember(chatId, userId, untilDate, revokeMessages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BanChatMember)) {
            return false;
        }
        BanChatMember that = (BanChatMember) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.userId == that.userId
                && Objects.equals(this.untilDate, that.untilDate)
                && Objects.equals(this.revokeMessages, that.revokeMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.userId, this.untilDate, this.revokeMessages);
    }

    @Override
    public String toString() {
        return "BanChatMember[chatId=" + this.chatId
                + ", userId=" + this.userId
                + ", untilDate=" + this.untilDate
                + ", revokeMessages=" + this.revokeMessages
                + "]";
    }
}
