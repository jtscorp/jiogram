package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommand;
import io.jiogram.types.BotCommandScope;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get the current list of the bot's commands for the given scope and user
 * language. Returns an Array of BotCommand objects. If commands aren't set, an empty list is
 * returned.
 *
 * @param scope A JSON-serialized object, describing scope of users. Defaults to
 *     BotCommandScopeDefault.
 * @param languageCode A two-letter ISO 639-1 language code or an empty string
 * @see <a href="https://core.telegram.org/bots/api#getmycommands">getMyCommands in the Bot API</a>
 */
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

    public GetMyCommands withScope(@Nullable BotCommandScope scope) {
        return new GetMyCommands(scope, languageCode);
    }

    public GetMyCommands withLanguageCode(@Nullable String languageCode) {
        return new GetMyCommands(scope, languageCode);
    }
}
