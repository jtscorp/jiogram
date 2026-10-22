package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents a service message about a user boosting a chat.
 *
 * @param boostCount Number of boosts added by the user
 * @see <a href="https://core.telegram.org/bots/api#chatboostadded">ChatBoostAdded in the Bot API</a>
 */
public record ChatBoostAdded(
    @JsonProperty("boost_count") long boostCount
) {

    public ChatBoostAdded withBoostCount(long boostCount) {
        return new ChatBoostAdded(boostCount);
    }
}
