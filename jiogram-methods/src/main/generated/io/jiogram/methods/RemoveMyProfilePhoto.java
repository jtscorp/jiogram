package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Removes the profile photo of the bot. Requires no parameters. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#removemyprofilephoto">removeMyProfilePhoto in the Bot API</a>
 */
public record RemoveMyProfilePhoto(

) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "removeMyProfilePhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
