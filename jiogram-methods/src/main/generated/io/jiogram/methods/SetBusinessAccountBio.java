package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetBusinessAccountBio(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("bio") @Nullable String bio
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setBusinessAccountBio";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetBusinessAccountBio of(String businessConnectionId) {
        return new SetBusinessAccountBio(businessConnectionId, null);
    }
}
