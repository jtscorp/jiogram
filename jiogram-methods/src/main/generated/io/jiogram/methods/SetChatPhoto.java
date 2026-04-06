package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputFile;
import io.jiogram.types.TelegramMethod;

public record SetChatPhoto(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("photo") InputFile photo
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatPhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
