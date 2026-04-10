package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UserProfileAudios;
import org.jspecify.annotations.Nullable;

public class GetUserProfileAudios implements TelegramMethod<UserProfileAudios> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("offset") @Nullable private final Long offset;
    @JsonProperty("limit") @Nullable private final Long limit;

    @JsonCreator
    public GetUserProfileAudios(
            @JsonProperty("user_id") long userId,
            @JsonProperty("offset") @Nullable Long offset,
            @JsonProperty("limit") @Nullable Long limit
    ) {
        this.userId = userId;
        this.offset = offset;
        this.limit = limit;
    }

    public long userId() {
        return this.userId;
    }

    public Long offset() {
        return this.offset;
    }

    public Long limit() {
        return this.limit;
    }

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
