package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents a service message about a user boosting a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatboostadded">ChatBoostAdded in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatBoostAdded {

    @JsonProperty("boost_count")
    private final long boostCount;

    /**
     * Creates a new {@code ChatBoostAdded} instance.
     *
     * @param boostCount Number of boosts added by the user
     */
    @JsonCreator
    public ChatBoostAdded(
            @JsonProperty("boost_count") long boostCount) {
        this.boostCount = boostCount;
    }

    /**
     * Number of boosts added by the user
     */
    public long boostCount() {
        return boostCount;
    }

    public ChatBoostAdded withBoostCount(long boostCount) {
        return new ChatBoostAdded(boostCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatBoostAdded)) {
            return false;
        }
        ChatBoostAdded that = (ChatBoostAdded) o;
        return this.boostCount == that.boostCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.boostCount);
    }

    @Override
    public String toString() {
        return "ChatBoostAdded[boostCount=" + this.boostCount
                + "]";
    }
}
