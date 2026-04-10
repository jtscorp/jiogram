package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotShortDescription;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class GetMyShortDescription implements TelegramMethod<BotShortDescription> {
    @JsonProperty("language_code") @Nullable private final String languageCode;

    @JsonCreator
    public GetMyShortDescription(
            @JsonProperty("language_code") @Nullable String languageCode
    ) {
        this.languageCode = languageCode;
    }

    public String languageCode() {
        return this.languageCode;
    }

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
