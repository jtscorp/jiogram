package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ShippingAddress;
import org.jspecify.annotations.Nullable;

/**
 * This object represents information about an order.
 *
 * @param name User name
 * @param phoneNumber User's phone number
 * @param email User email
 * @param shippingAddress User shipping address
 * @see <a href="https://core.telegram.org/bots/api#orderinfo">OrderInfo in the Bot API</a>
 */
public record OrderInfo(
    @JsonProperty("name") @Nullable String name,
    @JsonProperty("phone_number") @Nullable String phoneNumber,
    @JsonProperty("email") @Nullable String email,
    @JsonProperty("shipping_address") @Nullable ShippingAddress shippingAddress
) {}
