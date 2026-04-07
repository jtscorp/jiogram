package io.jiogram.types;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

/**
 * Represents a parameter that can be either an {@link InputFile} or a String
 * (file_id or URL).
 */
@JsonSerialize(using = InputFileOrString.Serializer.class)
@JsonDeserialize(using = InputFileOrString.Deserializer.class)
public sealed interface InputFileOrString permits InputFileOrString.OfInputFile, InputFileOrString.OfString {

    static InputFileOrString of(InputFile file) {
        return new OfInputFile(file);
    }

    static InputFileOrString of(String fileIdOrUrl) {
        return new OfString(fileIdOrUrl);
    }

    record OfInputFile(InputFile file) implements InputFileOrString {}
    record OfString(String value) implements InputFileOrString {}

    final class Serializer extends JsonSerializer<InputFileOrString> {
        @Override
        public void serialize(InputFileOrString value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            // Traditional instanceof + cast: kept Java 17-compatible (no record
            // patterns, no pattern instanceof binding). The sealed interface
            // guarantees exhaustiveness; the trailing else is defensive only.
            if (value instanceof OfInputFile) {
                OfInputFile oi = (OfInputFile) value;
                gen.writeObject(oi.file());
            } else if (value instanceof OfString) {
                OfString os = (OfString) value;
                gen.writeString(os.value());
            } else {
                throw new IllegalStateException("Unknown InputFileOrString variant: " + value);
            }
        }
    }

    final class Deserializer extends JsonDeserializer<InputFileOrString> {
        @Override
        public InputFileOrString deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return switch (p.currentToken()) {
                case VALUE_STRING -> new OfString(p.getText());
                default -> new OfInputFile(ctxt.readValue(p, InputFile.class));
            };
        }
    }
}
