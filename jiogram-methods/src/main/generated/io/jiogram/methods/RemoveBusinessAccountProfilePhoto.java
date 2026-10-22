package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Removes the current profile photo of a managed business account. Requires the
 * can_edit_profile_photo business bot right. Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param isPublic Pass True to remove the public photo, which is visible even if the main photo is
 *     hidden by the business account's privacy settings. After the main photo is removed, the
 *     previous profile photo (if present) becomes the main photo.
 * @see <a href="https://core.telegram.org/bots/api#removebusinessaccountprofilephoto">removeBusinessAccountProfilePhoto in the Bot API</a>
 */
public record RemoveBusinessAccountProfilePhoto(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("is_public") @Nullable Boolean isPublic
) implements TelegramMethod<Boolean> {

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

    public RemoveBusinessAccountProfilePhoto withBusinessConnectionId(String businessConnectionId) {
        return new RemoveBusinessAccountProfilePhoto(businessConnectionId, isPublic);
    }

    public RemoveBusinessAccountProfilePhoto withIsPublic(@Nullable Boolean isPublic) {
        return new RemoveBusinessAccountProfilePhoto(businessConnectionId, isPublic);
    }
}
