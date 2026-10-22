package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents the bot's description.
 *
 * @param description The bot's description
 * @see <a href="https://core.telegram.org/bots/api#botdescription">BotDescription in the Bot API</a>
 */
public record BotDescription(
    @JsonProperty("description") String description
) {

    public BotDescription withDescription(String description) {
        return new BotDescription(description);
    }
}
