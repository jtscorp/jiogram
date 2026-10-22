package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommand;
import io.jiogram.types.BotCommandScope;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the list of the bot's commands. See this manual for more details about
 * bot commands. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setmycommands">setMyCommands in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetMyCommands implements TelegramMethod<Boolean> {

    @JsonProperty("commands")
    private final List<BotCommand> commands;

    @JsonProperty("scope")
    private final @Nullable BotCommandScope scope;

    @JsonProperty("language_code")
    private final @Nullable String languageCode;

    /**
     * Creates a new {@code SetMyCommands} instance.
     *
     * @param commands A JSON-serialized list of bot commands to be set as the list of the bot's
     *     commands. At most 100 commands can be specified.
     * @param scope A JSON-serialized object, describing scope of users for which the commands are
     *     relevant. Defaults to BotCommandScopeDefault.
     * @param languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied
     *     to all users from the given scope, for whose language there are no dedicated commands
     */
    @JsonCreator
    public SetMyCommands(
            @JsonProperty("commands") List<BotCommand> commands,
            @JsonProperty("scope") @Nullable BotCommandScope scope,
            @JsonProperty("language_code") @Nullable String languageCode) {
        this.commands = commands;
        this.scope = scope;
        this.languageCode = languageCode;
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

    /**
     * A JSON-serialized list of bot commands to be set as the list of the bot's commands. At most
     * 100 commands can be specified.
     */
    public List<BotCommand> commands() {
        return commands;
    }

    /**
     * A JSON-serialized object, describing scope of users for which the commands are relevant.
     * Defaults to BotCommandScopeDefault.
     */
    public @Nullable BotCommandScope scope() {
        return scope;
    }

    /**
     * A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from
     * the given scope, for whose language there are no dedicated commands
     */
    public @Nullable String languageCode() {
        return languageCode;
    }

    public SetMyCommands withCommands(List<BotCommand> commands) {
        return new SetMyCommands(commands, scope, languageCode);
    }

    public SetMyCommands withScope(@Nullable BotCommandScope scope) {
        return new SetMyCommands(commands, scope, languageCode);
    }

    public SetMyCommands withLanguageCode(@Nullable String languageCode) {
        return new SetMyCommands(commands, scope, languageCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetMyCommands)) {
            return false;
        }
        SetMyCommands that = (SetMyCommands) o;
        return Objects.equals(this.commands, that.commands)
                && Objects.equals(this.scope, that.scope)
                && Objects.equals(this.languageCode, that.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.commands, this.scope, this.languageCode);
    }

    @Override
    public String toString() {
        return "SetMyCommands[commands=" + this.commands
                + ", scope=" + this.scope
                + ", languageCode=" + this.languageCode
                + "]";
    }
}
