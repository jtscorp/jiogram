package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class KeyboardButtonRequestManagedBot {
    @JsonProperty("request_id") private final long requestId;
    @JsonProperty("suggested_name") @Nullable private final String suggestedName;
    @JsonProperty("suggested_username") @Nullable private final String suggestedUsername;

    @JsonCreator
    public KeyboardButtonRequestManagedBot(
            @JsonProperty("request_id") long requestId,
            @JsonProperty("suggested_name") @Nullable String suggestedName,
            @JsonProperty("suggested_username") @Nullable String suggestedUsername
    ) {
        this.requestId = requestId;
        this.suggestedName = suggestedName;
        this.suggestedUsername = suggestedUsername;
    }

    public long requestId() {
        return this.requestId;
    }

    public String suggestedName() {
        return this.suggestedName;
    }

    public String suggestedUsername() {
        return this.suggestedUsername;
    }
}
