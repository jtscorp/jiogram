package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record VerifyUser(
    @JsonProperty("user_id") long userId,
    @JsonProperty("custom_description") @Nullable String customDescription
) implements TelegramMethod<Boolean> {

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
