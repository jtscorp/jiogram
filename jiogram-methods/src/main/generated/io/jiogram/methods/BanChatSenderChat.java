package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to ban a channel chat in a supergroup or a channel. Until the chat is unbanned,
 * the owner of the banned chat won't be able to send messages on behalf of any of their channels.
 * The bot must be an administrator in the supergroup or channel for this to work and must have the
 * appropriate administrator rights. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#banchatsenderchat">banChatSenderChat in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BanChatSenderChat implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("sender_chat_id")
    private final long senderChatId;

    /**
     * Creates a new {@code BanChatSenderChat} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param senderChatId Unique identifier of the target sender chat
     */
    @JsonCreator
    public BanChatSenderChat(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("sender_chat_id") long senderChatId) {
        this.chatId = chatId;
        this.senderChatId = senderChatId;
    }

    @Override
    public String apiMethod() {
        return "banChatSenderChat";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Unique identifier of the target sender chat
     */
    public long senderChatId() {
        return senderChatId;
    }

    public BanChatSenderChat withChatId(ChatId chatId) {
        return new BanChatSenderChat(chatId, senderChatId);
    }

    public BanChatSenderChat withSenderChatId(long senderChatId) {
        return new BanChatSenderChat(chatId, senderChatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BanChatSenderChat)) {
            return false;
        }
        BanChatSenderChat that = (BanChatSenderChat) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.senderChatId == that.senderChatId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.senderChatId);
    }

    @Override
    public String toString() {
        return "BanChatSenderChat[chatId=" + this.chatId
                + ", senderChatId=" + this.senderChatId
                + "]";
    }
}
