package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetMyName implements TelegramMethod<Boolean> {
    @JsonProperty("name") @Nullable private final String name;
    @JsonProperty("language_code") @Nullable private final String languageCode;

    @JsonCreator
    public SetMyName(
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("language_code") @Nullable String languageCode
    ) {
        this.name = name;
        this.languageCode = languageCode;
    }

    public String name() {
        return this.name;
    }

    public String languageCode() {
        return this.languageCode;
    }

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
