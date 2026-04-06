package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record ChatShared(
    @JsonProperty("request_id") long requestId,
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("username") @Nullable String username,
    @JsonProperty("photo") @Nullable List<PhotoSize> photo
) {}
