package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the bot's description, which is shown in the chat with the bot if the
 * chat is empty. Returns True on success.
 *
 * @param description New bot description; 0-512 characters. Pass an empty string to remove the
 *     dedicated description for the given language.
 * @param languageCode A two-letter ISO 639-1 language code. If empty, the description will be
 *     applied to all users for whose language there is no dedicated description.
 * @see <a href="https://core.telegram.org/bots/api#setmydescription">setMyDescription in the Bot API</a>
 */
public record SetMyDescription(
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setMyDescription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMyDescription of() {
        return new SetMyDescription(null, null);
    }

    public SetMyDescription withDescription(@Nullable String description) {
        return new SetMyDescription(description, languageCode);
    }

    public SetMyDescription withLanguageCode(@Nullable String languageCode) {
        return new SetMyDescription(description, languageCode);
    }
}
