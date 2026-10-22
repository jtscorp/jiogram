package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;

/**
 * Represents the scope of bot commands, covering all group and supergroup chat administrators.
 *
 * @param type Scope type, must be all_chat_administrators
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopeallchatadministrators">BotCommandScopeAllChatAdministrators in the Bot API</a>
 */
public record BotCommandScopeAllChatAdministrators(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type
) implements BotCommandScope {

    public static BotCommandScopeAllChatAdministrators of() {
        return new BotCommandScopeAllChatAdministrators(BotCommandScopeType.ALL_CHAT_ADMINISTRATORS);
    }
}
