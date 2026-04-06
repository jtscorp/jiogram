package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGifts;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record GetUserGifts(
    @JsonProperty("user_id") long userId,
    @JsonProperty("exclude_unlimited") @Nullable Boolean excludeUnlimited,
    @JsonProperty("exclude_limited_upgradable") @Nullable Boolean excludeLimitedUpgradable,
    @JsonProperty("exclude_limited_non_upgradable") @Nullable Boolean excludeLimitedNonUpgradable,
    @JsonProperty("exclude_from_blockchain") @Nullable Boolean excludeFromBlockchain,
    @JsonProperty("exclude_unique") @Nullable Boolean excludeUnique,
    @JsonProperty("sort_by_price") @Nullable Boolean sortByPrice,
    @JsonProperty("offset") @Nullable String offset,
    @JsonProperty("limit") @Nullable Long limit
) implements TelegramMethod<OwnedGifts> {

    @Override
    public String apiMethod() {
        return "getUserGifts";
    }

    @Override
    public String apiReturnType() {
        return "OwnedGifts";
    }

    public static GetUserGifts of(long userId) {
        return new GetUserGifts(userId, null, null, null, null, null, null, null, null);
    }
}
