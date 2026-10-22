package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotShortDescription;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get the current bot short description for the given user language. Returns
 * BotShortDescription on success.
 *
 * @param languageCode A two-letter ISO 639-1 language code or an empty string
 * @see <a href="https://core.telegram.org/bots/api#getmyshortdescription">getMyShortDescription in the Bot API</a>
 */
public record GetMyShortDescription(
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<BotShortDescription> {

    @Override
    public String apiMethod() {
        return "getMyShortDescription";
    }

    @Override
    public String apiReturnType() {
        return "BotShortDescription";
    }

    public static GetMyShortDescription of() {
        return new GetMyShortDescription(null);
    }

    public GetMyShortDescription withLanguageCode(@Nullable String languageCode) {
        return new GetMyShortDescription(languageCode);
    }
}
