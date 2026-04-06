package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ShippingAddress;
import io.jiogram.types.User;

public record ShippingQuery(
    @JsonProperty("id") String id,
    @JsonProperty("from") User from,
    @JsonProperty("invoice_payload") String invoicePayload,
    @JsonProperty("shipping_address") ShippingAddress shippingAddress
) {}
