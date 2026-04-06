package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetBusinessAccountName(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("first_name") String firstName,
    @JsonProperty("last_name") @Nullable String lastName
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setBusinessAccountName";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetBusinessAccountName of(String businessConnectionId, String firstName) {
        return new SetBusinessAccountName(businessConnectionId, firstName, null);
    }
}
