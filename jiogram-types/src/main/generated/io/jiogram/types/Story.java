package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;

public record Story(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("id") long id
) {}
