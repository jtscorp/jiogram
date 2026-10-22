package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;
import io.jiogram.types.ChatId;

/**
 * Represents the scope of bot commands, covering all administrators of a specific group or
 * supergroup chat.
 *
 * @param type Scope type, must be chat_administrators
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername). Channel direct messages chats and channel chats aren't
 *     supported.
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopechatadministrators">BotCommandScopeChatAdministrators in the Bot API</a>
 */
public record BotCommandScopeChatAdministrators(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type,
    @JsonProperty("chat_id") ChatId chatId
) implements BotCommandScope {

    public BotCommandScopeChatAdministrators withChatId(ChatId chatId) {
        return new BotCommandScopeChatAdministrators(type, chatId);
    }
}
