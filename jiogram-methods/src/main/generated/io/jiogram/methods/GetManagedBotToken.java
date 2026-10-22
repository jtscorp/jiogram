package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to get the token of a managed bot. Returns the token as String on success.
 *
 * @param userId User identifier of the managed bot whose token will be returned
 * @see <a href="https://core.telegram.org/bots/api#getmanagedbottoken">getManagedBotToken in the Bot API</a>
 */
public record GetManagedBotToken(
    @JsonProperty("user_id") long userId
) implements TelegramMethod<String> {

    @Override
    public String apiMethod() {
        return "getManagedBotToken";
    }

    @Override
    public String apiReturnType() {
        return "String";
    }

    public GetManagedBotToken withUserId(long userId) {
        return new GetManagedBotToken(userId);
    }
}
