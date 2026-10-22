package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * A {@link RevenueWithdrawalState} variant unknown to this library version.
 * Holds the raw {@code type} value and all other fields as they were received.
 */
@JsonSerialize(using = UnknownVariant.Serializer.class)
public final class RevenueWithdrawalStateUnknown implements RevenueWithdrawalState, UnknownVariant {

    private final @Nullable String type;
    private final Map<String, Object> data;

    /**
     * Creates a new {@code RevenueWithdrawalStateUnknown} instance.
     *
     * @param type the raw discriminator value, or null if missing
     * @param data all other fields; copied, null means none
     */
    public RevenueWithdrawalStateUnknown(@Nullable String type, @Nullable Map<String, Object> data) {
        this.type = type;
        this.data = data == null ? new LinkedHashMap<>() : new LinkedHashMap<>(data);
    }

    /** Used by Jackson, which then adds the other fields with {@code addField}. */
    @JsonCreator
    private RevenueWithdrawalStateUnknown(@JsonProperty("type") @Nullable String type) {
        this(type, null);
    }

    @JsonAnySetter
    private void addField(String name, Object value) {
        data.put(name, value);
    }

    /**
     * Returns the raw {@code type} value, or null if it was missing.
     */
    public @Nullable String type() {
        return type;
    }

    @Override
    public Map<String, Object> data() {
        return Collections.unmodifiableMap(data);
    }

    @Override
    public String discriminatorName() {
        return "type";
    }

    @Override
    public @Nullable String discriminatorValue() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RevenueWithdrawalStateUnknown)) {
            return false;
        }
        RevenueWithdrawalStateUnknown that = (RevenueWithdrawalStateUnknown) o;
        return Objects.equals(this.type, that.type)
                && this.data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.data);
    }

    @Override
    public String toString() {
        return "RevenueWithdrawalStateUnknown[type=" + this.type + ", data=" + this.data + "]";
    }
}
