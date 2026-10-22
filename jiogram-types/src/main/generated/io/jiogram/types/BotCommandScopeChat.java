package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;
import io.jiogram.types.ChatId;

/**
 * Represents the scope of bot commands, covering a specific chat.
 *
 * @param type Scope type, must be chat
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername). Channel direct messages chats and channel chats aren't
 *     supported.
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopechat">BotCommandScopeChat in the Bot API</a>
 */
public record BotCommandScopeChat(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type,
    @JsonProperty("chat_id") ChatId chatId
) implements BotCommandScope {

    public BotCommandScopeChat withChatId(ChatId chatId) {
        return new BotCommandScopeChat(type, chatId);
    }
}
