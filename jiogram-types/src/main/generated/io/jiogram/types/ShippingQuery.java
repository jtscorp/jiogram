package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ShippingAddress;
import io.jiogram.types.User;

/**
 * This object contains information about an incoming shipping query.
 *
 * @param id Unique query identifier
 * @param from User who sent the query
 * @param invoicePayload Bot-specified invoice payload
 * @param shippingAddress User specified shipping address
 * @see <a href="https://core.telegram.org/bots/api#shippingquery">ShippingQuery in the Bot API</a>
 */
public record ShippingQuery(
    @JsonProperty("id") String id,
    @JsonProperty("from") User from,
    @JsonProperty("invoice_payload") String invoicePayload,
    @JsonProperty("shipping_address") ShippingAddress shippingAddress
) {}
