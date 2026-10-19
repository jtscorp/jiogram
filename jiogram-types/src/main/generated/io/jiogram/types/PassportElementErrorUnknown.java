package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A {@link PassportElementError} variant unknown to this library version.
 * Holds the raw {@code source} value and all other fields as they were received.
 */
@JsonSerialize(using = UnknownVariant.Serializer.class)
public record PassportElementErrorUnknown(
    @JsonProperty("source") @Nullable String source,
    @JsonAnySetter Map<String, Object> data
) implements PassportElementError, UnknownVariant {

    public PassportElementErrorUnknown {
        data = data == null ? Map.of() : Collections.unmodifiableMap(new LinkedHashMap<>(data));
    }

    @Override
    public String discriminatorName() {
        return "source";
    }

    @Override
    public @Nullable String discriminatorValue() {
        return source;
    }
}
