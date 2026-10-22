package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents the bot's name.
 *
 * @param name The bot's name
 * @see <a href="https://core.telegram.org/bots/api#botname">BotName in the Bot API</a>
 */
public record BotName(
    @JsonProperty("name") String name
) {

    public BotName withName(String name) {
        return new BotName(name);
    }
}
