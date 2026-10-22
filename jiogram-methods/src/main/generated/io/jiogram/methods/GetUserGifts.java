package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGifts;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Returns the gifts owned and hosted by a user. Returns OwnedGifts on success.
 *
 * @param userId Unique identifier of the user
 * @param excludeUnlimited Pass True to exclude gifts that can be purchased an unlimited number of
 *     times
 * @param excludeLimitedUpgradable Pass True to exclude gifts that can be purchased a limited number
 *     of times and can be upgraded to unique
 * @param excludeLimitedNonUpgradable Pass True to exclude gifts that can be purchased a limited
 *     number of times and can't be upgraded to unique
 * @param excludeFromBlockchain Pass True to exclude gifts that were assigned from the TON
 *     blockchain and can't be resold or transferred in Telegram
 * @param excludeUnique Pass True to exclude unique gifts
 * @param sortByPrice Pass True to sort results by gift price instead of send date. Sorting is
 *     applied before pagination.
 * @param offset Offset of the first entry to return as received from the previous request; use an
 *     empty string to get the first chunk of results
 * @param limit The maximum number of gifts to be returned; 1-100. Defaults to 100
 * @see <a href="https://core.telegram.org/bots/api#getusergifts">getUserGifts in the Bot API</a>
 */
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

    public GetUserGifts withUserId(long userId) {
        return new GetUserGifts(userId, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeFromBlockchain, excludeUnique, sortByPrice, offset, limit);
    }

    public GetUserGifts withExcludeUnlimited(@Nullable Boolean excludeUnlimited) {
        return new GetUserGifts(userId, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeFromBlockchain, excludeUnique, sortByPrice, offset, limit);
    }

    public GetUserGifts withExcludeLimitedUpgradable(@Nullable Boolean excludeLimitedUpgradable) {
        return new GetUserGifts(userId, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeFromBlockchain, excludeUnique, sortByPrice, offset, limit);
    }

    public GetUserGifts withExcludeLimitedNonUpgradable(@Nullable Boolean excludeLimitedNonUpgradable) {
        return new GetUserGifts(userId, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeFromBlockchain, excludeUnique, sortByPrice, offset, limit);
    }

    public GetUserGifts withExcludeFromBlockchain(@Nullable Boolean excludeFromBlockchain) {
        return new GetUserGifts(userId, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeFromBlockchain, excludeUnique, sortByPrice, offset, limit);
    }

    public GetUserGifts withExcludeUnique(@Nullable Boolean excludeUnique) {
        return new GetUserGifts(userId, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeFromBlockchain, excludeUnique, sortByPrice, offset, limit);
    }

    public GetUserGifts withSortByPrice(@Nullable Boolean sortByPrice) {
        return new GetUserGifts(userId, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeFromBlockchain, excludeUnique, sortByPrice, offset, limit);
    }

    public GetUserGifts withOffset(@Nullable String offset) {
        return new GetUserGifts(userId, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeFromBlockchain, excludeUnique, sortByPrice, offset, limit);
    }

    public GetUserGifts withLimit(@Nullable Long limit) {
        return new GetUserGifts(userId, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeFromBlockchain, excludeUnique, sortByPrice, offset, limit);
    }
}
