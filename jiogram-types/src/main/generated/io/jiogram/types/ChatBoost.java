package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSource;
import java.util.Objects;

/**
 * This object contains information about a chat boost.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatboost">ChatBoost in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatBoost {

    @JsonProperty("boost_id")
    private final String boostId;

    @JsonProperty("add_date")
    private final long addDate;

    @JsonProperty("expiration_date")
    private final long expirationDate;

    @JsonProperty("source")
    private final ChatBoostSource source;

    /**
     * Creates a new {@code ChatBoost} instance.
     *
     * @param boostId Unique identifier of the boost
     * @param addDate Point in time (Unix timestamp) when the chat was boosted
     * @param expirationDate Point in time (Unix timestamp) when the boost will automatically
     *     expire, unless the booster's Telegram Premium subscription is prolonged
     * @param source Source of the added boost
     */
    @JsonCreator
    public ChatBoost(
            @JsonProperty("boost_id") String boostId,
            @JsonProperty("add_date") long addDate,
            @JsonProperty("expiration_date") long expirationDate,
            @JsonProperty("source") ChatBoostSource source) {
        this.boostId = boostId;
        this.addDate = addDate;
        this.expirationDate = expirationDate;
        this.source = source;
    }

    /**
     * Unique identifier of the boost
     */
    public String boostId() {
        return boostId;
    }

    /**
     * Point in time (Unix timestamp) when the chat was boosted
     */
    public long addDate() {
        return addDate;
    }

    /**
     * Point in time (Unix timestamp) when the boost will automatically expire, unless the booster's
     * Telegram Premium subscription is prolonged
     */
    public long expirationDate() {
        return expirationDate;
    }

    /**
     * Source of the added boost
     */
    public ChatBoostSource source() {
        return source;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatBoost)) {
            return false;
        }
        ChatBoost that = (ChatBoost) o;
        return Objects.equals(this.boostId, that.boostId)
                && this.addDate == that.addDate
                && this.expirationDate == that.expirationDate
                && Objects.equals(this.source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.boostId, this.addDate, this.expirationDate, this.source);
    }

    @Override
    public String toString() {
        return "ChatBoost[boostId=" + this.boostId
                + ", addDate=" + this.addDate
                + ", expirationDate=" + this.expirationDate
                + ", source=" + this.source
                + "]";
    }
}
