package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarAmount;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Returns the amount of Telegram Stars owned by a managed business account. Requires the
 * can_view_gifts_and_stars business bot right. Returns StarAmount on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getbusinessaccountstarbalance">getBusinessAccountStarBalance in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetBusinessAccountStarBalance implements TelegramMethod<StarAmount> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    /**
     * Creates a new {@code GetBusinessAccountStarBalance} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     */
    @JsonCreator
    public GetBusinessAccountStarBalance(
            @JsonProperty("business_connection_id") String businessConnectionId) {
        this.businessConnectionId = businessConnectionId;
    }

    @Override
    public String apiMethod() {
        return "getBusinessAccountStarBalance";
    }

    @Override
    public String apiReturnType() {
        return "StarAmount";
    }

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    public GetBusinessAccountStarBalance withBusinessConnectionId(String businessConnectionId) {
        return new GetBusinessAccountStarBalance(businessConnectionId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetBusinessAccountStarBalance)) {
            return false;
        }
        GetBusinessAccountStarBalance that = (GetBusinessAccountStarBalance) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId);
    }

    @Override
    public String toString() {
        return "GetBusinessAccountStarBalance[businessConnectionId=" + this.businessConnectionId
                + "]";
    }
}
