package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommand;
import io.jiogram.types.BotCommandScope;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record SetMyCommands(
    @JsonProperty("commands") List<BotCommand> commands,
    @JsonProperty("scope") @Nullable BotCommandScope scope,
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setMyCommands";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMyCommands of(List<BotCommand> commands) {
        return new SetMyCommands(commands, null, null);
    }
}
