package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OrderInfo;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about an incoming pre-checkout query.
 *
 * @see <a href="https://core.telegram.org/bots/api#precheckoutquery">PreCheckoutQuery in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PreCheckoutQuery {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("from")
    private final User from;

    @JsonProperty("currency")
    private final String currency;

    @JsonProperty("total_amount")
    private final long totalAmount;

    @JsonProperty("invoice_payload")
    private final String invoicePayload;

    @JsonProperty("shipping_option_id")
    private final @Nullable String shippingOptionId;

    @JsonProperty("order_info")
    private final @Nullable OrderInfo orderInfo;

    /**
     * Creates a new {@code PreCheckoutQuery} instance.
     *
     * @param id Unique query identifier
     * @param from User who sent the query
     * @param currency Three-letter ISO 4217 currency code, or 'XTR' for payments in Telegram Stars
     * @param totalAmount Total price in the smallest units of the currency (integer, not
     *     float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp
     *     parameter in currencies.json, it shows the number of digits past the decimal point for
     *     each currency (2 for the majority of currencies).
     * @param invoicePayload Bot-specified invoice payload
     * @param shippingOptionId Identifier of the shipping option chosen by the user
     * @param orderInfo Order information provided by the user
     */
    @JsonCreator
    public PreCheckoutQuery(
            @JsonProperty("id") String id,
            @JsonProperty("from") User from,
            @JsonProperty("currency") String currency,
            @JsonProperty("total_amount") long totalAmount,
            @JsonProperty("invoice_payload") String invoicePayload,
            @JsonProperty("shipping_option_id") @Nullable String shippingOptionId,
            @JsonProperty("order_info") @Nullable OrderInfo orderInfo) {
        this.id = id;
        this.from = from;
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.invoicePayload = invoicePayload;
        this.shippingOptionId = shippingOptionId;
        this.orderInfo = orderInfo;
    }

    public static PreCheckoutQuery of(String id, User from, String currency, long totalAmount, String invoicePayload) {
        return new PreCheckoutQuery(id, from, currency, totalAmount, invoicePayload, null, null);
    }

    /**
     * Unique query identifier
     */
    public String id() {
        return id;
    }

    /**
     * User who sent the query
     */
    public User from() {
        return from;
    }

    /**
     * Three-letter ISO 4217 currency code, or 'XTR' for payments in Telegram Stars
     */
    public String currency() {
        return currency;
    }

    /**
     * Total price in the smallest units of the currency (integer, not float/double). For example,
     * for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows
     * the number of digits past the decimal point for each currency (2 for the majority of
     * currencies).
     */
    public long totalAmount() {
        return totalAmount;
    }

    /**
     * Bot-specified invoice payload
     */
    public String invoicePayload() {
        return invoicePayload;
    }

    /**
     * Identifier of the shipping option chosen by the user
     */
    public @Nullable String shippingOptionId() {
        return shippingOptionId;
    }

    /**
     * Order information provided by the user
     */
    public @Nullable OrderInfo orderInfo() {
        return orderInfo;
    }

    public PreCheckoutQuery withId(String id) {
        return new PreCheckoutQuery(id, from, currency, totalAmount, invoicePayload, shippingOptionId, orderInfo);
    }

    public PreCheckoutQuery withFrom(User from) {
        return new PreCheckoutQuery(id, from, currency, totalAmount, invoicePayload, shippingOptionId, orderInfo);
    }

    public PreCheckoutQuery withCurrency(String currency) {
        return new PreCheckoutQuery(id, from, currency, totalAmount, invoicePayload, shippingOptionId, orderInfo);
    }

    public PreCheckoutQuery withTotalAmount(long totalAmount) {
        return new PreCheckoutQuery(id, from, currency, totalAmount, invoicePayload, shippingOptionId, orderInfo);
    }

    public PreCheckoutQuery withInvoicePayload(String invoicePayload) {
        return new PreCheckoutQuery(id, from, currency, totalAmount, invoicePayload, shippingOptionId, orderInfo);
    }

    public PreCheckoutQuery withShippingOptionId(@Nullable String shippingOptionId) {
        return new PreCheckoutQuery(id, from, currency, totalAmount, invoicePayload, shippingOptionId, orderInfo);
    }

    public PreCheckoutQuery withOrderInfo(@Nullable OrderInfo orderInfo) {
        return new PreCheckoutQuery(id, from, currency, totalAmount, invoicePayload, shippingOptionId, orderInfo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PreCheckoutQuery)) {
            return false;
        }
        PreCheckoutQuery that = (PreCheckoutQuery) o;
        return Objects.equals(this.id, that.id)
                && Objects.equals(this.from, that.from)
                && Objects.equals(this.currency, that.currency)
                && this.totalAmount == that.totalAmount
                && Objects.equals(this.invoicePayload, that.invoicePayload)
                && Objects.equals(this.shippingOptionId, that.shippingOptionId)
                && Objects.equals(this.orderInfo, that.orderInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.from, this.currency, this.totalAmount, this.invoicePayload, this.shippingOptionId, this.orderInfo);
    }

    @Override
    public String toString() {
        return "PreCheckoutQuery[id=" + this.id
                + ", from=" + this.from
                + ", currency=" + this.currency
                + ", totalAmount=" + this.totalAmount
                + ", invoicePayload=" + this.invoicePayload
                + ", shippingOptionId=" + this.shippingOptionId
                + ", orderInfo=" + this.orderInfo
                + "]";
    }
}
