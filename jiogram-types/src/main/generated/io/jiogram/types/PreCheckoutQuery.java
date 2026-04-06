package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OrderInfo;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record PreCheckoutQuery(
    @JsonProperty("id") String id,
    @JsonProperty("from") User from,
    @JsonProperty("currency") String currency,
    @JsonProperty("total_amount") long totalAmount,
    @JsonProperty("invoice_payload") String invoicePayload,
    @JsonProperty("shipping_option_id") @Nullable String shippingOptionId,
    @JsonProperty("order_info") @Nullable OrderInfo orderInfo
) {}
