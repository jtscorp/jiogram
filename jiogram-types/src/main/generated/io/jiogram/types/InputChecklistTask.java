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
 * Describes a task to add to a checklist.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputchecklisttask">InputChecklistTask in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputChecklistTask {

    @JsonProperty("id")
    private final long id;

    @JsonProperty("text")
    private final String text;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("text_entities")
    private final @Nullable List<MessageEntity> textEntities;

    /**
     * Creates a new {@code InputChecklistTask} instance.
     *
     * @param id Unique identifier of the task; must be positive and unique among all task
     *     identifiers currently present in the checklist
     * @param text Text of the task; 1-100 characters after entities parsing
     * @param parseMode Mode for parsing entities in the text. See formatting options for more
     *     details.
     * @param textEntities List of special entities that appear in the text, which can be specified
     *     instead of parse_mode. Currently, only bold, italic, underline, strikethrough, spoiler,
     *     custom_emoji, and date_time entities are allowed.
     */
    @JsonCreator
    public InputChecklistTask(
            @JsonProperty("id") long id,
            @JsonProperty("text") String text,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities) {
        this.id = id;
        this.text = text;
        this.parseMode = parseMode;
        this.textEntities = textEntities;
    }

    public static InputChecklistTask of(long id, String text) {
        return new InputChecklistTask(id, text, null, null);
    }

    /**
     * Unique identifier of the task; must be positive and unique among all task identifiers
     * currently present in the checklist
     */
    public long id() {
        return id;
    }

    /**
     * Text of the task; 1-100 characters after entities parsing
     */
    public String text() {
        return text;
    }

    /**
     * Mode for parsing entities in the text. See formatting options for more details.
     */
    public @Nullable ParseMode parseMode() {
        return parseMode;
    }

    /**
     * List of special entities that appear in the text, which can be specified instead of
     * parse_mode. Currently, only bold, italic, underline, strikethrough, spoiler, custom_emoji,
     * and date_time entities are allowed.
     */
    public @Nullable List<MessageEntity> textEntities() {
        return textEntities;
    }

    public InputChecklistTask withId(long id) {
        return new InputChecklistTask(id, text, parseMode, textEntities);
    }

    public InputChecklistTask withText(String text) {
        return new InputChecklistTask(id, text, parseMode, textEntities);
    }

    public InputChecklistTask withParseMode(@Nullable ParseMode parseMode) {
        return new InputChecklistTask(id, text, parseMode, textEntities);
    }

    public InputChecklistTask withTextEntities(@Nullable List<MessageEntity> textEntities) {
        return new InputChecklistTask(id, text, parseMode, textEntities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputChecklistTask)) {
            return false;
        }
        InputChecklistTask that = (InputChecklistTask) o;
        return this.id == that.id
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.textEntities, that.textEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.text, this.parseMode, this.textEntities);
    }

    @Override
    public String toString() {
        return "InputChecklistTask[id=" + this.id
                + ", text=" + this.text
                + ", parseMode=" + this.parseMode
                + ", textEntities=" + this.textEntities
                + "]";
    }
}
