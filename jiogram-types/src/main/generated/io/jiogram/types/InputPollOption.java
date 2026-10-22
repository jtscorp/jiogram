package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about one answer option in a poll to be sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputpolloption">InputPollOption in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputPollOption {

    @JsonProperty("text")
    private final String text;

    @JsonProperty("text_parse_mode")
    private final @Nullable ParseMode textParseMode;

    @JsonProperty("text_entities")
    private final @Nullable List<MessageEntity> textEntities;

    /**
     * Creates a new {@code InputPollOption} instance.
     *
     * @param text Option text, 1-100 characters
     * @param textParseMode Mode for parsing entities in the text. See formatting options for more
     *     details. Currently, only custom emoji entities are allowed
     * @param textEntities A JSON-serialized list of special entities that appear in the poll option
     *     text. It can be specified instead of text_parse_mode
     */
    @JsonCreator
    public InputPollOption(
            @JsonProperty("text") String text,
            @JsonProperty("text_parse_mode") @Nullable ParseMode textParseMode,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities) {
        this.text = text;
        this.textParseMode = textParseMode;
        this.textEntities = textEntities;
    }

    public static InputPollOption of(String text) {
        return new InputPollOption(text, null, null);
    }

    /**
     * Option text, 1-100 characters
     */
    public String text() {
        return text;
    }

    /**
     * Mode for parsing entities in the text. See formatting options for more details. Currently,
     * only custom emoji entities are allowed
     */
    public @Nullable ParseMode textParseMode() {
        return textParseMode;
    }

    /**
     * A JSON-serialized list of special entities that appear in the poll option text. It can be
     * specified instead of text_parse_mode
     */
    public @Nullable List<MessageEntity> textEntities() {
        return textEntities;
    }

    public InputPollOption withText(String text) {
        return new InputPollOption(text, textParseMode, textEntities);
    }

    public InputPollOption withTextParseMode(@Nullable ParseMode textParseMode) {
        return new InputPollOption(text, textParseMode, textEntities);
    }

    public InputPollOption withTextEntities(@Nullable List<MessageEntity> textEntities) {
        return new InputPollOption(text, textParseMode, textEntities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputPollOption)) {
            return false;
        }
        InputPollOption that = (InputPollOption) o;
        return Objects.equals(this.text, that.text)
                && Objects.equals(this.textParseMode, that.textParseMode)
                && Objects.equals(this.textEntities, that.textEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.textParseMode, this.textEntities);
    }

    @Override
    public String toString() {
        return "InputPollOption[text=" + this.text
                + ", textParseMode=" + this.textParseMode
                + ", textEntities=" + this.textEntities
                + "]";
    }
}
