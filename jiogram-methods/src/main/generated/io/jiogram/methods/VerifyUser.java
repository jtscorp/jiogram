package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Verifies a user on behalf of the organization which is represented by the bot. Returns True on
 * success.
 *
 * @param userId Unique identifier of the target user
 * @param customDescription Custom description for the verification; 0-70 characters. Must be empty
 *     if the organization isn't allowed to provide a custom verification description.
 * @see <a href="https://core.telegram.org/bots/api#verifyuser">verifyUser in the Bot API</a>
 */
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

    public VerifyUser withUserId(long userId) {
        return new VerifyUser(userId, customDescription);
    }

    public VerifyUser withCustomDescription(@Nullable String customDescription) {
        return new VerifyUser(userId, customDescription);
    }
}
