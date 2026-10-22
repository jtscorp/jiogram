package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import io.jiogram.types.TelegramMethod;

/**
 * Removes the profile photo of the bot. Requires no parameters. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#removemyprofilephoto">removeMyProfilePhoto in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class RemoveMyProfilePhoto implements TelegramMethod<Boolean> {

    /**
     * Creates a new {@code RemoveMyProfilePhoto} instance.
     */
    public RemoveMyProfilePhoto() {
    }

    @Override
    public String apiMethod() {
        return "removeMyProfilePhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof RemoveMyProfilePhoto;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "RemoveMyProfilePhoto[]";
    }
}
