package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotDescription;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record GetMyDescription(
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<BotDescription> {

    @Override
    public String apiMethod() {
        return "getMyDescription";
    }

    @Override
    public String apiReturnType() {
        return "BotDescription";
    }

    public static GetMyDescription of() {
        return new GetMyDescription(null);
    }
}
