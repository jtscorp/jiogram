package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetMyDescription(
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setMyDescription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMyDescription of() {
        return new SetMyDescription(null, null);
    }
}
