package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundType;

/**
 * This object represents a chat background.
 *
 * @param type Type of the background
 * @see <a href="https://core.telegram.org/bots/api#chatbackground">ChatBackground in the Bot API</a>
 */
public record ChatBackground(
    @JsonProperty("type") BackgroundType type
) {

    public ChatBackground withType(BackgroundType type) {
        return new ChatBackground(type);
    }
}
