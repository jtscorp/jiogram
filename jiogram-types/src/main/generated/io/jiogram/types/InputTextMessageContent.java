package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LinkPreviewOptions;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Represents the content of a text message to be sent as the result of an inline query.
 *
 * @param messageText Text of the message to be sent, 1-4096 characters
 * @param parseMode Mode for parsing entities in the message text. See formatting options for more
 *     details.
 * @param entities List of special entities that appear in message text, which can be specified
 *     instead of parse_mode
 * @param linkPreviewOptions Link preview generation options for the message
 * @see <a href="https://core.telegram.org/bots/api#inputtextmessagecontent">InputTextMessageContent in the Bot API</a>
 */
public record InputTextMessageContent(
    @JsonProperty("message_text") String messageText,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("entities") @Nullable List<MessageEntity> entities,
    @JsonProperty("link_preview_options") @Nullable LinkPreviewOptions linkPreviewOptions
) implements InputMessageContent {

    public static InputTextMessageContent of(String messageText) {
        return new InputTextMessageContent(messageText, null, null, null);
    }

    public InputTextMessageContent withMessageText(String messageText) {
        return new InputTextMessageContent(messageText, parseMode, entities, linkPreviewOptions);
    }

    public InputTextMessageContent withParseMode(@Nullable ParseMode parseMode) {
        return new InputTextMessageContent(messageText, parseMode, entities, linkPreviewOptions);
    }

    public InputTextMessageContent withEntities(@Nullable List<MessageEntity> entities) {
        return new InputTextMessageContent(messageText, parseMode, entities, linkPreviewOptions);
    }

    public InputTextMessageContent withLinkPreviewOptions(@Nullable LinkPreviewOptions linkPreviewOptions) {
        return new InputTextMessageContent(messageText, parseMode, entities, linkPreviewOptions);
    }
}
