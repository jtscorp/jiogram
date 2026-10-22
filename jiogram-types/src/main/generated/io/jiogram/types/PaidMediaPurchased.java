package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.Objects;

/**
 * This object contains information about a paid media purchase.
 *
 * @see <a href="https://core.telegram.org/bots/api#paidmediapurchased">PaidMediaPurchased in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PaidMediaPurchased {

    @JsonProperty("from")
    private final User from;

    @JsonProperty("paid_media_payload")
    private final String paidMediaPayload;

    /**
     * Creates a new {@code PaidMediaPurchased} instance.
     *
     * @param from User who purchased the media
     * @param paidMediaPayload Bot-specified paid media payload
     */
    @JsonCreator
    public PaidMediaPurchased(
            @JsonProperty("from") User from,
            @JsonProperty("paid_media_payload") String paidMediaPayload) {
        this.from = from;
        this.paidMediaPayload = paidMediaPayload;
    }

    /**
     * User who purchased the media
     */
    public User from() {
        return from;
    }

    /**
     * Bot-specified paid media payload
     */
    public String paidMediaPayload() {
        return paidMediaPayload;
    }

    public PaidMediaPurchased withFrom(User from) {
        return new PaidMediaPurchased(from, paidMediaPayload);
    }

    public PaidMediaPurchased withPaidMediaPayload(String paidMediaPayload) {
        return new PaidMediaPurchased(from, paidMediaPayload);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaidMediaPurchased)) {
            return false;
        }
        PaidMediaPurchased that = (PaidMediaPurchased) o;
        return Objects.equals(this.from, that.from)
                && Objects.equals(this.paidMediaPayload, that.paidMediaPayload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.from, this.paidMediaPayload);
    }

    @Override
    public String toString() {
        return "PaidMediaPurchased[from=" + this.from
                + ", paidMediaPayload=" + this.paidMediaPayload
                + "]";
    }
}
