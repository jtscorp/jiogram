package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class SwitchInlineQueryChosenChat {
    @JsonProperty("query") @Nullable private final String query;
    @JsonProperty("allow_user_chats") @Nullable private final Boolean allowUserChats;
    @JsonProperty("allow_bot_chats") @Nullable private final Boolean allowBotChats;
    @JsonProperty("allow_group_chats") @Nullable private final Boolean allowGroupChats;
    @JsonProperty("allow_channel_chats") @Nullable private final Boolean allowChannelChats;

    @JsonCreator
    public SwitchInlineQueryChosenChat(
            @JsonProperty("query") @Nullable String query,
            @JsonProperty("allow_user_chats") @Nullable Boolean allowUserChats,
            @JsonProperty("allow_bot_chats") @Nullable Boolean allowBotChats,
            @JsonProperty("allow_group_chats") @Nullable Boolean allowGroupChats,
            @JsonProperty("allow_channel_chats") @Nullable Boolean allowChannelChats
    ) {
        this.query = query;
        this.allowUserChats = allowUserChats;
        this.allowBotChats = allowBotChats;
        this.allowGroupChats = allowGroupChats;
        this.allowChannelChats = allowChannelChats;
    }

    public String query() {
        return this.query;
    }

    public Boolean allowUserChats() {
        return this.allowUserChats;
    }

    public Boolean allowBotChats() {
        return this.allowBotChats;
    }

    public Boolean allowGroupChats() {
        return this.allowGroupChats;
    }

    public Boolean allowChannelChats() {
        return this.allowChannelChats;
    }
}
