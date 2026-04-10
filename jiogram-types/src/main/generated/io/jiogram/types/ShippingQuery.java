package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ShippingAddress;
import io.jiogram.types.User;

public class ShippingQuery {
    @JsonProperty("id") private final String id;
    @JsonProperty("from") private final User from;
    @JsonProperty("invoice_payload") private final String invoicePayload;
    @JsonProperty("shipping_address") private final ShippingAddress shippingAddress;

    @JsonCreator
    public ShippingQuery(
            @JsonProperty("id") String id,
            @JsonProperty("from") User from,
            @JsonProperty("invoice_payload") String invoicePayload,
            @JsonProperty("shipping_address") ShippingAddress shippingAddress
    ) {
        this.id = id;
        this.from = from;
        this.invoicePayload = invoicePayload;
        this.shippingAddress = shippingAddress;
    }

    public String id() {
        return this.id;
    }

    public User from() {
        return this.from;
    }

    public String invoicePayload() {
        return this.invoicePayload;
    }

    public ShippingAddress shippingAddress() {
        return this.shippingAddress;
    }
}
