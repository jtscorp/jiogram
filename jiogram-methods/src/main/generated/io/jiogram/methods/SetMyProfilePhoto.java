package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputProfilePhoto;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Changes the profile photo of the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setmyprofilephoto">setMyProfilePhoto in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetMyProfilePhoto implements TelegramMethod<Boolean> {

    @JsonProperty("photo")
    private final InputProfilePhoto photo;

    /**
     * Creates a new {@code SetMyProfilePhoto} instance.
     *
     * @param photo The new profile photo to set
     */
    @JsonCreator
    public SetMyProfilePhoto(
            @JsonProperty("photo") InputProfilePhoto photo) {
        this.photo = photo;
    }

    @Override
    public String apiMethod() {
        return "setMyProfilePhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * The new profile photo to set
     */
    public InputProfilePhoto photo() {
        return photo;
    }

    public SetMyProfilePhoto withPhoto(InputProfilePhoto photo) {
        return new SetMyProfilePhoto(photo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetMyProfilePhoto)) {
            return false;
        }
        SetMyProfilePhoto that = (SetMyProfilePhoto) o;
        return Objects.equals(this.photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.photo);
    }

    @Override
    public String toString() {
        return "SetMyProfilePhoto[photo=" + this.photo
                + "]";
    }
}
