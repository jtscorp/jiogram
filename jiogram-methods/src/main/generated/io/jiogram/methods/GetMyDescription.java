package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotDescription;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class GetMyDescription implements TelegramMethod<BotDescription> {
    @JsonProperty("language_code") @Nullable private final String languageCode;

    @JsonCreator
    public GetMyDescription(
            @JsonProperty("language_code") @Nullable String languageCode
    ) {
        this.languageCode = languageCode;
    }

    public String languageCode() {
        return this.languageCode;
    }

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
