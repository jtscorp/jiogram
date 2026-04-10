package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputFile;
import io.jiogram.types.TelegramMethod;

public class SetChatPhoto implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("photo") private final InputFile photo;

    @JsonCreator
    public SetChatPhoto(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("photo") InputFile photo
    ) {
        this.chatId = chatId;
        this.photo = photo;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public InputFile photo() {
        return this.photo;
    }

    @Override
    public String apiMethod() {
        return "setChatPhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
