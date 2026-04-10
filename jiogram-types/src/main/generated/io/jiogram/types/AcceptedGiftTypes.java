package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AcceptedGiftTypes {
    @JsonProperty("unlimited_gifts") private final boolean unlimitedGifts;
    @JsonProperty("limited_gifts") private final boolean limitedGifts;
    @JsonProperty("unique_gifts") private final boolean uniqueGifts;
    @JsonProperty("premium_subscription") private final boolean premiumSubscription;
    @JsonProperty("gifts_from_channels") private final boolean giftsFromChannels;

    @JsonCreator
    public AcceptedGiftTypes(
            @JsonProperty("unlimited_gifts") boolean unlimitedGifts,
            @JsonProperty("limited_gifts") boolean limitedGifts,
            @JsonProperty("unique_gifts") boolean uniqueGifts,
            @JsonProperty("premium_subscription") boolean premiumSubscription,
            @JsonProperty("gifts_from_channels") boolean giftsFromChannels
    ) {
        this.unlimitedGifts = unlimitedGifts;
        this.limitedGifts = limitedGifts;
        this.uniqueGifts = uniqueGifts;
        this.premiumSubscription = premiumSubscription;
        this.giftsFromChannels = giftsFromChannels;
    }

    public boolean unlimitedGifts() {
        return this.unlimitedGifts;
    }

    public boolean limitedGifts() {
        return this.limitedGifts;
    }

    public boolean uniqueGifts() {
        return this.uniqueGifts;
    }

    public boolean premiumSubscription() {
        return this.premiumSubscription;
    }

    public boolean giftsFromChannels() {
        return this.giftsFromChannels;
    }
}
