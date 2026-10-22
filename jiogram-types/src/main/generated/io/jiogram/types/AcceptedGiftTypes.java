package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object describes the types of gifts that can be gifted to a user or a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#acceptedgifttypes">AcceptedGiftTypes in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class AcceptedGiftTypes {

    @JsonProperty("unlimited_gifts")
    private final boolean unlimitedGifts;

    @JsonProperty("limited_gifts")
    private final boolean limitedGifts;

    @JsonProperty("unique_gifts")
    private final boolean uniqueGifts;

    @JsonProperty("premium_subscription")
    private final boolean premiumSubscription;

    @JsonProperty("gifts_from_channels")
    private final boolean giftsFromChannels;

    /**
     * Creates a new {@code AcceptedGiftTypes} instance.
     *
     * @param unlimitedGifts True, if unlimited regular gifts are accepted
     * @param limitedGifts True, if limited regular gifts are accepted
     * @param uniqueGifts True, if unique gifts or gifts that can be upgraded to unique for free are
     *     accepted
     * @param premiumSubscription True, if a Telegram Premium subscription is accepted
     * @param giftsFromChannels True, if transfers of unique gifts from channels are accepted
     */
    @JsonCreator
    public AcceptedGiftTypes(
            @JsonProperty("unlimited_gifts") boolean unlimitedGifts,
            @JsonProperty("limited_gifts") boolean limitedGifts,
            @JsonProperty("unique_gifts") boolean uniqueGifts,
            @JsonProperty("premium_subscription") boolean premiumSubscription,
            @JsonProperty("gifts_from_channels") boolean giftsFromChannels) {
        this.unlimitedGifts = unlimitedGifts;
        this.limitedGifts = limitedGifts;
        this.uniqueGifts = uniqueGifts;
        this.premiumSubscription = premiumSubscription;
        this.giftsFromChannels = giftsFromChannels;
    }

    /**
     * True, if unlimited regular gifts are accepted
     */
    public boolean unlimitedGifts() {
        return unlimitedGifts;
    }

    /**
     * True, if limited regular gifts are accepted
     */
    public boolean limitedGifts() {
        return limitedGifts;
    }

    /**
     * True, if unique gifts or gifts that can be upgraded to unique for free are accepted
     */
    public boolean uniqueGifts() {
        return uniqueGifts;
    }

    /**
     * True, if a Telegram Premium subscription is accepted
     */
    public boolean premiumSubscription() {
        return premiumSubscription;
    }

    /**
     * True, if transfers of unique gifts from channels are accepted
     */
    public boolean giftsFromChannels() {
        return giftsFromChannels;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AcceptedGiftTypes)) {
            return false;
        }
        AcceptedGiftTypes that = (AcceptedGiftTypes) o;
        return this.unlimitedGifts == that.unlimitedGifts
                && this.limitedGifts == that.limitedGifts
                && this.uniqueGifts == that.uniqueGifts
                && this.premiumSubscription == that.premiumSubscription
                && this.giftsFromChannels == that.giftsFromChannels;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unlimitedGifts, this.limitedGifts, this.uniqueGifts, this.premiumSubscription, this.giftsFromChannels);
    }

    @Override
    public String toString() {
        return "AcceptedGiftTypes[unlimitedGifts=" + this.unlimitedGifts
                + ", limitedGifts=" + this.limitedGifts
                + ", uniqueGifts=" + this.uniqueGifts
                + ", premiumSubscription=" + this.premiumSubscription
                + ", giftsFromChannels=" + this.giftsFromChannels
                + "]";
    }
}
