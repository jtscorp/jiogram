package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.KeyboardButton;
import io.jiogram.types.PreparedKeyboardButton;
import io.jiogram.types.TelegramMethod;

public record SavePreparedKeyboardButton(
    @JsonProperty("user_id") long userId,
    @JsonProperty("button") KeyboardButton button
) implements TelegramMethod<PreparedKeyboardButton> {

    @Override
    public String apiMethod() {
        return "savePreparedKeyboardButton";
    }

    @Override
    public String apiReturnType() {
        return "PreparedKeyboardButton";
    }
}
