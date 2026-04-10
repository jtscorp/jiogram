package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PreparedInlineMessage {
    @JsonProperty("id") private final String id;
    @JsonProperty("expiration_date") private final long expirationDate;

    @JsonCreator
    public PreparedInlineMessage(
            @JsonProperty("id") String id,
            @JsonProperty("expiration_date") long expirationDate
    ) {
        this.id = id;
        this.expirationDate = expirationDate;
    }

    public String id() {
        return this.id;
    }

    public long expirationDate() {
        return this.expirationDate;
    }
}
