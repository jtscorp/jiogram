package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessConnection;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to get information about the connection of the bot with a business account.
 * Returns a BusinessConnection object on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @see <a href="https://core.telegram.org/bots/api#getbusinessconnection">getBusinessConnection in the Bot API</a>
 */
public record GetBusinessConnection(
    @JsonProperty("business_connection_id") String businessConnectionId
) implements TelegramMethod<BusinessConnection> {

    @Override
    public String apiMethod() {
        return "getBusinessConnection";
    }

    @Override
    public String apiReturnType() {
        return "BusinessConnection";
    }
}
