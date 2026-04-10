package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommand;
import io.jiogram.types.BotCommandScope;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class GetMyCommands implements TelegramMethod<List<BotCommand>> {
    @JsonProperty("scope") @Nullable private final BotCommandScope scope;
    @JsonProperty("language_code") @Nullable private final String languageCode;

    @JsonCreator
    public GetMyCommands(
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
        return "getMyCommands";
    }

    @Override
    public String apiReturnType() {
        return "Array of BotCommand";
    }

    public static GetMyCommands of() {
        return new GetMyCommands(null, null);
    }
}
