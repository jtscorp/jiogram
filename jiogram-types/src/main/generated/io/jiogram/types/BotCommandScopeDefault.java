package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;

/**
 * Represents the default scope of bot commands. Default commands are used if no commands with a
 * narrower scope are specified for the user.
 *
 * @param type Scope type, must be default
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopedefault">BotCommandScopeDefault in the Bot API</a>
 */
public record BotCommandScopeDefault(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type
) implements BotCommandScope {}
