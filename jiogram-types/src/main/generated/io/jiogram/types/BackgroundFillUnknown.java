package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A {@link BackgroundFill} variant unknown to this library version.
 * Holds the raw {@code type} value and all other fields as they were received.
 */
@JsonSerialize(using = UnknownVariant.Serializer.class)
public record BackgroundFillUnknown(
    @JsonProperty("type") @Nullable String type,
    @JsonAnySetter Map<String, Object> data
) implements BackgroundFill, UnknownVariant {

    public BackgroundFillUnknown {
        data = data == null ? Map.of() : Collections.unmodifiableMap(new LinkedHashMap<>(data));
    }

    @Override
    public String discriminatorName() {
        return "type";
    }

    @Override
    public @Nullable String discriminatorValue() {
        return type;
    }
}
