package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LinkPreviewOptions;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents the content of a text message to be sent as the result of an inline query.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputtextmessagecontent">InputTextMessageContent in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputTextMessageContent implements InputMessageContent {

    @JsonProperty("message_text")
    private final String messageText;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("entities")
    private final @Nullable List<MessageEntity> entities;

    @JsonProperty("link_preview_options")
    private final @Nullable LinkPreviewOptions linkPreviewOptions;

    /**
     * Creates a new {@code InputTextMessageContent} instance.
     *
     * @param messageText Text of the message to be sent, 1-4096 characters
     * @param parseMode Mode for parsing entities in the message text. See formatting options for
     *     more details.
     * @param entities List of special entities that appear in message text, which can be specified
     *     instead of parse_mode
     * @param linkPreviewOptions Link preview generation options for the message
     */
    @JsonCreator
    public InputTextMessageContent(
            @JsonProperty("message_text") String messageText,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("entities") @Nullable List<MessageEntity> entities,
            @JsonProperty("link_preview_options") @Nullable LinkPreviewOptions linkPreviewOptions) {
        this.messageText = messageText;
        this.parseMode = parseMode;
        this.entities = entities;
        this.linkPreviewOptions = linkPreviewOptions;
    }

    public static InputTextMessageContent of(String messageText) {
        return new InputTextMessageContent(messageText, null, null, null);
    }

    /**
     * Text of the message to be sent, 1-4096 characters
     */
    public String messageText() {
        return messageText;
    }

    /**
     * Mode for parsing entities in the message text. See formatting options for more details.
     */
    public @Nullable ParseMode parseMode() {
        return parseMode;
    }

    /**
     * List of special entities that appear in message text, which can be specified instead of
     * parse_mode
     */
    public @Nullable List<MessageEntity> entities() {
        return entities;
    }

    /**
     * Link preview generation options for the message
     */
    public @Nullable LinkPreviewOptions linkPreviewOptions() {
        return linkPreviewOptions;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputTextMessageContent)) {
            return false;
        }
        InputTextMessageContent that = (InputTextMessageContent) o;
        return Objects.equals(this.messageText, that.messageText)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.entities, that.entities)
                && Objects.equals(this.linkPreviewOptions, that.linkPreviewOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.messageText, this.parseMode, this.entities, this.linkPreviewOptions);
    }

    @Override
    public String toString() {
        return "InputTextMessageContent[messageText=" + this.messageText
                + ", parseMode=" + this.parseMode
                + ", entities=" + this.entities
                + ", linkPreviewOptions=" + this.linkPreviewOptions
                + "]";
    }
}
