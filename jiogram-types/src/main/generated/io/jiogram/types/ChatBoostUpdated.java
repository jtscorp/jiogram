package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatBoost;

/**
 * This object represents a boost added to a chat or changed.
 *
 * @param chat Chat which was boosted
 * @param boost Information about the chat boost
 * @see <a href="https://core.telegram.org/bots/api#chatboostupdated">ChatBoostUpdated in the Bot API</a>
 */
public record ChatBoostUpdated(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("boost") ChatBoost boost
) {

    public ChatBoostUpdated withChat(Chat chat) {
        return new ChatBoostUpdated(chat, boost);
    }

    public ChatBoostUpdated withBoost(ChatBoost boost) {
        return new ChatBoostUpdated(chat, boost);
    }
}
