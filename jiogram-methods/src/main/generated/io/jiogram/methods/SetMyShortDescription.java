package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetMyShortDescription(
    @JsonProperty("short_description") @Nullable String shortDescription,
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setMyShortDescription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMyShortDescription of() {
        return new SetMyShortDescription(null, null);
    }
}
