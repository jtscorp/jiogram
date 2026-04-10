package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotName;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class GetMyName implements TelegramMethod<BotName> {
    @JsonProperty("language_code") @Nullable private final String languageCode;

    @JsonCreator
    public GetMyName(
            @JsonProperty("language_code") @Nullable String languageCode
    ) {
        this.languageCode = languageCode;
    }

    public String languageCode() {
        return this.languageCode;
    }

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
