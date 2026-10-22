package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Describes a service message about a change in the price of paid messages within a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#paidmessagepricechanged">PaidMessagePriceChanged in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PaidMessagePriceChanged {

    @JsonProperty("paid_message_star_count")
    private final long paidMessageStarCount;

    /**
     * Creates a new {@code PaidMessagePriceChanged} instance.
     *
     * @param paidMessageStarCount The new number of Telegram Stars that must be paid by
     *     non-administrator users of the supergroup chat for each sent message
     */
    @JsonCreator
    public PaidMessagePriceChanged(
            @JsonProperty("paid_message_star_count") long paidMessageStarCount) {
        this.paidMessageStarCount = paidMessageStarCount;
    }

    /**
     * The new number of Telegram Stars that must be paid by non-administrator users of the
     * supergroup chat for each sent message
     */
    public long paidMessageStarCount() {
        return paidMessageStarCount;
    }

    public PaidMessagePriceChanged withPaidMessageStarCount(long paidMessageStarCount) {
        return new PaidMessagePriceChanged(paidMessageStarCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaidMessagePriceChanged)) {
            return false;
        }
        PaidMessagePriceChanged that = (PaidMessagePriceChanged) o;
        return this.paidMessageStarCount == that.paidMessageStarCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.paidMessageStarCount);
    }

    @Override
    public String toString() {
        return "PaidMessagePriceChanged[paidMessageStarCount=" + this.paidMessageStarCount
                + "]";
    }
}
