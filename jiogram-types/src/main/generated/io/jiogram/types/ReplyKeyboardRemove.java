package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class ReplyKeyboardRemove implements ReplyMarkup {
    @JsonProperty("remove_keyboard") private final boolean removeKeyboard;
    @JsonProperty("selective") @Nullable private final Boolean selective;

    @JsonCreator
    public ReplyKeyboardRemove(
            @JsonProperty("remove_keyboard") boolean removeKeyboard,
            @JsonProperty("selective") @Nullable Boolean selective
    ) {
        this.removeKeyboard = removeKeyboard;
        this.selective = selective;
    }

    public boolean removeKeyboard() {
        return this.removeKeyboard;
    }

    public Boolean selective() {
        return this.selective;
    }
}
