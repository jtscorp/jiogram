package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents a bot command.
 *
 * @param command Text of the command; 1-32 characters. Can contain only lowercase English letters,
 *     digits and underscores.
 * @param description Description of the command; 1-256 characters.
 * @see <a href="https://core.telegram.org/bots/api#botcommand">BotCommand in the Bot API</a>
 */
public record BotCommand(
    @JsonProperty("command") String command,
    @JsonProperty("description") String description
) {}
