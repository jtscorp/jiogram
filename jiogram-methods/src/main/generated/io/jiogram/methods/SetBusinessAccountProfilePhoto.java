package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputProfilePhoto;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetBusinessAccountProfilePhoto(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("photo") InputProfilePhoto photo,
    @JsonProperty("is_public") @Nullable Boolean isPublic
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setBusinessAccountProfilePhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetBusinessAccountProfilePhoto of(String businessConnectionId, InputProfilePhoto photo) {
        return new SetBusinessAccountProfilePhoto(businessConnectionId, photo, null);
    }
}
