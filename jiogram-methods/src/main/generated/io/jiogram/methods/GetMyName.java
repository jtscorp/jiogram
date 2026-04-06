package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotName;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record GetMyName(
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<BotName> {

    @Override
    public String apiMethod() {
        return "getMyName";
    }

    @Override
    public String apiReturnType() {
        return "BotName";
    }

    public static GetMyName of() {
        return new GetMyName(null);
    }
}
