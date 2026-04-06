package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetBusinessAccountUsername(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("username") @Nullable String username
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setBusinessAccountUsername";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetBusinessAccountUsername of(String businessConnectionId) {
        return new SetBusinessAccountUsername(businessConnectionId, null);
    }
}
