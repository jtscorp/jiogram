package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record TransferBusinessAccountStars(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("star_count") long starCount
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "transferBusinessAccountStars";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
