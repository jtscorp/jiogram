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
import java.util.Objects;

/**
 * Represents a parameter that can be either an {@link InputFile} or a String
 * (file_id or URL).
 * <p>
 * The only implementations are {@link OfInputFile} and {@link OfString}.
 */
@JsonSerialize(using = InputFileOrString.Serializer.class)
@JsonDeserialize(using = InputFileOrString.Deserializer.class)
public interface InputFileOrString {

    static InputFileOrString of(InputFile file) {
        return new OfInputFile(file);
    }

    static InputFileOrString of(String fileIdOrUrl) {
        return new OfString(fileIdOrUrl);
    }

    /**
     * A file to upload.
     */
    final class OfInputFile implements InputFileOrString {

        private final InputFile file;

        public OfInputFile(InputFile file) {
            this.file = file;
        }

        public InputFile file() {
            return file;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof OfInputFile && Objects.equals(((OfInputFile) o).file, file);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(file);
        }

        @Override
        public String toString() {
            return "OfInputFile[file=" + file + "]";
        }
    }

    /**
     * A file_id or URL of a file Telegram already has or can fetch.
     */
    final class OfString implements InputFileOrString {

        private final String value;

        public OfString(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof OfString && Objects.equals(((OfString) o).value, value);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return "OfString[value=" + value + "]";
        }
    }

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
