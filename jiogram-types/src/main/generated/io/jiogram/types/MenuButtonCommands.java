package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButtonType;

/**
 * Represents a menu button, which opens the bot's list of commands.
 *
 * @param type Type of the button, must be commands
 * @see <a href="https://core.telegram.org/bots/api#menubuttoncommands">MenuButtonCommands in the Bot API</a>
 */
public record MenuButtonCommands(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MenuButtonType type
) implements MenuButton {}
