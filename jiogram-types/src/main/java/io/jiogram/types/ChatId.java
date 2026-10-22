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
 * Represents a Telegram chat identifier, which can be either a numeric ID or a
 * string username (e.g. {@code "@channelusername"}).
 * <p>
 * The only implementations are {@link OfLong} and {@link OfString}.
 */
@JsonSerialize(using = ChatId.Serializer.class)
@JsonDeserialize(using = ChatId.Deserializer.class)
public interface ChatId {

    /**
     * Creates a ChatId from a numeric ID.
     */
    static ChatId of(long id) {
        return new OfLong(id);
    }

    /**
     * Creates a ChatId from a string username.
     */
    static ChatId of(String username) {
        return new OfString(username);
    }

    /**
     * A numeric chat ID.
     */
    final class OfLong implements ChatId {

        private final long id;

        public OfLong(long id) {
            this.id = id;
        }

        public long id() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof OfLong && ((OfLong) o).id == id;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(id);
        }

        @Override
        public String toString() {
            return "OfLong[id=" + id + "]";
        }
    }

    /**
     * A chat username, e.g. {@code "@channelusername"}.
     */
    final class OfString implements ChatId {

        private final String username;

        public OfString(String username) {
            this.username = username;
        }

        public String username() {
            return username;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof OfString && Objects.equals(((OfString) o).username, username);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(username);
        }

        @Override
        public String toString() {
            return "OfString[username=" + username + "]";
        }
    }

    final class Serializer extends JsonSerializer<ChatId> {
        @Override
        public void serialize(ChatId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            if (value instanceof OfLong) {
                gen.writeNumber(((OfLong) value).id());
            } else if (value instanceof OfString) {
                gen.writeString(((OfString) value).username());
            } else {
                throw new IllegalStateException("Unknown ChatId variant: " + value);
            }
        }
    }

    final class Deserializer extends JsonDeserializer<ChatId> {
        @Override
        public ChatId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonToken token = p.currentToken();
            if (token == JsonToken.VALUE_NUMBER_INT) {
                return new OfLong(p.getLongValue());
            }
            if (token == JsonToken.VALUE_STRING) {
                return new OfString(p.getText());
            }
            throw ctxt.weirdStringException(p.getText(), ChatId.class, "Expected number or string for ChatId");
        }
    }
}
