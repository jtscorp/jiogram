package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UserProfileAudios;
import org.jspecify.annotations.Nullable;

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
