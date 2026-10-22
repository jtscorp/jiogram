package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about the quoted part of a message that is replied to by the
 * given message.
 *
 * @see <a href="https://core.telegram.org/bots/api#textquote">TextQuote in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class TextQuote {

    @JsonProperty("text")
    private final String text;

    @JsonProperty("entities")
    private final @Nullable List<MessageEntity> entities;

    @JsonProperty("position")
    private final long position;

    @JsonProperty("is_manual")
    private final @Nullable Boolean isManual;

    /**
     * Creates a new {@code TextQuote} instance.
     *
     * @param text Text of the quoted part of a message that is replied to by the given message
     * @param entities Special entities that appear in the quote. Currently, only bold, italic,
     *     underline, strikethrough, spoiler, custom_emoji, and date_time entities are kept in
     *     quotes.
     * @param position Approximate quote position in the original message in UTF-16 code units as
     *     specified by the sender
     * @param isManual True, if the quote was chosen manually by the message sender. Otherwise, the
     *     quote was added automatically by the server.
     */
    @JsonCreator
    public TextQuote(
            @JsonProperty("text") String text,
            @JsonProperty("entities") @Nullable List<MessageEntity> entities,
            @JsonProperty("position") long position,
            @JsonProperty("is_manual") @Nullable Boolean isManual) {
        this.text = text;
        this.entities = entities;
        this.position = position;
        this.isManual = isManual;
    }

    public static TextQuote of(String text, long position) {
        return new TextQuote(text, null, position, null);
    }

    /**
     * Text of the quoted part of a message that is replied to by the given message
     */
    public String text() {
        return text;
    }

    /**
     * Special entities that appear in the quote. Currently, only bold, italic, underline,
     * strikethrough, spoiler, custom_emoji, and date_time entities are kept in quotes.
     */
    public @Nullable List<MessageEntity> entities() {
        return entities;
    }

    /**
     * Approximate quote position in the original message in UTF-16 code units as specified by the
     * sender
     */
    public long position() {
        return position;
    }

    /**
     * True, if the quote was chosen manually by the message sender. Otherwise, the quote was added
     * automatically by the server.
     */
    public @Nullable Boolean isManual() {
        return isManual;
    }

    public TextQuote withText(String text) {
        return new TextQuote(text, entities, position, isManual);
    }

    public TextQuote withEntities(@Nullable List<MessageEntity> entities) {
        return new TextQuote(text, entities, position, isManual);
    }

    public TextQuote withPosition(long position) {
        return new TextQuote(text, entities, position, isManual);
    }

    public TextQuote withIsManual(@Nullable Boolean isManual) {
        return new TextQuote(text, entities, position, isManual);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TextQuote)) {
            return false;
        }
        TextQuote that = (TextQuote) o;
        return Objects.equals(this.text, that.text)
                && Objects.equals(this.entities, that.entities)
                && this.position == that.position
                && Objects.equals(this.isManual, that.isManual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.entities, this.position, this.isManual);
    }

    @Override
    public String toString() {
        return "TextQuote[text=" + this.text
                + ", entities=" + this.entities
                + ", position=" + this.position
                + ", isManual=" + this.isManual
                + "]";
    }
}
