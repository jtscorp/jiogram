package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record MessageEntity(
    @JsonProperty("type") String type,
    @JsonProperty("offset") long offset,
    @JsonProperty("length") long length,
    @JsonProperty("url") @Nullable String url,
    @JsonProperty("user") @Nullable User user,
    @JsonProperty("language") @Nullable String language,
    @JsonProperty("custom_emoji_id") @Nullable String customEmojiId,
    @JsonProperty("unix_time") @Nullable Long unixTime,
    @JsonProperty("date_time_format") @Nullable String dateTimeFormat
) {}
