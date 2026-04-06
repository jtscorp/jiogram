package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.KeyboardButton;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record ReplyKeyboardMarkup(
    @JsonProperty("keyboard") List<List<KeyboardButton>> keyboard,
    @JsonProperty("is_persistent") @Nullable Boolean isPersistent,
    @JsonProperty("resize_keyboard") @Nullable Boolean resizeKeyboard,
    @JsonProperty("one_time_keyboard") @Nullable Boolean oneTimeKeyboard,
    @JsonProperty("input_field_placeholder") @Nullable String inputFieldPlaceholder,
    @JsonProperty("selective") @Nullable Boolean selective
) implements ReplyMarkup {}
