package io.jiogram.types;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import org.jspecify.annotations.Nullable;

import java.io.IOException;
import java.util.Map;

/**
 * Implemented by the generated {@code *Unknown} records: the fallback variant of a
 * discriminated union (e.g. {@link ChatMember}, {@link ReactionType}) for values the
 * Bot API added after this library was generated. Receiving such a value no longer
 * fails deserialization of the whole update.
 */
public interface UnknownVariant {

    /**
     * Returns the JSON name of the discriminator field (e.g. {@code "type"}, {@code "status"}).
     */
    String discriminatorName();

    /**
     * Returns the raw discriminator value as received, or null if it was missing.
     */
    @Nullable String discriminatorValue();

    /**
     * Returns all fields other than the discriminator, as received.
     */
    Map<String, Object> data();

    /**
     * Writes the variant back in its original JSON shape. The union's type id is
     * ignored: the raw discriminator value is written instead.
     */
    final class Serializer extends JsonSerializer<UnknownVariant> {
        @Override
        public void serialize(UnknownVariant value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            if (value.discriminatorValue() != null) {
                gen.writeStringField(value.discriminatorName(), value.discriminatorValue());
            }
            for (Map.Entry<String, Object> entry : value.data().entrySet()) {
                serializers.defaultSerializeField(entry.getKey(), entry.getValue(), gen);
            }
            gen.writeEndObject();
        }

        @Override
        public void serializeWithType(UnknownVariant value, JsonGenerator gen, SerializerProvider serializers,
                                      TypeSerializer typeSer) throws IOException {
            serialize(value, gen, serializers);
        }
    }
}
