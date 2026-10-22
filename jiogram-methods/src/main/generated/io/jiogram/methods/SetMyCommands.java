package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommand;
import io.jiogram.types.BotCommandScope;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the list of the bot's commands. See this manual for more details about
 * bot commands. Returns True on success.
 *
 * @param commands A JSON-serialized list of bot commands to be set as the list of the bot's
 *     commands. At most 100 commands can be specified.
 * @param scope A JSON-serialized object, describing scope of users for which the commands are
 *     relevant. Defaults to BotCommandScopeDefault.
 * @param languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to
 *     all users from the given scope, for whose language there are no dedicated commands
 * @see <a href="https://core.telegram.org/bots/api#setmycommands">setMyCommands in the Bot API</a>
 */
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
