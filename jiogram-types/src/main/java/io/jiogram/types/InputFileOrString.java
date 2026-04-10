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
            if (this == o) return true;
            if (!(o instanceof OfInputFile)) return false;
            OfInputFile other = (OfInputFile) o;
            return Objects.equals(file, other.file);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(file);
        }

        @Override
        public String toString() {
            return "InputFileOrString.OfInputFile[file=" + file + "]";
        }
    }

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
            if (this == o) return true;
            if (!(o instanceof OfString)) return false;
            OfString other = (OfString) o;
            return Objects.equals(value, other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return "InputFileOrString.OfString[value=" + value + "]";
        }
    }

    final class Serializer extends JsonSerializer<InputFileOrString> {
        @Override
        public void serialize(InputFileOrString value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
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
            if (p.currentToken() == JsonToken.VALUE_STRING) {
                return new OfString(p.getText());
            } else {
                return new OfInputFile(ctxt.readValue(p, InputFile.class));
            }
        }
    }
}
