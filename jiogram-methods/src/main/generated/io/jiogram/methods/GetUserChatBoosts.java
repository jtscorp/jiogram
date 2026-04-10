package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UserChatBoosts;

public class GetUserChatBoosts implements TelegramMethod<UserChatBoosts> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("user_id") private final long userId;

    @JsonCreator
    public GetUserChatBoosts(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId
    ) {
        this.chatId = chatId;
        this.userId = userId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long userId() {
        return this.userId;
    }

    @Override
    public String apiMethod() {
        return "getUserChatBoosts";
    }

    @Override
    public String apiReturnType() {
        return "UserChatBoosts";
    }
}
