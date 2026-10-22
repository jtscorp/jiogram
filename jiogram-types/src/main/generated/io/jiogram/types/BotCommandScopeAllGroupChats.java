package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;

/**
 * Represents the scope of bot commands, covering all group and supergroup chats.
 *
 * @param type Scope type, must be all_group_chats
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopeallgroupchats">BotCommandScopeAllGroupChats in the Bot API</a>
 */
public record BotCommandScopeAllGroupChats(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type
) implements BotCommandScope {

    public static BotCommandScopeAllGroupChats of() {
        return new BotCommandScopeAllGroupChats(BotCommandScopeType.ALL_GROUP_CHATS);
    }
}
