package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputProfilePhoto;
import io.jiogram.types.TelegramMethod;

/**
 * Changes the profile photo of the bot. Returns True on success.
 *
 * @param photo The new profile photo to set
 * @see <a href="https://core.telegram.org/bots/api#setmyprofilephoto">setMyProfilePhoto in the Bot API</a>
 */
public record SetMyProfilePhoto(
    @JsonProperty("photo") InputProfilePhoto photo
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setMyProfilePhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
