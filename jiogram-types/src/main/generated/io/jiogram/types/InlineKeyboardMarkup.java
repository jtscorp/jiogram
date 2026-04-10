package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardButton;
import java.util.List;

public class InlineKeyboardMarkup implements ReplyMarkup {
    @JsonProperty("inline_keyboard") private final List<List<InlineKeyboardButton>> inlineKeyboard;

    @JsonCreator
    public InlineKeyboardMarkup(
            @JsonProperty("inline_keyboard") List<List<InlineKeyboardButton>> inlineKeyboard
    ) {
        this.inlineKeyboard = inlineKeyboard;
    }

    public List<List<InlineKeyboardButton>> inlineKeyboard() {
        return this.inlineKeyboard;
    }
}
