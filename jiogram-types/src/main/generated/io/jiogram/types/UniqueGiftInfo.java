package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.UniqueGift;
import org.jspecify.annotations.Nullable;

public class UniqueGiftInfo {
    @JsonProperty("gift") private final UniqueGift gift;
    @JsonProperty("origin") private final String origin;
    @JsonProperty("last_resale_currency") @Nullable private final String lastResaleCurrency;
    @JsonProperty("last_resale_amount") @Nullable private final Long lastResaleAmount;
    @JsonProperty("owned_gift_id") @Nullable private final String ownedGiftId;
    @JsonProperty("transfer_star_count") @Nullable private final Long transferStarCount;
    @JsonProperty("next_transfer_date") @Nullable private final Long nextTransferDate;

    @JsonCreator
    public UniqueGiftInfo(
            @JsonProperty("gift") UniqueGift gift,
            @JsonProperty("origin") String origin,
            @JsonProperty("last_resale_currency") @Nullable String lastResaleCurrency,
            @JsonProperty("last_resale_amount") @Nullable Long lastResaleAmount,
            @JsonProperty("owned_gift_id") @Nullable String ownedGiftId,
            @JsonProperty("transfer_star_count") @Nullable Long transferStarCount,
            @JsonProperty("next_transfer_date") @Nullable Long nextTransferDate
    ) {
        this.gift = gift;
        this.origin = origin;
        this.lastResaleCurrency = lastResaleCurrency;
        this.lastResaleAmount = lastResaleAmount;
        this.ownedGiftId = ownedGiftId;
        this.transferStarCount = transferStarCount;
        this.nextTransferDate = nextTransferDate;
    }

    public UniqueGift gift() {
        return this.gift;
    }

    public String origin() {
        return this.origin;
    }

    public String lastResaleCurrency() {
        return this.lastResaleCurrency;
    }

    public Long lastResaleAmount() {
        return this.lastResaleAmount;
    }

    public String ownedGiftId() {
        return this.ownedGiftId;
    }

    public Long transferStarCount() {
        return this.transferStarCount;
    }

    public Long nextTransferDate() {
        return this.nextTransferDate;
    }
}
