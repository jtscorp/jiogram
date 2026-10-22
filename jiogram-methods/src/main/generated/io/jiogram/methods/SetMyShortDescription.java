package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the bot's short description, which is shown on the bot's profile page
 * and is sent together with the link when users share the bot. Returns True on success.
 *
 * @param shortDescription New short description for the bot; 0-120 characters. Pass an empty string
 *     to remove the dedicated short description for the given language.
 * @param languageCode A two-letter ISO 639-1 language code. If empty, the short description will be
 *     applied to all users for whose language there is no dedicated short description.
 * @see <a href="https://core.telegram.org/bots/api#setmyshortdescription">setMyShortDescription in the Bot API</a>
 */
public record SetMyShortDescription(
    @JsonProperty("short_description") @Nullable String shortDescription,
    @JsonProperty("language_code") @Nullable String languageCode
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setMyShortDescription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMyShortDescription of() {
        return new SetMyShortDescription(null, null);
    }
}
