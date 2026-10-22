package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatBoost;
import java.util.Objects;

/**
 * This object represents a boost added to a chat or changed.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatboostupdated">ChatBoostUpdated in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatBoostUpdated {

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("boost")
    private final ChatBoost boost;

    /**
     * Creates a new {@code ChatBoostUpdated} instance.
     *
     * @param chat Chat which was boosted
     * @param boost Information about the chat boost
     */
    @JsonCreator
    public ChatBoostUpdated(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("boost") ChatBoost boost) {
        this.chat = chat;
        this.boost = boost;
    }

    /**
     * Chat which was boosted
     */
    public Chat chat() {
        return chat;
    }

    /**
     * Information about the chat boost
     */
    public ChatBoost boost() {
        return boost;
    }

    public ChatBoostUpdated withChat(Chat chat) {
        return new ChatBoostUpdated(chat, boost);
    }

    public ChatBoostUpdated withBoost(ChatBoost boost) {
        return new ChatBoostUpdated(chat, boost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatBoostUpdated)) {
            return false;
        }
        ChatBoostUpdated that = (ChatBoostUpdated) o;
        return Objects.equals(this.chat, that.chat)
                && Objects.equals(this.boost, that.boost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chat, this.boost);
    }

    @Override
    public String toString() {
        return "ChatBoostUpdated[chat=" + this.chat
                + ", boost=" + this.boost
                + "]";
    }
}
