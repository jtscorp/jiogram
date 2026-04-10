package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.PreparedInlineMessage;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SavePreparedInlineMessage implements TelegramMethod<PreparedInlineMessage> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("result") private final InlineQueryResult result;
    @JsonProperty("allow_user_chats") @Nullable private final Boolean allowUserChats;
    @JsonProperty("allow_bot_chats") @Nullable private final Boolean allowBotChats;
    @JsonProperty("allow_group_chats") @Nullable private final Boolean allowGroupChats;
    @JsonProperty("allow_channel_chats") @Nullable private final Boolean allowChannelChats;

    @JsonCreator
    public SavePreparedInlineMessage(
            @JsonProperty("user_id") long userId,
            @JsonProperty("result") InlineQueryResult result,
            @JsonProperty("allow_user_chats") @Nullable Boolean allowUserChats,
            @JsonProperty("allow_bot_chats") @Nullable Boolean allowBotChats,
            @JsonProperty("allow_group_chats") @Nullable Boolean allowGroupChats,
            @JsonProperty("allow_channel_chats") @Nullable Boolean allowChannelChats
    ) {
        this.userId = userId;
        this.result = result;
        this.allowUserChats = allowUserChats;
        this.allowBotChats = allowBotChats;
        this.allowGroupChats = allowGroupChats;
        this.allowChannelChats = allowChannelChats;
    }

    public long userId() {
        return this.userId;
    }

    public InlineQueryResult result() {
        return this.result;
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

    @Override
    public String apiMethod() {
        return "savePreparedInlineMessage";
    }

    @Override
    public String apiReturnType() {
        return "PreparedInlineMessage";
    }

    public static SavePreparedInlineMessage of(long userId, InlineQueryResult result) {
        return new SavePreparedInlineMessage(userId, result, null, null, null, null);
    }
}
