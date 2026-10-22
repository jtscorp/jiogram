package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ShippingAddress;
import io.jiogram.types.User;
import java.util.Objects;

/**
 * This object contains information about an incoming shipping query.
 *
 * @see <a href="https://core.telegram.org/bots/api#shippingquery">ShippingQuery in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ShippingQuery {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("from")
    private final User from;

    @JsonProperty("invoice_payload")
    private final String invoicePayload;

    @JsonProperty("shipping_address")
    private final ShippingAddress shippingAddress;

    /**
     * Creates a new {@code ShippingQuery} instance.
     *
     * @param id Unique query identifier
     * @param from User who sent the query
     * @param invoicePayload Bot-specified invoice payload
     * @param shippingAddress User specified shipping address
     */
    @JsonCreator
    public ShippingQuery(
            @JsonProperty("id") String id,
            @JsonProperty("from") User from,
            @JsonProperty("invoice_payload") String invoicePayload,
            @JsonProperty("shipping_address") ShippingAddress shippingAddress) {
        this.id = id;
        this.from = from;
        this.invoicePayload = invoicePayload;
        this.shippingAddress = shippingAddress;
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
     * Bot-specified invoice payload
     */
    public String invoicePayload() {
        return invoicePayload;
    }

    /**
     * User specified shipping address
     */
    public ShippingAddress shippingAddress() {
        return shippingAddress;
    }

    public ShippingQuery withId(String id) {
        return new ShippingQuery(id, from, invoicePayload, shippingAddress);
    }

    public ShippingQuery withFrom(User from) {
        return new ShippingQuery(id, from, invoicePayload, shippingAddress);
    }

    public ShippingQuery withInvoicePayload(String invoicePayload) {
        return new ShippingQuery(id, from, invoicePayload, shippingAddress);
    }

    public ShippingQuery withShippingAddress(ShippingAddress shippingAddress) {
        return new ShippingQuery(id, from, invoicePayload, shippingAddress);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShippingQuery)) {
            return false;
        }
        ShippingQuery that = (ShippingQuery) o;
        return Objects.equals(this.id, that.id)
                && Objects.equals(this.from, that.from)
                && Objects.equals(this.invoicePayload, that.invoicePayload)
                && Objects.equals(this.shippingAddress, that.shippingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.from, this.invoicePayload, this.shippingAddress);
    }

    @Override
    public String toString() {
        return "ShippingQuery[id=" + this.id
                + ", from=" + this.from
                + ", invoicePayload=" + this.invoicePayload
                + ", shippingAddress=" + this.shippingAddress
                + "]";
    }
}
