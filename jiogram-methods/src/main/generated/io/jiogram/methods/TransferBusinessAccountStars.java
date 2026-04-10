package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class TransferBusinessAccountStars implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("star_count") private final long starCount;

    @JsonCreator
    public TransferBusinessAccountStars(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("star_count") long starCount
    ) {
        this.businessConnectionId = businessConnectionId;
        this.starCount = starCount;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public long starCount() {
        return this.starCount;
    }

    @Override
    public String apiMethod() {
        return "transferBusinessAccountStars";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
