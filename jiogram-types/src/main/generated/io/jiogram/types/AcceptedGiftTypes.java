package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object describes the types of gifts that can be gifted to a user or a chat.
 *
 * @param unlimitedGifts True, if unlimited regular gifts are accepted
 * @param limitedGifts True, if limited regular gifts are accepted
 * @param uniqueGifts True, if unique gifts or gifts that can be upgraded to unique for free are
 *     accepted
 * @param premiumSubscription True, if a Telegram Premium subscription is accepted
 * @param giftsFromChannels True, if transfers of unique gifts from channels are accepted
 * @see <a href="https://core.telegram.org/bots/api#acceptedgifttypes">AcceptedGiftTypes in the Bot API</a>
 */
public record AcceptedGiftTypes(
    @JsonProperty("unlimited_gifts") boolean unlimitedGifts,
    @JsonProperty("limited_gifts") boolean limitedGifts,
    @JsonProperty("unique_gifts") boolean uniqueGifts,
    @JsonProperty("premium_subscription") boolean premiumSubscription,
    @JsonProperty("gifts_from_channels") boolean giftsFromChannels
) {

    public AcceptedGiftTypes withUnlimitedGifts(boolean unlimitedGifts) {
        return new AcceptedGiftTypes(unlimitedGifts, limitedGifts, uniqueGifts, premiumSubscription, giftsFromChannels);
    }

    public AcceptedGiftTypes withLimitedGifts(boolean limitedGifts) {
        return new AcceptedGiftTypes(unlimitedGifts, limitedGifts, uniqueGifts, premiumSubscription, giftsFromChannels);
    }

    public AcceptedGiftTypes withUniqueGifts(boolean uniqueGifts) {
        return new AcceptedGiftTypes(unlimitedGifts, limitedGifts, uniqueGifts, premiumSubscription, giftsFromChannels);
    }

    public AcceptedGiftTypes withPremiumSubscription(boolean premiumSubscription) {
        return new AcceptedGiftTypes(unlimitedGifts, limitedGifts, uniqueGifts, premiumSubscription, giftsFromChannels);
    }

    public AcceptedGiftTypes withGiftsFromChannels(boolean giftsFromChannels) {
        return new AcceptedGiftTypes(unlimitedGifts, limitedGifts, uniqueGifts, premiumSubscription, giftsFromChannels);
    }
}
