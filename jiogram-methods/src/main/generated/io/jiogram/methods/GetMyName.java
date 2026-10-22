package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotName;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get the current bot name for the given user language. Returns BotName on
 * success.
 *
 * @param languageCode A two-letter ISO 639-1 language code or an empty string
 * @see <a href="https://core.telegram.org/bots/api#getmyname">getMyName in the Bot API</a>
 */
public record GetMyName(
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<BotName> {

    @Override
    public String apiMethod() {
        return "getMyName";
    }

    @Override
    public String apiReturnType() {
        return "BotName";
    }

    public static GetMyName of() {
        return new GetMyName(null);
    }

    public GetMyName withLanguageCode(@Nullable String languageCode) {
        return new GetMyName(languageCode);
    }
}
