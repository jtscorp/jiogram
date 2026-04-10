package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ShippingAddress;
import org.jspecify.annotations.Nullable;

public class OrderInfo {
    @JsonProperty("name") @Nullable private final String name;
    @JsonProperty("phone_number") @Nullable private final String phoneNumber;
    @JsonProperty("email") @Nullable private final String email;
    @JsonProperty("shipping_address") @Nullable private final ShippingAddress shippingAddress;

    @JsonCreator
    public OrderInfo(
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("phone_number") @Nullable String phoneNumber,
            @JsonProperty("email") @Nullable String email,
            @JsonProperty("shipping_address") @Nullable ShippingAddress shippingAddress
    ) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.shippingAddress = shippingAddress;
    }

    public String name() {
        return this.name;
    }

    public String phoneNumber() {
        return this.phoneNumber;
    }

    public String email() {
        return this.email;
    }

    public ShippingAddress shippingAddress() {
        return this.shippingAddress;
    }
}
