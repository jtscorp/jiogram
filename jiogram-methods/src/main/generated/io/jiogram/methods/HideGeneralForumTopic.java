package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record HideGeneralForumTopic(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "hideGeneralForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
