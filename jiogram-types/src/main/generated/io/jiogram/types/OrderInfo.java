package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ShippingAddress;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents information about an order.
 *
 * @see <a href="https://core.telegram.org/bots/api#orderinfo">OrderInfo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class OrderInfo {

    @JsonProperty("name")
    private final @Nullable String name;

    @JsonProperty("phone_number")
    private final @Nullable String phoneNumber;

    @JsonProperty("email")
    private final @Nullable String email;

    @JsonProperty("shipping_address")
    private final @Nullable ShippingAddress shippingAddress;

    /**
     * Creates a new {@code OrderInfo} instance.
     *
     * @param name User name
     * @param phoneNumber User's phone number
     * @param email User email
     * @param shippingAddress User shipping address
     */
    @JsonCreator
    public OrderInfo(
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("phone_number") @Nullable String phoneNumber,
            @JsonProperty("email") @Nullable String email,
            @JsonProperty("shipping_address") @Nullable ShippingAddress shippingAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.shippingAddress = shippingAddress;
    }

    public static OrderInfo of() {
        return new OrderInfo(null, null, null, null);
    }

    /**
     * User name
     */
    public @Nullable String name() {
        return name;
    }

    /**
     * User's phone number
     */
    public @Nullable String phoneNumber() {
        return phoneNumber;
    }

    /**
     * User email
     */
    public @Nullable String email() {
        return email;
    }

    /**
     * User shipping address
     */
    public @Nullable ShippingAddress shippingAddress() {
        return shippingAddress;
    }

    public OrderInfo withName(@Nullable String name) {
        return new OrderInfo(name, phoneNumber, email, shippingAddress);
    }

    public OrderInfo withPhoneNumber(@Nullable String phoneNumber) {
        return new OrderInfo(name, phoneNumber, email, shippingAddress);
    }

    public OrderInfo withEmail(@Nullable String email) {
        return new OrderInfo(name, phoneNumber, email, shippingAddress);
    }

    public OrderInfo withShippingAddress(@Nullable ShippingAddress shippingAddress) {
        return new OrderInfo(name, phoneNumber, email, shippingAddress);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderInfo)) {
            return false;
        }
        OrderInfo that = (OrderInfo) o;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.phoneNumber, that.phoneNumber)
                && Objects.equals(this.email, that.email)
                && Objects.equals(this.shippingAddress, that.shippingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.phoneNumber, this.email, this.shippingAddress);
    }

    @Override
    public String toString() {
        return "OrderInfo[name=" + this.name
                + ", phoneNumber=" + this.phoneNumber
                + ", email=" + this.email
                + ", shippingAddress=" + this.shippingAddress
                + "]";
    }
}
