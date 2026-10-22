package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;

/**
 * Represents the scope of bot commands, covering all private chats.
 *
 * @param type Scope type, must be all_private_chats
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopeallprivatechats">BotCommandScopeAllPrivateChats in the Bot API</a>
 */
public record BotCommandScopeAllPrivateChats(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type
) implements BotCommandScope {

    public static BotCommandScopeAllPrivateChats of() {
        return new BotCommandScopeAllPrivateChats(BotCommandScopeType.ALL_PRIVATE_CHATS);
    }
}
