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
 * Returns the gifts owned and hosted by a user. Returns OwnedGifts on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getusergifts">getUserGifts in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetUserGifts implements TelegramMethod<OwnedGifts> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("exclude_unlimited")
    private final @Nullable Boolean excludeUnlimited;

    @JsonProperty("exclude_limited_upgradable")
    private final @Nullable Boolean excludeLimitedUpgradable;

    @JsonProperty("exclude_limited_non_upgradable")
    private final @Nullable Boolean excludeLimitedNonUpgradable;

    @JsonProperty("exclude_from_blockchain")
    private final @Nullable Boolean excludeFromBlockchain;

    @JsonProperty("exclude_unique")
    private final @Nullable Boolean excludeUnique;

    @JsonProperty("sort_by_price")
    private final @Nullable Boolean sortByPrice;

    @JsonProperty("offset")
    private final @Nullable String offset;

    @JsonProperty("limit")
    private final @Nullable Long limit;

    /**
     * Creates a new {@code GetUserGifts} instance.
     *
     * @param userId Unique identifier of the user
     * @param excludeUnlimited Pass True to exclude gifts that can be purchased an unlimited number
     *     of times
     * @param excludeLimitedUpgradable Pass True to exclude gifts that can be purchased a limited
     *     number of times and can be upgraded to unique
     * @param excludeLimitedNonUpgradable Pass True to exclude gifts that can be purchased a limited
     *     number of times and can't be upgraded to unique
     * @param excludeFromBlockchain Pass True to exclude gifts that were assigned from the TON
     *     blockchain and can't be resold or transferred in Telegram
     * @param excludeUnique Pass True to exclude unique gifts
     * @param sortByPrice Pass True to sort results by gift price instead of send date. Sorting is
     *     applied before pagination.
     * @param offset Offset of the first entry to return as received from the previous request; use
     *     an empty string to get the first chunk of results
     * @param limit The maximum number of gifts to be returned; 1-100. Defaults to 100
     */
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
            @JsonProperty("limit") @Nullable Long limit) {
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

    /**
     * Unique identifier of the user
     */
    public long userId() {
        return userId;
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
     * Pass True to exclude gifts that were assigned from the TON blockchain and can't be resold or
     * transferred in Telegram
     */
    public @Nullable Boolean excludeFromBlockchain() {
        return excludeFromBlockchain;
    }

    /**
     * Pass True to exclude unique gifts
     */
    public @Nullable Boolean excludeUnique() {
        return excludeUnique;
    }

    /**
     * Pass True to sort results by gift price instead of send date. Sorting is applied before
     * pagination.
     */
    public @Nullable Boolean sortByPrice() {
        return sortByPrice;
    }

    /**
     * Offset of the first entry to return as received from the previous request; use an empty
     * string to get the first chunk of results
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetUserGifts)) {
            return false;
        }
        GetUserGifts that = (GetUserGifts) o;
        return this.userId == that.userId
                && Objects.equals(this.excludeUnlimited, that.excludeUnlimited)
                && Objects.equals(this.excludeLimitedUpgradable, that.excludeLimitedUpgradable)
                && Objects.equals(this.excludeLimitedNonUpgradable, that.excludeLimitedNonUpgradable)
                && Objects.equals(this.excludeFromBlockchain, that.excludeFromBlockchain)
                && Objects.equals(this.excludeUnique, that.excludeUnique)
                && Objects.equals(this.sortByPrice, that.sortByPrice)
                && Objects.equals(this.offset, that.offset)
                && Objects.equals(this.limit, that.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.excludeUnlimited, this.excludeLimitedUpgradable, this.excludeLimitedNonUpgradable, this.excludeFromBlockchain, this.excludeUnique, this.sortByPrice, this.offset, this.limit);
    }

    @Override
    public String toString() {
        return "GetUserGifts[userId=" + this.userId
                + ", excludeUnlimited=" + this.excludeUnlimited
                + ", excludeLimitedUpgradable=" + this.excludeLimitedUpgradable
                + ", excludeLimitedNonUpgradable=" + this.excludeLimitedNonUpgradable
                + ", excludeFromBlockchain=" + this.excludeFromBlockchain
                + ", excludeUnique=" + this.excludeUnique
                + ", sortByPrice=" + this.sortByPrice
                + ", offset=" + this.offset
                + ", limit=" + this.limit
                + "]";
    }
}
