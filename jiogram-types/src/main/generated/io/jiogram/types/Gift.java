package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.GiftBackground;
import io.jiogram.types.Sticker;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a gift that can be sent by the bot.
 *
 * @param id Unique identifier of the gift
 * @param sticker The sticker that represents the gift
 * @param starCount The number of Telegram Stars that must be paid to send the sticker
 * @param upgradeStarCount The number of Telegram Stars that must be paid to upgrade the gift to a
 *     unique one
 * @param isPremium True, if the gift can only be purchased by Telegram Premium subscribers
 * @param hasColors True, if the gift can be used (after being upgraded) to customize a user's
 *     appearance
 * @param totalCount The total number of gifts of this type that can be sent by all users; for
 *     limited gifts only
 * @param remainingCount The number of remaining gifts of this type that can be sent by all users;
 *     for limited gifts only
 * @param personalTotalCount The total number of gifts of this type that can be sent by the bot; for
 *     limited gifts only
 * @param personalRemainingCount The number of remaining gifts of this type that can be sent by the
 *     bot; for limited gifts only
 * @param background Background of the gift
 * @param uniqueGiftVariantCount The total number of different unique gifts that can be obtained by
 *     upgrading the gift
 * @param publisherChat Information about the chat that published the gift
 * @see <a href="https://core.telegram.org/bots/api#gift">Gift in the Bot API</a>
 */
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
) {

    public Gift withId(String id) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }

    public Gift withSticker(Sticker sticker) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }

    public Gift withStarCount(long starCount) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }

    public Gift withUpgradeStarCount(@Nullable Long upgradeStarCount) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }

    public Gift withIsPremium(@Nullable Boolean isPremium) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }

    public Gift withHasColors(@Nullable Boolean hasColors) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }

    public Gift withTotalCount(@Nullable Long totalCount) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }

    public Gift withRemainingCount(@Nullable Long remainingCount) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }

    public Gift withPersonalTotalCount(@Nullable Long personalTotalCount) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }

    public Gift withPersonalRemainingCount(@Nullable Long personalRemainingCount) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }

    public Gift withBackground(@Nullable GiftBackground background) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }

    public Gift withUniqueGiftVariantCount(@Nullable Long uniqueGiftVariantCount) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }

    public Gift withPublisherChat(@Nullable Chat publisherChat) {
        return new Gift(id, sticker, starCount, upgradeStarCount, isPremium, hasColors, totalCount, remainingCount, personalTotalCount, personalRemainingCount, background, uniqueGiftVariantCount, publisherChat);
    }
}
