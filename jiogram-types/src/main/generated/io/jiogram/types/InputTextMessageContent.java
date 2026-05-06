package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LinkPreviewOptions;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record InputTextMessageContent(
    @JsonProperty("message_text") String messageText,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("entities") @Nullable List<MessageEntity> entities,
    @JsonProperty("link_preview_options") @Nullable LinkPreviewOptions linkPreviewOptions
) implements InputMessageContent {}
