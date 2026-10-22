package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UserProfileAudios;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get a list of profile audios for a user. Returns a UserProfileAudios object.
 *
 * @param userId Unique identifier of the target user
 * @param offset Sequential number of the first audio to be returned. By default, all audios are
 *     returned.
 * @param limit Limits the number of audios to be retrieved. Values between 1-100 are accepted.
 *     Defaults to 100.
 * @see <a href="https://core.telegram.org/bots/api#getuserprofileaudios">getUserProfileAudios in the Bot API</a>
 */
public record GetUserProfileAudios(
    @JsonProperty("user_id") long userId,
    @JsonProperty("offset") @Nullable Long offset,
    @JsonProperty("limit") @Nullable Long limit
) implements TelegramMethod<UserProfileAudios> {

    @Override
    public String apiMethod() {
        return "getUserProfileAudios";
    }

    @Override
    public String apiReturnType() {
        return "UserProfileAudios";
    }

    public static GetUserProfileAudios of(long userId) {
        return new GetUserProfileAudios(userId, null, null);
    }
}
