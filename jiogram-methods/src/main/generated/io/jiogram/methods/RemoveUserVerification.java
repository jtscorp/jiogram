package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Removes verification from a user who is currently verified on behalf of the organization
 * represented by the bot. Returns True on success.
 *
 * @param userId Unique identifier of the target user
 * @see <a href="https://core.telegram.org/bots/api#removeuserverification">removeUserVerification in the Bot API</a>
 */
public record RemoveUserVerification(
    @JsonProperty("user_id") long userId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "removeUserVerification";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
