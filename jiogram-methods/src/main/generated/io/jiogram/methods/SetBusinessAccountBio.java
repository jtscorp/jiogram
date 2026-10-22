package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Changes the bio of a managed business account. Requires the can_change_bio business bot right.
 * Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param bio The new value of the bio for the business account; 0-140 characters
 * @see <a href="https://core.telegram.org/bots/api#setbusinessaccountbio">setBusinessAccountBio in the Bot API</a>
 */
public record SetBusinessAccountBio(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("bio") @Nullable String bio
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setBusinessAccountBio";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetBusinessAccountBio of(String businessConnectionId) {
        return new SetBusinessAccountBio(businessConnectionId, null);
    }
}
