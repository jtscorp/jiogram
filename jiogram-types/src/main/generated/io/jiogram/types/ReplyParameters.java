package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record ReplyParameters(
    @JsonProperty("message_id") long messageId,
    @JsonProperty("chat_id") @Nullable ChatId chatId,
    @JsonProperty("allow_sending_without_reply") @Nullable Boolean allowSendingWithoutReply,
    @JsonProperty("quote") @Nullable String quote,
    @JsonProperty("quote_parse_mode") @Nullable ParseMode quoteParseMode,
    @JsonProperty("quote_entities") @Nullable List<MessageEntity> quoteEntities,
    @JsonProperty("quote_position") @Nullable Long quotePosition,
    @JsonProperty("checklist_task_id") @Nullable Long checklistTaskId,
    @JsonProperty("poll_option_id") @Nullable String pollOptionId
) {}
