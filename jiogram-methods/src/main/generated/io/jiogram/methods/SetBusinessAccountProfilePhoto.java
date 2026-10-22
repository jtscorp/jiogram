package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputProfilePhoto;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Changes the profile photo of a managed business account. Requires the can_edit_profile_photo
 * business bot right. Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param photo The new profile photo to set
 * @param isPublic Pass True to set the public photo, which will be visible even if the main photo
 *     is hidden by the business account's privacy settings. An account can have only one public
 *     photo.
 * @see <a href="https://core.telegram.org/bots/api#setbusinessaccountprofilephoto">setBusinessAccountProfilePhoto in the Bot API</a>
 */
public record SetBusinessAccountProfilePhoto(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("photo") InputProfilePhoto photo,
    @JsonProperty("is_public") @Nullable Boolean isPublic
) implements TelegramMethod<Boolean> {

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
}
