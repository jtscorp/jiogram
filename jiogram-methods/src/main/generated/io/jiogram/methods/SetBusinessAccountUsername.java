package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetBusinessAccountUsername implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("username") @Nullable private final String username;

    @JsonCreator
    public SetBusinessAccountUsername(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("username") @Nullable String username
    ) {
        this.businessConnectionId = businessConnectionId;
        this.username = username;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public String username() {
        return this.username;
    }

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
