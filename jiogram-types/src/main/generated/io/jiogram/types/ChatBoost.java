package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSource;

public class ChatBoost {
    @JsonProperty("boost_id") private final String boostId;
    @JsonProperty("add_date") private final long addDate;
    @JsonProperty("expiration_date") private final long expirationDate;
    @JsonProperty("source") private final ChatBoostSource source;

    @JsonCreator
    public ChatBoost(
            @JsonProperty("boost_id") String boostId,
            @JsonProperty("add_date") long addDate,
            @JsonProperty("expiration_date") long expirationDate,
            @JsonProperty("source") ChatBoostSource source
    ) {
        this.boostId = boostId;
        this.addDate = addDate;
        this.expirationDate = expirationDate;
        this.source = source;
    }

    public String boostId() {
        return this.boostId;
    }

    public long addDate() {
        return this.addDate;
    }

    public long expirationDate() {
        return this.expirationDate;
    }

    public ChatBoostSource source() {
        return this.source;
    }
}
