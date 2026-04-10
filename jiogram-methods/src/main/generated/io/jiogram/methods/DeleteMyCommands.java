package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScope;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class DeleteMyCommands implements TelegramMethod<Boolean> {
    @JsonProperty("scope") @Nullable private final BotCommandScope scope;
    @JsonProperty("language_code") @Nullable private final String languageCode;

    @JsonCreator
    public DeleteMyCommands(
            @JsonProperty("scope") @Nullable BotCommandScope scope,
            @JsonProperty("language_code") @Nullable String languageCode
    ) {
        this.scope = scope;
        this.languageCode = languageCode;
    }

    public BotCommandScope scope() {
        return this.scope;
    }

    public String languageCode() {
        return this.languageCode;
    }

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
