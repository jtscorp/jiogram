package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.StarAmount;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about a successful payment for a suggested post.
 *
 * @param suggestedPostMessage Message containing the suggested post. Note that the Message object
 *     in this field will not contain the reply_to_message field even if it itself is a reply.
 * @param currency Currency in which the payment was made. Currently, one of 'XTR' for Telegram
 *     Stars or 'TON' for toncoins
 * @param amount The amount of the currency that was received by the channel in nanotoncoins; for
 *     payments in toncoins only
 * @param starAmount The amount of Telegram Stars that was received by the channel; for payments in
 *     Telegram Stars only
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostpaid">SuggestedPostPaid in the Bot API</a>
 */
public record SuggestedPostPaid(
    @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
    @JsonProperty("currency") String currency,
    @JsonProperty("amount") @Nullable Long amount,
    @JsonProperty("star_amount") @Nullable StarAmount starAmount
) {

    public SuggestedPostPaid withSuggestedPostMessage(@Nullable Message suggestedPostMessage) {
        return new SuggestedPostPaid(suggestedPostMessage, currency, amount, starAmount);
    }

    public SuggestedPostPaid withCurrency(String currency) {
        return new SuggestedPostPaid(suggestedPostMessage, currency, amount, starAmount);
    }

    public SuggestedPostPaid withAmount(@Nullable Long amount) {
        return new SuggestedPostPaid(suggestedPostMessage, currency, amount, starAmount);
    }

    public SuggestedPostPaid withStarAmount(@Nullable StarAmount starAmount) {
        return new SuggestedPostPaid(suggestedPostMessage, currency, amount, starAmount);
    }
}
