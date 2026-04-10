package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public class SetChatTitle implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("title") private final String title;

    @JsonCreator
    public SetChatTitle(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("title") String title
    ) {
        this.chatId = chatId;
        this.title = title;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public String title() {
        return this.title;
    }

    @Override
    public String apiMethod() {
        return "setChatTitle";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
