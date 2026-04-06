package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UserProfilePhotos;
import org.jspecify.annotations.Nullable;

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
}
