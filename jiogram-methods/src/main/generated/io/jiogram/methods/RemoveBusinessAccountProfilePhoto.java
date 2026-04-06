package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record RemoveBusinessAccountProfilePhoto(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("is_public") @Nullable Boolean isPublic
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "removeBusinessAccountProfilePhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static RemoveBusinessAccountProfilePhoto of(String businessConnectionId) {
        return new RemoveBusinessAccountProfilePhoto(businessConnectionId, null);
    }
}
