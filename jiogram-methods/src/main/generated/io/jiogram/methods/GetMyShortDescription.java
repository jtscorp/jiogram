package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotShortDescription;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record GetMyShortDescription(
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<BotShortDescription> {

    @Override
    public String apiMethod() {
        return "getMyShortDescription";
    }

    @Override
    public String apiReturnType() {
        return "BotShortDescription";
    }

    public static GetMyShortDescription of() {
        return new GetMyShortDescription(null);
    }
}
