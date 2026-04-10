package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class KeyboardButtonRequestUsers {
    @JsonProperty("request_id") private final long requestId;
    @JsonProperty("user_is_bot") @Nullable private final Boolean userIsBot;
    @JsonProperty("user_is_premium") @Nullable private final Boolean userIsPremium;
    @JsonProperty("max_quantity") @Nullable private final Long maxQuantity;
    @JsonProperty("request_name") @Nullable private final Boolean requestName;
    @JsonProperty("request_username") @Nullable private final Boolean requestUsername;
    @JsonProperty("request_photo") @Nullable private final Boolean requestPhoto;

    @JsonCreator
    public KeyboardButtonRequestUsers(
            @JsonProperty("request_id") long requestId,
            @JsonProperty("user_is_bot") @Nullable Boolean userIsBot,
            @JsonProperty("user_is_premium") @Nullable Boolean userIsPremium,
            @JsonProperty("max_quantity") @Nullable Long maxQuantity,
            @JsonProperty("request_name") @Nullable Boolean requestName,
            @JsonProperty("request_username") @Nullable Boolean requestUsername,
            @JsonProperty("request_photo") @Nullable Boolean requestPhoto
    ) {
        this.requestId = requestId;
        this.userIsBot = userIsBot;
        this.userIsPremium = userIsPremium;
        this.maxQuantity = maxQuantity;
        this.requestName = requestName;
        this.requestUsername = requestUsername;
        this.requestPhoto = requestPhoto;
    }

    public long requestId() {
        return this.requestId;
    }

    public Boolean userIsBot() {
        return this.userIsBot;
    }

    public Boolean userIsPremium() {
        return this.userIsPremium;
    }

    public Long maxQuantity() {
        return this.maxQuantity;
    }

    public Boolean requestName() {
        return this.requestName;
    }

    public Boolean requestUsername() {
        return this.requestUsername;
    }

    public Boolean requestPhoto() {
        return this.requestPhoto;
    }
}
