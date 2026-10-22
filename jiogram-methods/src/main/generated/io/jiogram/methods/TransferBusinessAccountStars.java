package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Transfers Telegram Stars from the business account balance to the bot's balance. Requires the
 * can_transfer_stars business bot right. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#transferbusinessaccountstars">transferBusinessAccountStars in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class TransferBusinessAccountStars implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("star_count")
    private final long starCount;

    /**
     * Creates a new {@code TransferBusinessAccountStars} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param starCount Number of Telegram Stars to transfer; 1-10000
     */
    @JsonCreator
    public TransferBusinessAccountStars(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("star_count") long starCount) {
        this.businessConnectionId = businessConnectionId;
        this.starCount = starCount;
    }

    @Override
    public String apiMethod() {
        return "transferBusinessAccountStars";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Number of Telegram Stars to transfer; 1-10000
     */
    public long starCount() {
        return starCount;
    }

    public TransferBusinessAccountStars withBusinessConnectionId(String businessConnectionId) {
        return new TransferBusinessAccountStars(businessConnectionId, starCount);
    }

    public TransferBusinessAccountStars withStarCount(long starCount) {
        return new TransferBusinessAccountStars(businessConnectionId, starCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransferBusinessAccountStars)) {
            return false;
        }
        TransferBusinessAccountStars that = (TransferBusinessAccountStars) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && this.starCount == that.starCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.starCount);
    }

    @Override
    public String toString() {
        return "TransferBusinessAccountStars[businessConnectionId=" + this.businessConnectionId
                + ", starCount=" + this.starCount
                + "]";
    }
}
