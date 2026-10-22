package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UserProfilePhotos;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object.
 *
 * @param userId Unique identifier of the target user
 * @param offset Sequential number of the first photo to be returned. By default, all photos are
 *     returned.
 * @param limit Limits the number of photos to be retrieved. Values between 1-100 are accepted.
 *     Defaults to 100.
 * @see <a href="https://core.telegram.org/bots/api#getuserprofilephotos">getUserProfilePhotos in the Bot API</a>
 */
public record GetUserProfilePhotos(
    @JsonProperty("user_id") long userId,
    @JsonProperty("offset") @Nullable Long offset,
    @JsonProperty("limit") @Nullable Long limit
) implements TelegramMethod<UserProfilePhotos> {

    @Override
    public String apiMethod() {
        return "getUserProfilePhotos";
    }

    @Override
    public String apiReturnType() {
        return "UserProfilePhotos";
    }

    public static GetUserProfilePhotos of(long userId) {
        return new GetUserProfilePhotos(userId, null, null);
    }

    public GetUserProfilePhotos withUserId(long userId) {
        return new GetUserProfilePhotos(userId, offset, limit);
    }

    public GetUserProfilePhotos withOffset(@Nullable Long offset) {
        return new GetUserProfilePhotos(userId, offset, limit);
    }

    public GetUserProfilePhotos withLimit(@Nullable Long limit) {
        return new GetUserProfilePhotos(userId, offset, limit);
    }
}
