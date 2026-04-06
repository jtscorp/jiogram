package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetMyName(
    @JsonProperty("name") @Nullable String name,
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setMyName";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMyName of() {
        return new SetMyName(null, null);
    }
}
