package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetBusinessAccountName implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("first_name") private final String firstName;
    @JsonProperty("last_name") @Nullable private final String lastName;

    @JsonCreator
    public SetBusinessAccountName(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") @Nullable String lastName
    ) {
        this.businessConnectionId = businessConnectionId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public String firstName() {
        return this.firstName;
    }

    public String lastName() {
        return this.lastName;
    }

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
