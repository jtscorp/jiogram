package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = BotCommandScopeDefault.class, name = "default"),
    @JsonSubTypes.Type(value = BotCommandScopeChatMember.class, name = "chat_member"),
    @JsonSubTypes.Type(value = BotCommandScopeChatAdministrators.class, name = "chat_administrators"),
    @JsonSubTypes.Type(value = BotCommandScopeChat.class, name = "chat"),
    @JsonSubTypes.Type(value = BotCommandScopeAllChatAdministrators.class, name = "all_chat_administrators"),
    @JsonSubTypes.Type(value = BotCommandScopeAllGroupChats.class, name = "all_group_chats"),
    @JsonSubTypes.Type(value = BotCommandScopeAllPrivateChats.class, name = "all_private_chats")
})
public sealed interface BotCommandScope permits BotCommandScopeDefault, BotCommandScopeChatMember, BotCommandScopeChatAdministrators, BotCommandScopeChat, BotCommandScopeAllChatAdministrators, BotCommandScopeAllGroupChats, BotCommandScopeAllPrivateChats {}
