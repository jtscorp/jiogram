package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class ResponseParameters {
    @JsonProperty("migrate_to_chat_id") @Nullable private final Long migrateToChatId;
    @JsonProperty("retry_after") @Nullable private final Long retryAfter;

    @JsonCreator
    public ResponseParameters(
            @JsonProperty("migrate_to_chat_id") @Nullable Long migrateToChatId,
            @JsonProperty("retry_after") @Nullable Long retryAfter
    ) {
        this.migrateToChatId = migrateToChatId;
        this.retryAfter = retryAfter;
    }

    public Long migrateToChatId() {
        return this.migrateToChatId;
    }

    public Long retryAfter() {
        return this.retryAfter;
    }
}
