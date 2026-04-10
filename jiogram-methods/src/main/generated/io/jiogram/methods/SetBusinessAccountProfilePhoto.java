package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputProfilePhoto;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetBusinessAccountProfilePhoto implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("photo") private final InputProfilePhoto photo;
    @JsonProperty("is_public") @Nullable private final Boolean isPublic;

    @JsonCreator
    public SetBusinessAccountProfilePhoto(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("photo") InputProfilePhoto photo,
            @JsonProperty("is_public") @Nullable Boolean isPublic
    ) {
        this.businessConnectionId = businessConnectionId;
        this.photo = photo;
        this.isPublic = isPublic;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public InputProfilePhoto photo() {
        return this.photo;
    }

    public Boolean isPublic() {
        return this.isPublic;
    }

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
