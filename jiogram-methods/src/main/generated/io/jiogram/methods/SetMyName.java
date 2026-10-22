package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the bot's name. Returns True on success.
 *
 * @param name New bot name; 0-64 characters. Pass an empty string to remove the dedicated name for
 *     the given language.
 * @param languageCode A two-letter ISO 639-1 language code. If empty, the name will be shown to all
 *     users for whose language there is no dedicated name.
 * @see <a href="https://core.telegram.org/bots/api#setmyname">setMyName in the Bot API</a>
 */
public record SetMyName(
    @JsonProperty("name") @Nullable String name,
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setMyName";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMyName of() {
        return new SetMyName(null, null);
    }
}
