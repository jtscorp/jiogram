package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScope;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to delete the list of the bot's commands for the given scope and user language.
 * After deletion, higher level commands will be shown to affected users. Returns True on success.
 *
 * @param scope A JSON-serialized object, describing scope of users for which the commands are
 *     relevant. Defaults to BotCommandScopeDefault.
 * @param languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to
 *     all users from the given scope, for whose language there are no dedicated commands
 * @see <a href="https://core.telegram.org/bots/api#deletemycommands">deleteMyCommands in the Bot API</a>
 */
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
