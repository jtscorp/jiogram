package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGifts;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Returns the gifts received and owned by a managed business account. Requires the
 * can_view_gifts_and_stars business bot right. Returns OwnedGifts on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getbusinessaccountgifts">getBusinessAccountGifts in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetBusinessAccountGifts implements TelegramMethod<OwnedGifts> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("exclude_unsaved")
    private final @Nullable Boolean excludeUnsaved;

    @JsonProperty("exclude_saved")
    private final @Nullable Boolean excludeSaved;

    @JsonProperty("exclude_unlimited")
    private final @Nullable Boolean excludeUnlimited;

    @JsonProperty("exclude_limited_upgradable")
    private final @Nullable Boolean excludeLimitedUpgradable;

    @JsonProperty("exclude_limited_non_upgradable")
    private final @Nullable Boolean excludeLimitedNonUpgradable;

    @JsonProperty("exclude_unique")
    private final @Nullable Boolean excludeUnique;

    @JsonProperty("exclude_from_blockchain")
    private final @Nullable Boolean excludeFromBlockchain;

    @JsonProperty("sort_by_price")
    private final @Nullable Boolean sortByPrice;

    @JsonProperty("offset")
    private final @Nullable String offset;

    @JsonProperty("limit")
    private final @Nullable Long limit;

    /**
     * Creates a new {@code GetBusinessAccountGifts} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param excludeUnsaved Pass True to exclude gifts that aren't saved to the account's profile
     *     page
     * @param excludeSaved Pass True to exclude gifts that are saved to the account's profile page
     * @param excludeUnlimited Pass True to exclude gifts that can be purchased an unlimited number
     *     of times
     * @param excludeLimitedUpgradable Pass True to exclude gifts that can be purchased a limited
     *     number of times and can be upgraded to unique
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
     */
    @JsonCreator
    public GetBusinessAccountGifts(
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
            @JsonProperty("limit") @Nullable Long limit) {
        this.businessConnectionId = businessConnectionId;
        this.excludeUnsaved = excludeUnsaved;
        this.excludeSaved = excludeSaved;
        this.excludeUnlimited = excludeUnlimited;
        this.excludeLimitedUpgradable = excludeLimitedUpgradable;
        this.excludeLimitedNonUpgradable = excludeLimitedNonUpgradable;
        this.excludeUnique = excludeUnique;
        this.excludeFromBlockchain = excludeFromBlockchain;
        this.sortByPrice = sortByPrice;
        this.offset = offset;
        this.limit = limit;
    }

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

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Pass True to exclude gifts that aren't saved to the account's profile page
     */
    public @Nullable Boolean excludeUnsaved() {
        return excludeUnsaved;
    }

    /**
     * Pass True to exclude gifts that are saved to the account's profile page
     */
    public @Nullable Boolean excludeSaved() {
        return excludeSaved;
    }

    /**
     * Pass True to exclude gifts that can be purchased an unlimited number of times
     */
    public @Nullable Boolean excludeUnlimited() {
        return excludeUnlimited;
    }

    /**
     * Pass True to exclude gifts that can be purchased a limited number of times and can be
     * upgraded to unique
     */
    public @Nullable Boolean excludeLimitedUpgradable() {
        return excludeLimitedUpgradable;
    }

    /**
     * Pass True to exclude gifts that can be purchased a limited number of times and can't be
     * upgraded to unique
     */
    public @Nullable Boolean excludeLimitedNonUpgradable() {
        return excludeLimitedNonUpgradable;
    }

    /**
     * Pass True to exclude unique gifts
     */
    public @Nullable Boolean excludeUnique() {
        return excludeUnique;
    }

    /**
     * Pass True to exclude gifts that were assigned from the TON blockchain and can't be resold or
     * transferred in Telegram
     */
    public @Nullable Boolean excludeFromBlockchain() {
        return excludeFromBlockchain;
    }

    /**
     * Pass True to sort results by gift price instead of send date. Sorting is applied before
     * pagination.
     */
    public @Nullable Boolean sortByPrice() {
        return sortByPrice;
    }

    /**
     * Offset of the first entry to return as received from the previous request; use empty string
     * to get the first chunk of results
     */
    public @Nullable String offset() {
        return offset;
    }

    /**
     * The maximum number of gifts to be returned; 1-100. Defaults to 100
     */
    public @Nullable Long limit() {
        return limit;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetBusinessAccountGifts)) {
            return false;
        }
        GetBusinessAccountGifts that = (GetBusinessAccountGifts) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.excludeUnsaved, that.excludeUnsaved)
                && Objects.equals(this.excludeSaved, that.excludeSaved)
                && Objects.equals(this.excludeUnlimited, that.excludeUnlimited)
                && Objects.equals(this.excludeLimitedUpgradable, that.excludeLimitedUpgradable)
                && Objects.equals(this.excludeLimitedNonUpgradable, that.excludeLimitedNonUpgradable)
                && Objects.equals(this.excludeUnique, that.excludeUnique)
                && Objects.equals(this.excludeFromBlockchain, that.excludeFromBlockchain)
                && Objects.equals(this.sortByPrice, that.sortByPrice)
                && Objects.equals(this.offset, that.offset)
                && Objects.equals(this.limit, that.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.excludeUnsaved, this.excludeSaved, this.excludeUnlimited, this.excludeLimitedUpgradable, this.excludeLimitedNonUpgradable, this.excludeUnique, this.excludeFromBlockchain, this.sortByPrice, this.offset, this.limit);
    }

    @Override
    public String toString() {
        return "GetBusinessAccountGifts[businessConnectionId=" + this.businessConnectionId
                + ", excludeUnsaved=" + this.excludeUnsaved
                + ", excludeSaved=" + this.excludeSaved
                + ", excludeUnlimited=" + this.excludeUnlimited
                + ", excludeLimitedUpgradable=" + this.excludeLimitedUpgradable
                + ", excludeLimitedNonUpgradable=" + this.excludeLimitedNonUpgradable
                + ", excludeUnique=" + this.excludeUnique
                + ", excludeFromBlockchain=" + this.excludeFromBlockchain
                + ", sortByPrice=" + this.sortByPrice
                + ", offset=" + this.offset
                + ", limit=" + this.limit
                + "]";
    }
}
