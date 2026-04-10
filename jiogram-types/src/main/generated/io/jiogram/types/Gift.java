package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.GiftBackground;
import io.jiogram.types.Sticker;
import org.jspecify.annotations.Nullable;

public class Gift {
    @JsonProperty("id") private final String id;
    @JsonProperty("sticker") private final Sticker sticker;
    @JsonProperty("star_count") private final long starCount;
    @JsonProperty("upgrade_star_count") @Nullable private final Long upgradeStarCount;
    @JsonProperty("is_premium") @Nullable private final Boolean isPremium;
    @JsonProperty("has_colors") @Nullable private final Boolean hasColors;
    @JsonProperty("total_count") @Nullable private final Long totalCount;
    @JsonProperty("remaining_count") @Nullable private final Long remainingCount;
    @JsonProperty("personal_total_count") @Nullable private final Long personalTotalCount;
    @JsonProperty("personal_remaining_count") @Nullable private final Long personalRemainingCount;
    @JsonProperty("background") @Nullable private final GiftBackground background;
    @JsonProperty("unique_gift_variant_count") @Nullable private final Long uniqueGiftVariantCount;
    @JsonProperty("publisher_chat") @Nullable private final Chat publisherChat;

    @JsonCreator
    public Gift(
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
    ) {
        this.id = id;
        this.sticker = sticker;
        this.starCount = starCount;
        this.upgradeStarCount = upgradeStarCount;
        this.isPremium = isPremium;
        this.hasColors = hasColors;
        this.totalCount = totalCount;
        this.remainingCount = remainingCount;
        this.personalTotalCount = personalTotalCount;
        this.personalRemainingCount = personalRemainingCount;
        this.background = background;
        this.uniqueGiftVariantCount = uniqueGiftVariantCount;
        this.publisherChat = publisherChat;
    }

    public String id() {
        return this.id;
    }

    public Sticker sticker() {
        return this.sticker;
    }

    public long starCount() {
        return this.starCount;
    }

    public Long upgradeStarCount() {
        return this.upgradeStarCount;
    }

    public Boolean isPremium() {
        return this.isPremium;
    }

    public Boolean hasColors() {
        return this.hasColors;
    }

    public Long totalCount() {
        return this.totalCount;
    }

    public Long remainingCount() {
        return this.remainingCount;
    }

    public Long personalTotalCount() {
        return this.personalTotalCount;
    }

    public Long personalRemainingCount() {
        return this.personalRemainingCount;
    }

    public GiftBackground background() {
        return this.background;
    }

    public Long uniqueGiftVariantCount() {
        return this.uniqueGiftVariantCount;
    }

    public Chat publisherChat() {
        return this.publisherChat;
    }
}
