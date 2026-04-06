package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record SwitchInlineQueryChosenChat(
    @JsonProperty("query") @Nullable String query,
    @JsonProperty("allow_user_chats") @Nullable Boolean allowUserChats,
    @JsonProperty("allow_bot_chats") @Nullable Boolean allowBotChats,
    @JsonProperty("allow_group_chats") @Nullable Boolean allowGroupChats,
    @JsonProperty("allow_channel_chats") @Nullable Boolean allowChannelChats
) {}
