package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object represents the scope to which bot commands are applied. Currently, the following 7
 * scopes are supported:
 * <br>- BotCommandScopeDefault
 * <br>- BotCommandScopeAllPrivateChats
 * <br>- BotCommandScopeAllGroupChats
 * <br>- BotCommandScopeAllChatAdministrators
 * <br>- BotCommandScopeChat
 * <br>- BotCommandScopeChatAdministrators
 * <br>- BotCommandScopeChatMember
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscope">BotCommandScope in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = BotCommandScopeUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = BotCommandScopeAllChatAdministrators.class, name = "all_chat_administrators"),
    @JsonSubTypes.Type(value = BotCommandScopeAllGroupChats.class, name = "all_group_chats"),
    @JsonSubTypes.Type(value = BotCommandScopeAllPrivateChats.class, name = "all_private_chats"),
    @JsonSubTypes.Type(value = BotCommandScopeChat.class, name = "chat"),
    @JsonSubTypes.Type(value = BotCommandScopeChatAdministrators.class, name = "chat_administrators"),
    @JsonSubTypes.Type(value = BotCommandScopeChatMember.class, name = "chat_member"),
    @JsonSubTypes.Type(value = BotCommandScopeDefault.class, name = "default")
})
public sealed interface BotCommandScope permits BotCommandScopeAllChatAdministrators, BotCommandScopeAllGroupChats, BotCommandScopeAllPrivateChats, BotCommandScopeChat, BotCommandScopeChatAdministrators, BotCommandScopeChatMember, BotCommandScopeDefault, BotCommandScopeUnknown {}
