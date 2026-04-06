package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.PreparedInlineMessage;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SavePreparedInlineMessage(
    @JsonProperty("user_id") long userId,
    @JsonProperty("result") InlineQueryResult result,
    @JsonProperty("allow_user_chats") @Nullable Boolean allowUserChats,
    @JsonProperty("allow_bot_chats") @Nullable Boolean allowBotChats,
    @JsonProperty("allow_group_chats") @Nullable Boolean allowGroupChats,
    @JsonProperty("allow_channel_chats") @Nullable Boolean allowChannelChats
) implements TelegramMethod<PreparedInlineMessage> {

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
