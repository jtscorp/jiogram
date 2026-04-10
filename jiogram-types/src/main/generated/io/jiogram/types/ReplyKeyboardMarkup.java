package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.KeyboardButton;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class ReplyKeyboardMarkup implements ReplyMarkup {
    @JsonProperty("keyboard") private final List<List<KeyboardButton>> keyboard;
    @JsonProperty("is_persistent") @Nullable private final Boolean isPersistent;
    @JsonProperty("resize_keyboard") @Nullable private final Boolean resizeKeyboard;
    @JsonProperty("one_time_keyboard") @Nullable private final Boolean oneTimeKeyboard;
    @JsonProperty("input_field_placeholder") @Nullable private final String inputFieldPlaceholder;
    @JsonProperty("selective") @Nullable private final Boolean selective;

    @JsonCreator
    public ReplyKeyboardMarkup(
            @JsonProperty("keyboard") List<List<KeyboardButton>> keyboard,
            @JsonProperty("is_persistent") @Nullable Boolean isPersistent,
            @JsonProperty("resize_keyboard") @Nullable Boolean resizeKeyboard,
            @JsonProperty("one_time_keyboard") @Nullable Boolean oneTimeKeyboard,
            @JsonProperty("input_field_placeholder") @Nullable String inputFieldPlaceholder,
            @JsonProperty("selective") @Nullable Boolean selective
    ) {
        this.keyboard = keyboard;
        this.isPersistent = isPersistent;
        this.resizeKeyboard = resizeKeyboard;
        this.oneTimeKeyboard = oneTimeKeyboard;
        this.inputFieldPlaceholder = inputFieldPlaceholder;
        this.selective = selective;
    }

    public List<List<KeyboardButton>> keyboard() {
        return this.keyboard;
    }

    public Boolean isPersistent() {
        return this.isPersistent;
    }

    public Boolean resizeKeyboard() {
        return this.resizeKeyboard;
    }

    public Boolean oneTimeKeyboard() {
        return this.oneTimeKeyboard;
    }

    public String inputFieldPlaceholder() {
        return this.inputFieldPlaceholder;
    }

    public Boolean selective() {
        return this.selective;
    }
}
