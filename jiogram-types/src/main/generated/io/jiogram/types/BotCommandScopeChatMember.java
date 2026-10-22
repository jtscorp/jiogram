package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;
import io.jiogram.types.ChatId;

/**
 * Represents the scope of bot commands, covering a specific member of a group or supergroup chat.
 *
 * @param type Scope type, must be chat_member
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername). Channel direct messages chats and channel chats aren't
 *     supported.
 * @param userId Unique identifier of the target user
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopechatmember">BotCommandScopeChatMember in the Bot API</a>
 */
public record BotCommandScopeChatMember(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId
) implements BotCommandScope {}
