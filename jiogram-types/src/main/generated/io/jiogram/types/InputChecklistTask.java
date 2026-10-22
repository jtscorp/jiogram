package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes a task to add to a checklist.
 *
 * @param id Unique identifier of the task; must be positive and unique among all task identifiers
 *     currently present in the checklist
 * @param text Text of the task; 1-100 characters after entities parsing
 * @param parseMode Mode for parsing entities in the text. See formatting options for more details.
 * @param textEntities List of special entities that appear in the text, which can be specified
 *     instead of parse_mode. Currently, only bold, italic, underline, strikethrough, spoiler,
 *     custom_emoji, and date_time entities are allowed.
 * @see <a href="https://core.telegram.org/bots/api#inputchecklisttask">InputChecklistTask in the Bot API</a>
 */
public record InputChecklistTask(
    @JsonProperty("id") long id,
    @JsonProperty("text") String text,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
) {

    public static InputChecklistTask of(long id, String text) {
        return new InputChecklistTask(id, text, null, null);
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
}
