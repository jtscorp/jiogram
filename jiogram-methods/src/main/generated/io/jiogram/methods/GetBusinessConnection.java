package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessConnection;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to get information about the connection of the bot with a business account.
 * Returns a BusinessConnection object on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getbusinessconnection">getBusinessConnection in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetBusinessConnection implements TelegramMethod<BusinessConnection> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    /**
     * Creates a new {@code GetBusinessConnection} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     */
    @JsonCreator
    public GetBusinessConnection(
            @JsonProperty("business_connection_id") String businessConnectionId) {
        this.businessConnectionId = businessConnectionId;
    }

    @Override
    public String apiMethod() {
        return "getBusinessConnection";
    }

    @Override
    public String apiReturnType() {
        return "BusinessConnection";
    }

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    public GetBusinessConnection withBusinessConnectionId(String businessConnectionId) {
        return new GetBusinessConnection(businessConnectionId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetBusinessConnection)) {
            return false;
        }
        GetBusinessConnection that = (GetBusinessConnection) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId);
    }

    @Override
    public String toString() {
        return "GetBusinessConnection[businessConnectionId=" + this.businessConnectionId
                + "]";
    }
}
