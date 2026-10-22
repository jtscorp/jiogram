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
 * Use this method to unban a previously banned user in a supergroup or channel. The user will not
 * return to the group or channel automatically, but will be able to join via link, etc. The bot
 * must be an administrator for this to work. By default, this method guarantees that after the call
 * the user is not a member of the chat, but will be able to join it. So if the user is a member of
 * the chat they will also be removed from the chat. If you don't want this, use the parameter
 * only_if_banned. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#unbanchatmember">unbanChatMember in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UnbanChatMember implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("only_if_banned")
    private final @Nullable Boolean onlyIfBanned;

    /**
     * Creates a new {@code UnbanChatMember} instance.
     *
     * @param chatId Unique identifier for the target group or username of the target supergroup or
     *     channel (in the format &#64;channelusername)
     * @param userId Unique identifier of the target user
     * @param onlyIfBanned Do nothing if the user is not banned
     */
    @JsonCreator
    public UnbanChatMember(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId,
            @JsonProperty("only_if_banned") @Nullable Boolean onlyIfBanned) {
        this.chatId = chatId;
        this.userId = userId;
        this.onlyIfBanned = onlyIfBanned;
    }

    @Override
    public String apiMethod() {
        return "unbanChatMember";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static UnbanChatMember of(ChatId chatId, long userId) {
        return new UnbanChatMember(chatId, userId, null);
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
     * Do nothing if the user is not banned
     */
    public @Nullable Boolean onlyIfBanned() {
        return onlyIfBanned;
    }

    public UnbanChatMember withChatId(ChatId chatId) {
        return new UnbanChatMember(chatId, userId, onlyIfBanned);
    }

    public UnbanChatMember withUserId(long userId) {
        return new UnbanChatMember(chatId, userId, onlyIfBanned);
    }

    public UnbanChatMember withOnlyIfBanned(@Nullable Boolean onlyIfBanned) {
        return new UnbanChatMember(chatId, userId, onlyIfBanned);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UnbanChatMember)) {
            return false;
        }
        UnbanChatMember that = (UnbanChatMember) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.userId == that.userId
                && Objects.equals(this.onlyIfBanned, that.onlyIfBanned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.userId, this.onlyIfBanned);
    }

    @Override
    public String toString() {
        return "UnbanChatMember[chatId=" + this.chatId
                + ", userId=" + this.userId
                + ", onlyIfBanned=" + this.onlyIfBanned
                + "]";
    }
}
