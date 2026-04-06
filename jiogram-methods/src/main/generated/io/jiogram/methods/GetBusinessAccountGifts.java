package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGifts;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record GetBusinessAccountGifts(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("exclude_unsaved") @Nullable Boolean excludeUnsaved,
    @JsonProperty("exclude_saved") @Nullable Boolean excludeSaved,
    @JsonProperty("exclude_unlimited") @Nullable Boolean excludeUnlimited,
    @JsonProperty("exclude_limited_upgradable") @Nullable Boolean excludeLimitedUpgradable,
    @JsonProperty("exclude_limited_non_upgradable") @Nullable Boolean excludeLimitedNonUpgradable,
    @JsonProperty("exclude_unique") @Nullable Boolean excludeUnique,
    @JsonProperty("exclude_from_blockchain") @Nullable Boolean excludeFromBlockchain,
    @JsonProperty("sort_by_price") @Nullable Boolean sortByPrice,
    @JsonProperty("offset") @Nullable String offset,
    @JsonProperty("limit") @Nullable Long limit
) implements TelegramMethod<OwnedGifts> {

    @Override
    public String apiMethod() {
        return "getBusinessAccountGifts";
    }

    @Override
    public String apiReturnType() {
        return "OwnedGifts";
    }

    public static GetBusinessAccountGifts of(String businessConnectionId) {
        return new GetBusinessAccountGifts(businessConnectionId, null, null, null, null, null, null, null, null, null, null);
    }
}
