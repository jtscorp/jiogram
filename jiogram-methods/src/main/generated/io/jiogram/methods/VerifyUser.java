package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class VerifyUser implements TelegramMethod<Boolean> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("custom_description") @Nullable private final String customDescription;

    @JsonCreator
    public VerifyUser(
            @JsonProperty("user_id") long userId,
            @JsonProperty("custom_description") @Nullable String customDescription
    ) {
        this.userId = userId;
        this.customDescription = customDescription;
    }

    public long userId() {
        return this.userId;
    }

    public String customDescription() {
        return this.customDescription;
    }

    @Override
    public String apiMethod() {
        return "verifyUser";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static VerifyUser of(long userId) {
        return new VerifyUser(userId, null);
    }
}
