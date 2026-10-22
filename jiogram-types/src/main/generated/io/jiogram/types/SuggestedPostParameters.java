package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.SuggestedPostPrice;
import org.jspecify.annotations.Nullable;

/**
 * Contains parameters of a post that is being suggested by the bot.
 *
 * @param price Proposed price for the post. If the field is omitted, then the post is unpaid.
 * @param sendDate Proposed send date of the post. If specified, then the date must be between 300
 *     second and 2678400 seconds (30 days) in the future. If the field is omitted, then the post
 *     can be published at any time within 30 days at the sole discretion of the user who approves
 *     it.
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostparameters">SuggestedPostParameters in the Bot API</a>
 */
public record SuggestedPostParameters(
    @JsonProperty("price") @Nullable SuggestedPostPrice price,
    @JsonProperty("send_date") @Nullable Long sendDate
) {

    public static SuggestedPostParameters of() {
        return new SuggestedPostParameters(null, null);
    }

    public SuggestedPostParameters withPrice(@Nullable SuggestedPostPrice price) {
        return new SuggestedPostParameters(price, sendDate);
    }

    public SuggestedPostParameters withSendDate(@Nullable Long sendDate) {
        return new SuggestedPostParameters(price, sendDate);
    }
}
