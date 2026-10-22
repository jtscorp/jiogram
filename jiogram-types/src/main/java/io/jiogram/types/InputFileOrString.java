package io.jiogram.types;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
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
            if (value instanceof OfInputFile) {
                // Through the provider (not gen.writeObject) so InputFile.Serializer
                // sees the session's InputFile.Attachments attribute.
                serializers.defaultSerializeValue(((OfInputFile) value).file(), gen);
            } else {
                gen.writeString(((OfString) value).value());
            }
        }
    }

    final class Deserializer extends JsonDeserializer<InputFileOrString> {
        @Override
        public InputFileOrString deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            // Telegram only ever sends file_id / URL strings; an upload never comes back.
            if (p.currentToken() != JsonToken.VALUE_STRING) {
                return ctxt.reportInputMismatch(InputFileOrString.class,
                    "Expected a file_id or URL string, got %s", p.currentToken());
            }
            return new OfString(p.getText());
        }
    }
}
