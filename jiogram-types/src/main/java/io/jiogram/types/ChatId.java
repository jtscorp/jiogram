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
 * Represents a Telegram chat identifier, which can be either a numeric ID or a
 * string username (e.g. {@code "@channelusername"}).
 */
@JsonSerialize(using = ChatId.Serializer.class)
@JsonDeserialize(using = ChatId.Deserializer.class)
public sealed interface ChatId permits ChatId.OfLong, ChatId.OfString {

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

    record OfLong(long id) implements ChatId {}
    record OfString(String username) implements ChatId {}

    final class Serializer extends JsonSerializer<ChatId> {
        @Override
        public void serialize(ChatId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            // Traditional instanceof + cast: kept Java 17-compatible (no record
            // patterns, no pattern instanceof binding). The sealed interface
            // guarantees exhaustiveness; the trailing else is defensive only.
            if (value instanceof OfLong) {
                OfLong ol = (OfLong) value;
                gen.writeNumber(ol.id());
            } else if (value instanceof OfString) {
                OfString os = (OfString) value;
                gen.writeString(os.username());
            } else {
                throw new IllegalStateException("Unknown ChatId variant: " + value);
            }
        }
    }

    final class Deserializer extends JsonDeserializer<ChatId> {
        @Override
        public ChatId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return switch (p.currentToken()) {
                case VALUE_NUMBER_INT -> new OfLong(p.getLongValue());
                case VALUE_STRING -> new OfString(p.getText());
                default -> throw ctxt.weirdStringException(p.getText(), ChatId.class,
                        "Expected number or string for ChatId");
            };
        }
    }
}
