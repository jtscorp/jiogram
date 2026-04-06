package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.GiftBackground;
import io.jiogram.types.Sticker;
import org.jspecify.annotations.Nullable;

public record Gift(
    @JsonProperty("id") String id,
    @JsonProperty("sticker") Sticker sticker,
    @JsonProperty("star_count") long starCount,
    @JsonProperty("upgrade_star_count") @Nullable Long upgradeStarCount,
    @JsonProperty("is_premium") @Nullable Boolean isPremium,
    @JsonProperty("has_colors") @Nullable Boolean hasColors,
    @JsonProperty("total_count") @Nullable Long totalCount,
    @JsonProperty("remaining_count") @Nullable Long remainingCount,
    @JsonProperty("personal_total_count") @Nullable Long personalTotalCount,
    @JsonProperty("personal_remaining_count") @Nullable Long personalRemainingCount,
    @JsonProperty("background") @Nullable GiftBackground background,
    @JsonProperty("unique_gift_variant_count") @Nullable Long uniqueGiftVariantCount,
    @JsonProperty("publisher_chat") @Nullable Chat publisherChat
) {}
