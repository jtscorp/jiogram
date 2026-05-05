package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LinkPreviewOptions;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InputTextMessageContent implements InputMessageContent {
    @JsonProperty("message_text") private final String messageText;
    @JsonProperty("parse_mode") @Nullable private final ParseMode parseMode;
    @JsonProperty("entities") @Nullable private final List<MessageEntity> entities;
    @JsonProperty("link_preview_options") @Nullable private final LinkPreviewOptions linkPreviewOptions;

    @JsonCreator
    public InputTextMessageContent(
            @JsonProperty("message_text") String messageText,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("entities") @Nullable List<MessageEntity> entities,
            @JsonProperty("link_preview_options") @Nullable LinkPreviewOptions linkPreviewOptions
    ) {
        this.messageText = messageText;
        this.parseMode = parseMode;
        this.entities = entities;
        this.linkPreviewOptions = linkPreviewOptions;
    }

    public String messageText() {
        return this.messageText;
    }

    public ParseMode parseMode() {
        return this.parseMode;
    }

    public List<MessageEntity> entities() {
        return this.entities;
    }

    public LinkPreviewOptions linkPreviewOptions() {
        return this.linkPreviewOptions;
    }
}
