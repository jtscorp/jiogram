package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.GiftBackground;
import io.jiogram.types.Sticker;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a gift that can be sent by the bot.
 *
 * @see <a href="https://core.telegram.org/bots/api#gift">Gift in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Gift {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("sticker")
    private final Sticker sticker;

    @JsonProperty("star_count")
    private final long starCount;

    @JsonProperty("upgrade_star_count")
    private final @Nullable Long upgradeStarCount;

    @JsonProperty("is_premium")
    private final @Nullable Boolean isPremium;

    @JsonProperty("has_colors")
    private final @Nullable Boolean hasColors;

    @JsonProperty("total_count")
    private final @Nullable Long totalCount;

    @JsonProperty("remaining_count")
    private final @Nullable Long remainingCount;

    @JsonProperty("personal_total_count")
    private final @Nullable Long personalTotalCount;

    @JsonProperty("personal_remaining_count")
    private final @Nullable Long personalRemainingCount;

    @JsonProperty("background")
    private final @Nullable GiftBackground background;

    @JsonProperty("unique_gift_variant_count")
    private final @Nullable Long uniqueGiftVariantCount;

    @JsonProperty("publisher_chat")
    private final @Nullable Chat publisherChat;

    /**
     * Creates a new {@code Gift} instance.
     *
     * @param id Unique identifier of the gift
     * @param sticker The sticker that represents the gift
     * @param starCount The number of Telegram Stars that must be paid to send the sticker
     * @param upgradeStarCount The number of Telegram Stars that must be paid to upgrade the gift to
     *     a unique one
     * @param isPremium True, if the gift can only be purchased by Telegram Premium subscribers
     * @param hasColors True, if the gift can be used (after being upgraded) to customize a user's
     *     appearance
     * @param totalCount The total number of gifts of this type that can be sent by all users; for
     *     limited gifts only
     * @param remainingCount The number of remaining gifts of this type that can be sent by all
     *     users; for limited gifts only
     * @param personalTotalCount The total number of gifts of this type that can be sent by the bot;
     *     for limited gifts only
     * @param personalRemainingCount The number of remaining gifts of this type that can be sent by
     *     the bot; for limited gifts only
     * @param background Background of the gift
     * @param uniqueGiftVariantCount The total number of different unique gifts that can be obtained
     *     by upgrading the gift
     * @param publisherChat Information about the chat that published the gift
     */
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
            @JsonProperty("publisher_chat") @Nullable Chat publisherChat) {
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

    public static Gift of(String id, Sticker sticker, long starCount) {
        return new Gift(id, sticker, starCount, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Unique identifier of the gift
     */
    public String id() {
        return id;
    }

    /**
     * The sticker that represents the gift
     */
    public Sticker sticker() {
        return sticker;
    }

    /**
     * The number of Telegram Stars that must be paid to send the sticker
     */
    public long starCount() {
        return starCount;
    }

    /**
     * The number of Telegram Stars that must be paid to upgrade the gift to a unique one
     */
    public @Nullable Long upgradeStarCount() {
        return upgradeStarCount;
    }

    /**
     * True, if the gift can only be purchased by Telegram Premium subscribers
     */
    public @Nullable Boolean isPremium() {
        return isPremium;
    }

    /**
     * True, if the gift can be used (after being upgraded) to customize a user's appearance
     */
    public @Nullable Boolean hasColors() {
        return hasColors;
    }

    /**
     * The total number of gifts of this type that can be sent by all users; for limited gifts only
     */
    public @Nullable Long totalCount() {
        return totalCount;
    }

    /**
     * The number of remaining gifts of this type that can be sent by all users; for limited gifts
     * only
     */
    public @Nullable Long remainingCount() {
        return remainingCount;
    }

    /**
     * The total number of gifts of this type that can be sent by the bot; for limited gifts only
     */
    public @Nullable Long personalTotalCount() {
        return personalTotalCount;
    }

    /**
     * The number of remaining gifts of this type that can be sent by the bot; for limited gifts
     * only
     */
    public @Nullable Long personalRemainingCount() {
        return personalRemainingCount;
    }

    /**
     * Background of the gift
     */
    public @Nullable GiftBackground background() {
        return background;
    }

    /**
     * The total number of different unique gifts that can be obtained by upgrading the gift
     */
    public @Nullable Long uniqueGiftVariantCount() {
        return uniqueGiftVariantCount;
    }

    /**
     * Information about the chat that published the gift
     */
    public @Nullable Chat publisherChat() {
        return publisherChat;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Gift)) {
            return false;
        }
        Gift that = (Gift) o;
        return Objects.equals(this.id, that.id)
                && Objects.equals(this.sticker, that.sticker)
                && this.starCount == that.starCount
                && Objects.equals(this.upgradeStarCount, that.upgradeStarCount)
                && Objects.equals(this.isPremium, that.isPremium)
                && Objects.equals(this.hasColors, that.hasColors)
                && Objects.equals(this.totalCount, that.totalCount)
                && Objects.equals(this.remainingCount, that.remainingCount)
                && Objects.equals(this.personalTotalCount, that.personalTotalCount)
                && Objects.equals(this.personalRemainingCount, that.personalRemainingCount)
                && Objects.equals(this.background, that.background)
                && Objects.equals(this.uniqueGiftVariantCount, that.uniqueGiftVariantCount)
                && Objects.equals(this.publisherChat, that.publisherChat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.sticker, this.starCount, this.upgradeStarCount, this.isPremium, this.hasColors, this.totalCount, this.remainingCount, this.personalTotalCount, this.personalRemainingCount, this.background, this.uniqueGiftVariantCount, this.publisherChat);
    }

    @Override
    public String toString() {
        return "Gift[id=" + this.id
                + ", sticker=" + this.sticker
                + ", starCount=" + this.starCount
                + ", upgradeStarCount=" + this.upgradeStarCount
                + ", isPremium=" + this.isPremium
                + ", hasColors=" + this.hasColors
                + ", totalCount=" + this.totalCount
                + ", remainingCount=" + this.remainingCount
                + ", personalTotalCount=" + this.personalTotalCount
                + ", personalRemainingCount=" + this.personalRemainingCount
                + ", background=" + this.background
                + ", uniqueGiftVariantCount=" + this.uniqueGiftVariantCount
                + ", publisherChat=" + this.publisherChat
                + "]";
    }
}
