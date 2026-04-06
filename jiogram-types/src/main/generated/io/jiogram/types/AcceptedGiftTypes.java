package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AcceptedGiftTypes(
    @JsonProperty("unlimited_gifts") boolean unlimitedGifts,
    @JsonProperty("limited_gifts") boolean limitedGifts,
    @JsonProperty("unique_gifts") boolean uniqueGifts,
    @JsonProperty("premium_subscription") boolean premiumSubscription,
    @JsonProperty("gifts_from_channels") boolean giftsFromChannels
) {}
