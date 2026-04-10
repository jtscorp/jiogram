package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class RemoveBusinessAccountProfilePhoto implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("is_public") @Nullable private final Boolean isPublic;

    @JsonCreator
    public RemoveBusinessAccountProfilePhoto(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("is_public") @Nullable Boolean isPublic
    ) {
        this.businessConnectionId = businessConnectionId;
        this.isPublic = isPublic;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public Boolean isPublic() {
        return this.isPublic;
    }

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
