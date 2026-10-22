package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.StarAmount;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about a successful payment for a suggested post.
 *
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostpaid">SuggestedPostPaid in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SuggestedPostPaid {

    @JsonProperty("suggested_post_message")
    private final @Nullable Message suggestedPostMessage;

    @JsonProperty("currency")
    private final String currency;

    @JsonProperty("amount")
    private final @Nullable Long amount;

    @JsonProperty("star_amount")
    private final @Nullable StarAmount starAmount;

    /**
     * Creates a new {@code SuggestedPostPaid} instance.
     *
     * @param suggestedPostMessage Message containing the suggested post. Note that the Message
     *     object in this field will not contain the reply_to_message field even if it itself is a
     *     reply.
     * @param currency Currency in which the payment was made. Currently, one of 'XTR' for Telegram
     *     Stars or 'TON' for toncoins
     * @param amount The amount of the currency that was received by the channel in nanotoncoins;
     *     for payments in toncoins only
     * @param starAmount The amount of Telegram Stars that was received by the channel; for payments
     *     in Telegram Stars only
     */
    @JsonCreator
    public SuggestedPostPaid(
            @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
            @JsonProperty("currency") String currency,
            @JsonProperty("amount") @Nullable Long amount,
            @JsonProperty("star_amount") @Nullable StarAmount starAmount) {
        this.suggestedPostMessage = suggestedPostMessage;
        this.currency = currency;
        this.amount = amount;
        this.starAmount = starAmount;
    }

    public static SuggestedPostPaid of(String currency) {
        return new SuggestedPostPaid(null, currency, null, null);
    }

    /**
     * Message containing the suggested post. Note that the Message object in this field will not
     * contain the reply_to_message field even if it itself is a reply.
     */
    public @Nullable Message suggestedPostMessage() {
        return suggestedPostMessage;
    }

    /**
     * Currency in which the payment was made. Currently, one of 'XTR' for Telegram Stars or 'TON'
     * for toncoins
     */
    public String currency() {
        return currency;
    }

    /**
     * The amount of the currency that was received by the channel in nanotoncoins; for payments in
     * toncoins only
     */
    public @Nullable Long amount() {
        return amount;
    }

    /**
     * The amount of Telegram Stars that was received by the channel; for payments in Telegram Stars
     * only
     */
    public @Nullable StarAmount starAmount() {
        return starAmount;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SuggestedPostPaid)) {
            return false;
        }
        SuggestedPostPaid that = (SuggestedPostPaid) o;
        return Objects.equals(this.suggestedPostMessage, that.suggestedPostMessage)
                && Objects.equals(this.currency, that.currency)
                && Objects.equals(this.amount, that.amount)
                && Objects.equals(this.starAmount, that.starAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.suggestedPostMessage, this.currency, this.amount, this.starAmount);
    }

    @Override
    public String toString() {
        return "SuggestedPostPaid[suggestedPostMessage=" + this.suggestedPostMessage
                + ", currency=" + this.currency
                + ", amount=" + this.amount
                + ", starAmount=" + this.starAmount
                + "]";
    }
}
