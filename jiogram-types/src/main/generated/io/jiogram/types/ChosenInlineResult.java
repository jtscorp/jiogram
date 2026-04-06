package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record ChosenInlineResult(
    @JsonProperty("result_id") String resultId,
    @JsonProperty("from") User from,
    @JsonProperty("location") @Nullable Location location,
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
    @JsonProperty("query") String query
) {}
