package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSource;

/**
 * This object contains information about a chat boost.
 *
 * @param boostId Unique identifier of the boost
 * @param addDate Point in time (Unix timestamp) when the chat was boosted
 * @param expirationDate Point in time (Unix timestamp) when the boost will automatically expire,
 *     unless the booster's Telegram Premium subscription is prolonged
 * @param source Source of the added boost
 * @see <a href="https://core.telegram.org/bots/api#chatboost">ChatBoost in the Bot API</a>
 */
public record ChatBoost(
    @JsonProperty("boost_id") String boostId,
    @JsonProperty("add_date") long addDate,
    @JsonProperty("expiration_date") long expirationDate,
    @JsonProperty("source") ChatBoostSource source
) {

    public ChatBoost withBoostId(String boostId) {
        return new ChatBoost(boostId, addDate, expirationDate, source);
    }

    public ChatBoost withAddDate(long addDate) {
        return new ChatBoost(boostId, addDate, expirationDate, source);
    }

    public ChatBoost withExpirationDate(long expirationDate) {
        return new ChatBoost(boostId, addDate, expirationDate, source);
    }

    public ChatBoost withSource(ChatBoostSource source) {
        return new ChatBoost(boostId, addDate, expirationDate, source);
    }
}
