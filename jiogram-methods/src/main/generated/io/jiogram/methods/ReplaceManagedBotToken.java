package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to revoke the current token of a managed bot and generate a new one. Returns the
 * new token as String on success.
 *
 * @param userId User identifier of the managed bot whose token will be replaced
 * @see <a href="https://core.telegram.org/bots/api#replacemanagedbottoken">replaceManagedBotToken in the Bot API</a>
 */
public record ReplaceManagedBotToken(
    @JsonProperty("user_id") long userId
) implements TelegramMethod<String> {

    @Override
    public String apiMethod() {
        return "replaceManagedBotToken";
    }

    @Override
    public String apiReturnType() {
        return "String";
    }

    public ReplaceManagedBotToken withUserId(long userId) {
        return new ReplaceManagedBotToken(userId);
    }
}
