package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommand;
import io.jiogram.types.BotCommandScope;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class SetMyCommands implements TelegramMethod<Boolean> {
    @JsonProperty("commands") private final List<BotCommand> commands;
    @JsonProperty("scope") @Nullable private final BotCommandScope scope;
    @JsonProperty("language_code") @Nullable private final String languageCode;

    @JsonCreator
    public SetMyCommands(
            @JsonProperty("commands") List<BotCommand> commands,
            @JsonProperty("scope") @Nullable BotCommandScope scope,
            @JsonProperty("language_code") @Nullable String languageCode
    ) {
        this.commands = commands;
        this.scope = scope;
        this.languageCode = languageCode;
    }

    public List<BotCommand> commands() {
        return this.commands;
    }

    public BotCommandScope scope() {
        return this.scope;
    }

    public String languageCode() {
        return this.languageCode;
    }

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
