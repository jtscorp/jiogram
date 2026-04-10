package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.KeyboardButton;
import io.jiogram.types.PreparedKeyboardButton;
import io.jiogram.types.TelegramMethod;

public class SavePreparedKeyboardButton implements TelegramMethod<PreparedKeyboardButton> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("button") private final KeyboardButton button;

    @JsonCreator
    public SavePreparedKeyboardButton(
            @JsonProperty("user_id") long userId,
            @JsonProperty("button") KeyboardButton button
    ) {
        this.userId = userId;
        this.button = button;
    }

    public long userId() {
        return this.userId;
    }

    public KeyboardButton button() {
        return this.button;
    }

    @Override
    public String apiMethod() {
        return "savePreparedKeyboardButton";
    }

    @Override
    public String apiReturnType() {
        return "PreparedKeyboardButton";
    }
}
