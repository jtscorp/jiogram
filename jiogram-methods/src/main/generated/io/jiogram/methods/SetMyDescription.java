package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetMyDescription implements TelegramMethod<Boolean> {
    @JsonProperty("description") @Nullable private final String description;
    @JsonProperty("language_code") @Nullable private final String languageCode;

    @JsonCreator
    public SetMyDescription(
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("language_code") @Nullable String languageCode
    ) {
        this.description = description;
        this.languageCode = languageCode;
    }

    public String description() {
        return this.description;
    }

    public String languageCode() {
        return this.languageCode;
    }

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
