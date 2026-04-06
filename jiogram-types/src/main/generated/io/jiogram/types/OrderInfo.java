package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ShippingAddress;
import org.jspecify.annotations.Nullable;

public record OrderInfo(
    @JsonProperty("name") @Nullable String name,
    @JsonProperty("phone_number") @Nullable String phoneNumber,
    @JsonProperty("email") @Nullable String email,
    @JsonProperty("shipping_address") @Nullable ShippingAddress shippingAddress
) {}
