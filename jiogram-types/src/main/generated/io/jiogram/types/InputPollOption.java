package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about one answer option in a poll to be sent.
 *
 * @param text Option text, 1-100 characters
 * @param textParseMode Mode for parsing entities in the text. See formatting options for more
 *     details. Currently, only custom emoji entities are allowed
 * @param textEntities A JSON-serialized list of special entities that appear in the poll option
 *     text. It can be specified instead of text_parse_mode
 * @see <a href="https://core.telegram.org/bots/api#inputpolloption">InputPollOption in the Bot API</a>
 */
public record InputPollOption(
    @JsonProperty("text") String text,
    @JsonProperty("text_parse_mode") @Nullable ParseMode textParseMode,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
) {

    public InputPollOption withText(String text) {
        return new InputPollOption(text, textParseMode, textEntities);
    }

    public InputPollOption withTextParseMode(@Nullable ParseMode textParseMode) {
        return new InputPollOption(text, textParseMode, textEntities);
    }

    public InputPollOption withTextEntities(@Nullable List<MessageEntity> textEntities) {
        return new InputPollOption(text, textParseMode, textEntities);
    }
}
