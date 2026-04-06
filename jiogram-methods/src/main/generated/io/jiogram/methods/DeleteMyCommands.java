package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScope;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record DeleteMyCommands(
    @JsonProperty("scope") @Nullable BotCommandScope scope,
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteMyCommands";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static DeleteMyCommands of() {
        return new DeleteMyCommands(null, null);
    }
}
