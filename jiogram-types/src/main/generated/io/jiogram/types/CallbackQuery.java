package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaybeInaccessibleMessage;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record CallbackQuery(
    @JsonProperty("id") String id,
    @JsonProperty("from") User from,
    @JsonProperty("message") @Nullable MaybeInaccessibleMessage message,
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
    @JsonProperty("chat_instance") String chatInstance,
    @JsonProperty("data") @Nullable String data,
    @JsonProperty("game_short_name") @Nullable String gameShortName
) {}
