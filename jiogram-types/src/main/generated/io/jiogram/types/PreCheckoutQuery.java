package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OrderInfo;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about an incoming pre-checkout query.
 *
 * @param id Unique query identifier
 * @param from User who sent the query
 * @param currency Three-letter ISO 4217 currency code, or 'XTR' for payments in Telegram Stars
 * @param totalAmount Total price in the smallest units of the currency (integer, not float/double).
 *     For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in
 *     currencies.json, it shows the number of digits past the decimal point for each currency (2
 *     for the majority of currencies).
 * @param invoicePayload Bot-specified invoice payload
 * @param shippingOptionId Identifier of the shipping option chosen by the user
 * @param orderInfo Order information provided by the user
 * @see <a href="https://core.telegram.org/bots/api#precheckoutquery">PreCheckoutQuery in the Bot API</a>
 */
public record PreCheckoutQuery(
    @JsonProperty("id") String id,
    @JsonProperty("from") User from,
    @JsonProperty("currency") String currency,
    @JsonProperty("total_amount") long totalAmount,
    @JsonProperty("invoice_payload") String invoicePayload,
    @JsonProperty("shipping_option_id") @Nullable String shippingOptionId,
    @JsonProperty("order_info") @Nullable OrderInfo orderInfo
) {

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
}
