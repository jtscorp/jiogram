package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UserChatBoosts;

public record GetUserChatBoosts(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId
) implements TelegramMethod<UserChatBoosts> {

    @Override
    public String apiMethod() {
        return "getUserChatBoosts";
    }

    @Override
    public String apiReturnType() {
        return "UserChatBoosts";
    }
}
