package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.SuggestedPostPrice;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Contains information about a suggested post.
 *
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostinfo">SuggestedPostInfo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SuggestedPostInfo {

    @JsonProperty("state")
    private final String state;

    @JsonProperty("price")
    private final @Nullable SuggestedPostPrice price;

    @JsonProperty("send_date")
    private final @Nullable Long sendDate;

    /**
     * Creates a new {@code SuggestedPostInfo} instance.
     *
     * @param state State of the suggested post. Currently, it can be one of 'pending', 'approved',
     *     'declined'.
     * @param price Proposed price of the post. If the field is omitted, then the post is unpaid.
     * @param sendDate Proposed send date of the post. If the field is omitted, then the post can be
     *     published at any time within 30 days at the sole discretion of the user or administrator
     *     who approves it.
     */
    @JsonCreator
    public SuggestedPostInfo(
            @JsonProperty("state") String state,
            @JsonProperty("price") @Nullable SuggestedPostPrice price,
            @JsonProperty("send_date") @Nullable Long sendDate) {
        this.state = state;
        this.price = price;
        this.sendDate = sendDate;
    }

    public static SuggestedPostInfo of(String state) {
        return new SuggestedPostInfo(state, null, null);
    }

    /**
     * State of the suggested post. Currently, it can be one of 'pending', 'approved', 'declined'.
     */
    public String state() {
        return state;
    }

    /**
     * Proposed price of the post. If the field is omitted, then the post is unpaid.
     */
    public @Nullable SuggestedPostPrice price() {
        return price;
    }

    /**
     * Proposed send date of the post. If the field is omitted, then the post can be published at
     * any time within 30 days at the sole discretion of the user or administrator who approves it.
     */
    public @Nullable Long sendDate() {
        return sendDate;
    }

    public SuggestedPostInfo withState(String state) {
        return new SuggestedPostInfo(state, price, sendDate);
    }

    public SuggestedPostInfo withPrice(@Nullable SuggestedPostPrice price) {
        return new SuggestedPostInfo(state, price, sendDate);
    }

    public SuggestedPostInfo withSendDate(@Nullable Long sendDate) {
        return new SuggestedPostInfo(state, price, sendDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SuggestedPostInfo)) {
            return false;
        }
        SuggestedPostInfo that = (SuggestedPostInfo) o;
        return Objects.equals(this.state, that.state)
                && Objects.equals(this.price, that.price)
                && Objects.equals(this.sendDate, that.sendDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.state, this.price, this.sendDate);
    }

    @Override
    public String toString() {
        return "SuggestedPostInfo[state=" + this.state
                + ", price=" + this.price
                + ", sendDate=" + this.sendDate
                + "]";
    }
}
