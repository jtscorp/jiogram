package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Removes the current profile photo of a managed business account. Requires the
 * can_edit_profile_photo business bot right. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#removebusinessaccountprofilephoto">removeBusinessAccountProfilePhoto in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class RemoveBusinessAccountProfilePhoto implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("is_public")
    private final @Nullable Boolean isPublic;

    /**
     * Creates a new {@code RemoveBusinessAccountProfilePhoto} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param isPublic Pass True to remove the public photo, which is visible even if the main photo
     *     is hidden by the business account's privacy settings. After the main photo is removed,
     *     the previous profile photo (if present) becomes the main photo.
     */
    @JsonCreator
    public RemoveBusinessAccountProfilePhoto(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("is_public") @Nullable Boolean isPublic) {
        this.businessConnectionId = businessConnectionId;
        this.isPublic = isPublic;
    }

    @Override
    public String apiMethod() {
        return "removeBusinessAccountProfilePhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static RemoveBusinessAccountProfilePhoto of(String businessConnectionId) {
        return new RemoveBusinessAccountProfilePhoto(businessConnectionId, null);
    }

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Pass True to remove the public photo, which is visible even if the main photo is hidden by
     * the business account's privacy settings. After the main photo is removed, the previous
     * profile photo (if present) becomes the main photo.
     */
    public @Nullable Boolean isPublic() {
        return isPublic;
    }

    public RemoveBusinessAccountProfilePhoto withBusinessConnectionId(String businessConnectionId) {
        return new RemoveBusinessAccountProfilePhoto(businessConnectionId, isPublic);
    }

    public RemoveBusinessAccountProfilePhoto withIsPublic(@Nullable Boolean isPublic) {
        return new RemoveBusinessAccountProfilePhoto(businessConnectionId, isPublic);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RemoveBusinessAccountProfilePhoto)) {
            return false;
        }
        RemoveBusinessAccountProfilePhoto that = (RemoveBusinessAccountProfilePhoto) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.isPublic, that.isPublic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.isPublic);
    }

    @Override
    public String toString() {
        return "RemoveBusinessAccountProfilePhoto[businessConnectionId=" + this.businessConnectionId
                + ", isPublic=" + this.isPublic
                + "]";
    }
}
