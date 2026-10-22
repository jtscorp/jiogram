package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents the bot's short description.
 *
 * @param shortDescription The bot's short description
 * @see <a href="https://core.telegram.org/bots/api#botshortdescription">BotShortDescription in the Bot API</a>
 */
public record BotShortDescription(
    @JsonProperty("short_description") String shortDescription
) {}
