package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSourceType;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class ChatBoostSourceGiveaway implements ChatBoostSource {
    @JsonProperty("source") private final ChatBoostSourceType source;
    @JsonProperty("giveaway_message_id") private final long giveawayMessageId;
    @JsonProperty("user") @Nullable private final User user;
    @JsonProperty("prize_star_count") @Nullable private final Long prizeStarCount;
    @JsonProperty("is_unclaimed") @Nullable private final Boolean isUnclaimed;

    @JsonCreator
    public ChatBoostSourceGiveaway(
            @JsonProperty("source") ChatBoostSourceType source,
            @JsonProperty("giveaway_message_id") long giveawayMessageId,
            @JsonProperty("user") @Nullable User user,
            @JsonProperty("prize_star_count") @Nullable Long prizeStarCount,
            @JsonProperty("is_unclaimed") @Nullable Boolean isUnclaimed
    ) {
        this.source = source;
        this.giveawayMessageId = giveawayMessageId;
        this.user = user;
        this.prizeStarCount = prizeStarCount;
        this.isUnclaimed = isUnclaimed;
    }

    public ChatBoostSourceType source() {
        return this.source;
    }

    public long giveawayMessageId() {
        return this.giveawayMessageId;
    }

    public User user() {
        return this.user;
    }

    public Long prizeStarCount() {
        return this.prizeStarCount;
    }

    public Boolean isUnclaimed() {
        return this.isUnclaimed;
    }
}
