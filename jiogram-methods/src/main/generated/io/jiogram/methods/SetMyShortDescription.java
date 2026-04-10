package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetMyShortDescription implements TelegramMethod<Boolean> {
    @JsonProperty("short_description") @Nullable private final String shortDescription;
    @JsonProperty("language_code") @Nullable private final String languageCode;

    @JsonCreator
    public SetMyShortDescription(
            @JsonProperty("short_description") @Nullable String shortDescription,
            @JsonProperty("language_code") @Nullable String languageCode
    ) {
        this.shortDescription = shortDescription;
        this.languageCode = languageCode;
    }

    public String shortDescription() {
        return this.shortDescription;
    }

    public String languageCode() {
        return this.languageCode;
    }

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
