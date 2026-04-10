package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGifts;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class GetUserGifts implements TelegramMethod<OwnedGifts> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("exclude_unlimited") @Nullable private final Boolean excludeUnlimited;
    @JsonProperty("exclude_limited_upgradable") @Nullable private final Boolean excludeLimitedUpgradable;
    @JsonProperty("exclude_limited_non_upgradable") @Nullable private final Boolean excludeLimitedNonUpgradable;
    @JsonProperty("exclude_from_blockchain") @Nullable private final Boolean excludeFromBlockchain;
    @JsonProperty("exclude_unique") @Nullable private final Boolean excludeUnique;
    @JsonProperty("sort_by_price") @Nullable private final Boolean sortByPrice;
    @JsonProperty("offset") @Nullable private final String offset;
    @JsonProperty("limit") @Nullable private final Long limit;

    @JsonCreator
    public GetUserGifts(
            @JsonProperty("user_id") long userId,
            @JsonProperty("exclude_unlimited") @Nullable Boolean excludeUnlimited,
            @JsonProperty("exclude_limited_upgradable") @Nullable Boolean excludeLimitedUpgradable,
            @JsonProperty("exclude_limited_non_upgradable") @Nullable Boolean excludeLimitedNonUpgradable,
            @JsonProperty("exclude_from_blockchain") @Nullable Boolean excludeFromBlockchain,
            @JsonProperty("exclude_unique") @Nullable Boolean excludeUnique,
            @JsonProperty("sort_by_price") @Nullable Boolean sortByPrice,
            @JsonProperty("offset") @Nullable String offset,
            @JsonProperty("limit") @Nullable Long limit
    ) {
        this.userId = userId;
        this.excludeUnlimited = excludeUnlimited;
        this.excludeLimitedUpgradable = excludeLimitedUpgradable;
        this.excludeLimitedNonUpgradable = excludeLimitedNonUpgradable;
        this.excludeFromBlockchain = excludeFromBlockchain;
        this.excludeUnique = excludeUnique;
        this.sortByPrice = sortByPrice;
        this.offset = offset;
        this.limit = limit;
    }

    public long userId() {
        return this.userId;
    }

    public Boolean excludeUnlimited() {
        return this.excludeUnlimited;
    }

    public Boolean excludeLimitedUpgradable() {
        return this.excludeLimitedUpgradable;
    }

    public Boolean excludeLimitedNonUpgradable() {
        return this.excludeLimitedNonUpgradable;
    }

    public Boolean excludeFromBlockchain() {
        return this.excludeFromBlockchain;
    }

    public Boolean excludeUnique() {
        return this.excludeUnique;
    }

    public Boolean sortByPrice() {
        return this.sortByPrice;
    }

    public String offset() {
        return this.offset;
    }

    public Long limit() {
        return this.limit;
    }

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
