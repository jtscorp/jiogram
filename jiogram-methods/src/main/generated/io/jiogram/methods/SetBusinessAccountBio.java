package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetBusinessAccountBio implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("bio") @Nullable private final String bio;

    @JsonCreator
    public SetBusinessAccountBio(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("bio") @Nullable String bio
    ) {
        this.businessConnectionId = businessConnectionId;
        this.bio = bio;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public String bio() {
        return this.bio;
    }

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
