package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record ReplyKeyboardRemove(
    @JsonProperty("remove_keyboard") boolean removeKeyboard,
    @JsonProperty("selective") @Nullable Boolean selective
) implements ReplyMarkup {}
