package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method for your bot to leave a group, supergroup or channel. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#leavechat">leaveChat in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class LeaveChat implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    /**
     * Creates a new {@code LeaveChat} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup or
     *     channel (in the format &#64;channelusername). Channel direct messages chats aren't
     *     supported; leave the corresponding channel instead.
     */
    @JsonCreator
    public LeaveChat(
            @JsonProperty("chat_id") ChatId chatId) {
        this.chatId = chatId;
    }

    @Override
    public String apiMethod() {
        return "leaveChat";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Unique identifier for the target chat or username of the target supergroup or channel (in the
     * format &#64;channelusername). Channel direct messages chats aren't supported; leave the
     * corresponding channel instead.
     */
    public ChatId chatId() {
        return chatId;
    }

    public LeaveChat withChatId(ChatId chatId) {
        return new LeaveChat(chatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LeaveChat)) {
            return false;
        }
        LeaveChat that = (LeaveChat) o;
        return Objects.equals(this.chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId);
    }

    @Override
    public String toString() {
        return "LeaveChat[chatId=" + this.chatId
                + "]";
    }
}
