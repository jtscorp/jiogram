package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = BotCommandScopeAllChatAdministrators.class, name = "all_chat_administrators"),
    @JsonSubTypes.Type(value = BotCommandScopeChat.class, name = "chat"),
    @JsonSubTypes.Type(value = BotCommandScopeChatAdministrators.class, name = "chat_administrators"),
    @JsonSubTypes.Type(value = BotCommandScopeChatMember.class, name = "chat_member"),
    @JsonSubTypes.Type(value = BotCommandScopeDefault.class, name = "default"),
    @JsonSubTypes.Type(value = BotCommandScopeAllPrivateChats.class, name = "all_private_chats"),
    @JsonSubTypes.Type(value = BotCommandScopeAllGroupChats.class, name = "all_group_chats")
})
public sealed interface BotCommandScope permits BotCommandScopeAllChatAdministrators, BotCommandScopeChat, BotCommandScopeChatAdministrators, BotCommandScopeChatMember, BotCommandScopeDefault, BotCommandScopeAllPrivateChats, BotCommandScopeAllGroupChats {}
