package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGifts;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Returns the gifts received and owned by a managed business account. Requires the
 * can_view_gifts_and_stars business bot right. Returns OwnedGifts on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param excludeUnsaved Pass True to exclude gifts that aren't saved to the account's profile page
 * @param excludeSaved Pass True to exclude gifts that are saved to the account's profile page
 * @param excludeUnlimited Pass True to exclude gifts that can be purchased an unlimited number of
 *     times
 * @param excludeLimitedUpgradable Pass True to exclude gifts that can be purchased a limited number
 *     of times and can be upgraded to unique
 * @param excludeLimitedNonUpgradable Pass True to exclude gifts that can be purchased a limited
 *     number of times and can't be upgraded to unique
 * @param excludeUnique Pass True to exclude unique gifts
 * @param excludeFromBlockchain Pass True to exclude gifts that were assigned from the TON
 *     blockchain and can't be resold or transferred in Telegram
 * @param sortByPrice Pass True to sort results by gift price instead of send date. Sorting is
 *     applied before pagination.
 * @param offset Offset of the first entry to return as received from the previous request; use
 *     empty string to get the first chunk of results
 * @param limit The maximum number of gifts to be returned; 1-100. Defaults to 100
 * @see <a href="https://core.telegram.org/bots/api#getbusinessaccountgifts">getBusinessAccountGifts in the Bot API</a>
 */
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

    public GetBusinessAccountGifts withBusinessConnectionId(String businessConnectionId) {
        return new GetBusinessAccountGifts(businessConnectionId, excludeUnsaved, excludeSaved, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeUnique, excludeFromBlockchain, sortByPrice, offset, limit);
    }

    public GetBusinessAccountGifts withExcludeUnsaved(@Nullable Boolean excludeUnsaved) {
        return new GetBusinessAccountGifts(businessConnectionId, excludeUnsaved, excludeSaved, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeUnique, excludeFromBlockchain, sortByPrice, offset, limit);
    }

    public GetBusinessAccountGifts withExcludeSaved(@Nullable Boolean excludeSaved) {
        return new GetBusinessAccountGifts(businessConnectionId, excludeUnsaved, excludeSaved, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeUnique, excludeFromBlockchain, sortByPrice, offset, limit);
    }

    public GetBusinessAccountGifts withExcludeUnlimited(@Nullable Boolean excludeUnlimited) {
        return new GetBusinessAccountGifts(businessConnectionId, excludeUnsaved, excludeSaved, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeUnique, excludeFromBlockchain, sortByPrice, offset, limit);
    }

    public GetBusinessAccountGifts withExcludeLimitedUpgradable(@Nullable Boolean excludeLimitedUpgradable) {
        return new GetBusinessAccountGifts(businessConnectionId, excludeUnsaved, excludeSaved, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeUnique, excludeFromBlockchain, sortByPrice, offset, limit);
    }

    public GetBusinessAccountGifts withExcludeLimitedNonUpgradable(@Nullable Boolean excludeLimitedNonUpgradable) {
        return new GetBusinessAccountGifts(businessConnectionId, excludeUnsaved, excludeSaved, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeUnique, excludeFromBlockchain, sortByPrice, offset, limit);
    }

    public GetBusinessAccountGifts withExcludeUnique(@Nullable Boolean excludeUnique) {
        return new GetBusinessAccountGifts(businessConnectionId, excludeUnsaved, excludeSaved, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeUnique, excludeFromBlockchain, sortByPrice, offset, limit);
    }

    public GetBusinessAccountGifts withExcludeFromBlockchain(@Nullable Boolean excludeFromBlockchain) {
        return new GetBusinessAccountGifts(businessConnectionId, excludeUnsaved, excludeSaved, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeUnique, excludeFromBlockchain, sortByPrice, offset, limit);
    }

    public GetBusinessAccountGifts withSortByPrice(@Nullable Boolean sortByPrice) {
        return new GetBusinessAccountGifts(businessConnectionId, excludeUnsaved, excludeSaved, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeUnique, excludeFromBlockchain, sortByPrice, offset, limit);
    }

    public GetBusinessAccountGifts withOffset(@Nullable String offset) {
        return new GetBusinessAccountGifts(businessConnectionId, excludeUnsaved, excludeSaved, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeUnique, excludeFromBlockchain, sortByPrice, offset, limit);
    }

    public GetBusinessAccountGifts withLimit(@Nullable Long limit) {
        return new GetBusinessAccountGifts(businessConnectionId, excludeUnsaved, excludeSaved, excludeUnlimited, excludeLimitedUpgradable, excludeLimitedNonUpgradable, excludeUnique, excludeFromBlockchain, sortByPrice, offset, limit);
    }
}
