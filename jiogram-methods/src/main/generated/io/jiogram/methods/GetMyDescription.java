package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotDescription;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get the current bot description for the given user language. Returns
 * BotDescription on success.
 *
 * @param languageCode A two-letter ISO 639-1 language code or an empty string
 * @see <a href="https://core.telegram.org/bots/api#getmydescription">getMyDescription in the Bot API</a>
 */
public record GetMyDescription(
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<BotDescription> {

    @Override
    public String apiMethod() {
        return "getMyDescription";
    }

    @Override
    public String apiReturnType() {
        return "BotDescription";
    }

    public static GetMyDescription of() {
        return new GetMyDescription(null);
    }
}
