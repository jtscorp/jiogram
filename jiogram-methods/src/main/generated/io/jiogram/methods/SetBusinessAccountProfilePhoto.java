package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputProfilePhoto;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Changes the profile photo of a managed business account. Requires the can_edit_profile_photo
 * business bot right. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setbusinessaccountprofilephoto">setBusinessAccountProfilePhoto in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetBusinessAccountProfilePhoto implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("photo")
    private final InputProfilePhoto photo;

    @JsonProperty("is_public")
    private final @Nullable Boolean isPublic;

    /**
     * Creates a new {@code SetBusinessAccountProfilePhoto} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param photo The new profile photo to set
     * @param isPublic Pass True to set the public photo, which will be visible even if the main
     *     photo is hidden by the business account's privacy settings. An account can have only one
     *     public photo.
     */
    @JsonCreator
    public SetBusinessAccountProfilePhoto(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("photo") InputProfilePhoto photo,
            @JsonProperty("is_public") @Nullable Boolean isPublic) {
        this.businessConnectionId = businessConnectionId;
        this.photo = photo;
        this.isPublic = isPublic;
    }

    @Override
    public String apiMethod() {
        return "setBusinessAccountProfilePhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetBusinessAccountProfilePhoto of(String businessConnectionId, InputProfilePhoto photo) {
        return new SetBusinessAccountProfilePhoto(businessConnectionId, photo, null);
    }

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * The new profile photo to set
     */
    public InputProfilePhoto photo() {
        return photo;
    }

    /**
     * Pass True to set the public photo, which will be visible even if the main photo is hidden by
     * the business account's privacy settings. An account can have only one public photo.
     */
    public @Nullable Boolean isPublic() {
        return isPublic;
    }

    public SetBusinessAccountProfilePhoto withBusinessConnectionId(String businessConnectionId) {
        return new SetBusinessAccountProfilePhoto(businessConnectionId, photo, isPublic);
    }

    public SetBusinessAccountProfilePhoto withPhoto(InputProfilePhoto photo) {
        return new SetBusinessAccountProfilePhoto(businessConnectionId, photo, isPublic);
    }

    public SetBusinessAccountProfilePhoto withIsPublic(@Nullable Boolean isPublic) {
        return new SetBusinessAccountProfilePhoto(businessConnectionId, photo, isPublic);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetBusinessAccountProfilePhoto)) {
            return false;
        }
        SetBusinessAccountProfilePhoto that = (SetBusinessAccountProfilePhoto) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.photo, that.photo)
                && Objects.equals(this.isPublic, that.isPublic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.photo, this.isPublic);
    }

    @Override
    public String toString() {
        return "SetBusinessAccountProfilePhoto[businessConnectionId=" + this.businessConnectionId
                + ", photo=" + this.photo
                + ", isPublic=" + this.isPublic
                + "]";
    }
}
