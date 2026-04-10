package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public class SetChatAdministratorCustomTitle implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("custom_title") private final String customTitle;

    @JsonCreator
    public SetChatAdministratorCustomTitle(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId,
            @JsonProperty("custom_title") String customTitle
    ) {
        this.chatId = chatId;
        this.userId = userId;
        this.customTitle = customTitle;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long userId() {
        return this.userId;
    }

    public String customTitle() {
        return this.customTitle;
    }

    @Override
    public String apiMethod() {
        return "setChatAdministratorCustomTitle";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
