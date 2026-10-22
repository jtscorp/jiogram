package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.SuggestedPostPrice;
import org.jspecify.annotations.Nullable;

/**
 * Contains information about a suggested post.
 *
 * @param state State of the suggested post. Currently, it can be one of 'pending', 'approved',
 *     'declined'.
 * @param price Proposed price of the post. If the field is omitted, then the post is unpaid.
 * @param sendDate Proposed send date of the post. If the field is omitted, then the post can be
 *     published at any time within 30 days at the sole discretion of the user or administrator who
 *     approves it.
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostinfo">SuggestedPostInfo in the Bot API</a>
 */
public record SuggestedPostInfo(
    @JsonProperty("state") String state,
    @JsonProperty("price") @Nullable SuggestedPostPrice price,
    @JsonProperty("send_date") @Nullable Long sendDate
) {

    public SuggestedPostInfo withState(String state) {
        return new SuggestedPostInfo(state, price, sendDate);
    }

    public SuggestedPostInfo withPrice(@Nullable SuggestedPostPrice price) {
        return new SuggestedPostInfo(state, price, sendDate);
    }

    public SuggestedPostInfo withSendDate(@Nullable Long sendDate) {
        return new SuggestedPostInfo(state, price, sendDate);
    }
}
