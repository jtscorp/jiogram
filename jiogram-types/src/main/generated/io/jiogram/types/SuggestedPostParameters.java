package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.SuggestedPostPrice;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Contains parameters of a post that is being suggested by the bot.
 *
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostparameters">SuggestedPostParameters in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SuggestedPostParameters {

    @JsonProperty("price")
    private final @Nullable SuggestedPostPrice price;

    @JsonProperty("send_date")
    private final @Nullable Long sendDate;

    /**
     * Creates a new {@code SuggestedPostParameters} instance.
     *
     * @param price Proposed price for the post. If the field is omitted, then the post is unpaid.
     * @param sendDate Proposed send date of the post. If specified, then the date must be between
     *     300 second and 2678400 seconds (30 days) in the future. If the field is omitted, then the
     *     post can be published at any time within 30 days at the sole discretion of the user who
     *     approves it.
     */
    @JsonCreator
    public SuggestedPostParameters(
            @JsonProperty("price") @Nullable SuggestedPostPrice price,
            @JsonProperty("send_date") @Nullable Long sendDate) {
        this.price = price;
        this.sendDate = sendDate;
    }

    public static SuggestedPostParameters of() {
        return new SuggestedPostParameters(null, null);
    }

    /**
     * Proposed price for the post. If the field is omitted, then the post is unpaid.
     */
    public @Nullable SuggestedPostPrice price() {
        return price;
    }

    /**
     * Proposed send date of the post. If specified, then the date must be between 300 second and
     * 2678400 seconds (30 days) in the future. If the field is omitted, then the post can be
     * published at any time within 30 days at the sole discretion of the user who approves it.
     */
    public @Nullable Long sendDate() {
        return sendDate;
    }

    public SuggestedPostParameters withPrice(@Nullable SuggestedPostPrice price) {
        return new SuggestedPostParameters(price, sendDate);
    }

    public SuggestedPostParameters withSendDate(@Nullable Long sendDate) {
        return new SuggestedPostParameters(price, sendDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SuggestedPostParameters)) {
            return false;
        }
        SuggestedPostParameters that = (SuggestedPostParameters) o;
        return Objects.equals(this.price, that.price)
                && Objects.equals(this.sendDate, that.sendDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.price, this.sendDate);
    }

    @Override
    public String toString() {
        return "SuggestedPostParameters[price=" + this.price
                + ", sendDate=" + this.sendDate
                + "]";
    }
}
