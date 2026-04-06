package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record KeyboardButtonRequestUsers(
    @JsonProperty("request_id") long requestId,
    @JsonProperty("user_is_bot") @Nullable Boolean userIsBot,
    @JsonProperty("user_is_premium") @Nullable Boolean userIsPremium,
    @JsonProperty("max_quantity") @Nullable Long maxQuantity,
    @JsonProperty("request_name") @Nullable Boolean requestName,
    @JsonProperty("request_username") @Nullable Boolean requestUsername,
    @JsonProperty("request_photo") @Nullable Boolean requestPhoto
) {}
