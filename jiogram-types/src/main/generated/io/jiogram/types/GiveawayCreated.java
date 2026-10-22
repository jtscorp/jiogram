package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a service message about the creation of a scheduled giveaway.
 *
 * @see <a href="https://core.telegram.org/bots/api#giveawaycreated">GiveawayCreated in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GiveawayCreated {

    @JsonProperty("prize_star_count")
    private final @Nullable Long prizeStarCount;

    /**
     * Creates a new {@code GiveawayCreated} instance.
     *
     * @param prizeStarCount The number of Telegram Stars to be split between giveaway winners; for
     *     Telegram Star giveaways only
     */
    @JsonCreator
    public GiveawayCreated(
            @JsonProperty("prize_star_count") @Nullable Long prizeStarCount) {
        this.prizeStarCount = prizeStarCount;
    }

    public static GiveawayCreated of() {
        return new GiveawayCreated(null);
    }

    /**
     * The number of Telegram Stars to be split between giveaway winners; for Telegram Star
     * giveaways only
     */
    public @Nullable Long prizeStarCount() {
        return prizeStarCount;
    }

    public GiveawayCreated withPrizeStarCount(@Nullable Long prizeStarCount) {
        return new GiveawayCreated(prizeStarCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GiveawayCreated)) {
            return false;
        }
        GiveawayCreated that = (GiveawayCreated) o;
        return Objects.equals(this.prizeStarCount, that.prizeStarCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.prizeStarCount);
    }

    @Override
    public String toString() {
        return "GiveawayCreated[prizeStarCount=" + this.prizeStarCount
                + "]";
    }
}
