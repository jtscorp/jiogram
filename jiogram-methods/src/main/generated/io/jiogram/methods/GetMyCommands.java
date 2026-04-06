package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommand;
import io.jiogram.types.BotCommandScope;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record GetMyCommands(
    @JsonProperty("scope") @Nullable BotCommandScope scope,
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<List<BotCommand>> {

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
