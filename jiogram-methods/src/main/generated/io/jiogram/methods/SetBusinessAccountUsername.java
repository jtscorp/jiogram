package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Changes the username of a managed business account. Requires the can_change_username business bot
 * right. Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param username The new value of the username for the business account; 0-32 characters
 * @see <a href="https://core.telegram.org/bots/api#setbusinessaccountusername">setBusinessAccountUsername in the Bot API</a>
 */
public record SetBusinessAccountUsername(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("username") @Nullable String username
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setBusinessAccountUsername";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetBusinessAccountUsername of(String businessConnectionId) {
        return new SetBusinessAccountUsername(businessConnectionId, null);
    }
}
