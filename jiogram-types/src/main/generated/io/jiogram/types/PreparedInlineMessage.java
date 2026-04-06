package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PreparedInlineMessage(
    @JsonProperty("id") String id,
    @JsonProperty("expiration_date") long expirationDate
) {}
