package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.WebAppInfo;
import org.jspecify.annotations.Nullable;

public record InlineQueryResultsButton(
    @JsonProperty("text") String text,
    @JsonProperty("web_app") @Nullable WebAppInfo webApp,
    @JsonProperty("start_parameter") @Nullable String startParameter
) {}
