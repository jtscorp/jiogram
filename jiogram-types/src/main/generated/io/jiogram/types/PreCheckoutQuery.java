package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OrderInfo;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class PreCheckoutQuery {
    @JsonProperty("id") private final String id;
    @JsonProperty("from") private final User from;
    @JsonProperty("currency") private final String currency;
    @JsonProperty("total_amount") private final long totalAmount;
    @JsonProperty("invoice_payload") private final String invoicePayload;
    @JsonProperty("shipping_option_id") @Nullable private final String shippingOptionId;
    @JsonProperty("order_info") @Nullable private final OrderInfo orderInfo;

    @JsonCreator
    public PreCheckoutQuery(
            @JsonProperty("id") String id,
            @JsonProperty("from") User from,
            @JsonProperty("currency") String currency,
            @JsonProperty("total_amount") long totalAmount,
            @JsonProperty("invoice_payload") String invoicePayload,
            @JsonProperty("shipping_option_id") @Nullable String shippingOptionId,
            @JsonProperty("order_info") @Nullable OrderInfo orderInfo
    ) {
        this.id = id;
        this.from = from;
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.invoicePayload = invoicePayload;
        this.shippingOptionId = shippingOptionId;
        this.orderInfo = orderInfo;
    }

    public String id() {
        return this.id;
    }

    public User from() {
        return this.from;
    }

    public String currency() {
        return this.currency;
    }

    public long totalAmount() {
        return this.totalAmount;
    }

    public String invoicePayload() {
        return this.invoicePayload;
    }

    public String shippingOptionId() {
        return this.shippingOptionId;
    }

    public OrderInfo orderInfo() {
        return this.orderInfo;
    }
}
