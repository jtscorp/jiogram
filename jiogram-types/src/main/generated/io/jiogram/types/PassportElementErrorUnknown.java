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
 * A {@link PassportElementError} variant unknown to this library version.
 * Holds the raw {@code source} value and all other fields as they were received.
 */
@JsonSerialize(using = UnknownVariant.Serializer.class)
public final class PassportElementErrorUnknown implements PassportElementError, UnknownVariant {

    private final @Nullable String source;
    private final Map<String, Object> data;

    /**
     * Creates a new {@code PassportElementErrorUnknown} instance.
     *
     * @param source the raw discriminator value, or null if missing
     * @param data all other fields; copied, null means none
     */
    public PassportElementErrorUnknown(@Nullable String source, @Nullable Map<String, Object> data) {
        this.source = source;
        this.data = data == null ? new LinkedHashMap<>() : new LinkedHashMap<>(data);
    }

    /** Used by Jackson, which then adds the other fields with {@code addField}. */
    @JsonCreator
    private PassportElementErrorUnknown(@JsonProperty("source") @Nullable String source) {
        this(source, null);
    }

    @JsonAnySetter
    private void addField(String name, Object value) {
        data.put(name, value);
    }

    /**
     * Returns the raw {@code source} value, or null if it was missing.
     */
    public @Nullable String source() {
        return source;
    }

    @Override
    public Map<String, Object> data() {
        return Collections.unmodifiableMap(data);
    }

    @Override
    public String discriminatorName() {
        return "source";
    }

    @Override
    public @Nullable String discriminatorValue() {
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PassportElementErrorUnknown)) {
            return false;
        }
        PassportElementErrorUnknown that = (PassportElementErrorUnknown) o;
        return Objects.equals(this.source, that.source)
                && this.data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.source, this.data);
    }

    @Override
    public String toString() {
        return "PassportElementErrorUnknown[source=" + this.source + ", data=" + this.data + "]";
    }
}
