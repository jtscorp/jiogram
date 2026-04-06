package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.UniqueGift;
import org.jspecify.annotations.Nullable;

public record UniqueGiftInfo(
    @JsonProperty("gift") UniqueGift gift,
    @JsonProperty("origin") String origin,
    @JsonProperty("last_resale_currency") @Nullable String lastResaleCurrency,
    @JsonProperty("last_resale_amount") @Nullable Long lastResaleAmount,
    @JsonProperty("owned_gift_id") @Nullable String ownedGiftId,
    @JsonProperty("transfer_star_count") @Nullable Long transferStarCount,
    @JsonProperty("next_transfer_date") @Nullable Long nextTransferDate
) {}
