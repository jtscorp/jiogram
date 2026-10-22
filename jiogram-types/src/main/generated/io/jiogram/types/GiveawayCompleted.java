package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a service message about the completion of a giveaway without public
 * winners.
 *
 * @see <a href="https://core.telegram.org/bots/api#giveawaycompleted">GiveawayCompleted in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GiveawayCompleted {

    @JsonProperty("winner_count")
    private final long winnerCount;

    @JsonProperty("unclaimed_prize_count")
    private final @Nullable Long unclaimedPrizeCount;

    @JsonProperty("giveaway_message")
    private final @Nullable Message giveawayMessage;

    @JsonProperty("is_star_giveaway")
    private final @Nullable Boolean isStarGiveaway;

    /**
     * Creates a new {@code GiveawayCompleted} instance.
     *
     * @param winnerCount Number of winners in the giveaway
     * @param unclaimedPrizeCount Number of undistributed prizes
     * @param giveawayMessage Message with the giveaway that was completed, if it wasn't deleted
     * @param isStarGiveaway True, if the giveaway is a Telegram Star giveaway. Otherwise,
     *     currently, the giveaway is a Telegram Premium giveaway.
     */
    @JsonCreator
    public GiveawayCompleted(
            @JsonProperty("winner_count") long winnerCount,
            @JsonProperty("unclaimed_prize_count") @Nullable Long unclaimedPrizeCount,
            @JsonProperty("giveaway_message") @Nullable Message giveawayMessage,
            @JsonProperty("is_star_giveaway") @Nullable Boolean isStarGiveaway) {
        this.winnerCount = winnerCount;
        this.unclaimedPrizeCount = unclaimedPrizeCount;
        this.giveawayMessage = giveawayMessage;
        this.isStarGiveaway = isStarGiveaway;
    }

    public static GiveawayCompleted of(long winnerCount) {
        return new GiveawayCompleted(winnerCount, null, null, null);
    }

    /**
     * Number of winners in the giveaway
     */
    public long winnerCount() {
        return winnerCount;
    }

    /**
     * Number of undistributed prizes
     */
    public @Nullable Long unclaimedPrizeCount() {
        return unclaimedPrizeCount;
    }

    /**
     * Message with the giveaway that was completed, if it wasn't deleted
     */
    public @Nullable Message giveawayMessage() {
        return giveawayMessage;
    }

    /**
     * True, if the giveaway is a Telegram Star giveaway. Otherwise, currently, the giveaway is a
     * Telegram Premium giveaway.
     */
    public @Nullable Boolean isStarGiveaway() {
        return isStarGiveaway;
    }

    public GiveawayCompleted withWinnerCount(long winnerCount) {
        return new GiveawayCompleted(winnerCount, unclaimedPrizeCount, giveawayMessage, isStarGiveaway);
    }

    public GiveawayCompleted withUnclaimedPrizeCount(@Nullable Long unclaimedPrizeCount) {
        return new GiveawayCompleted(winnerCount, unclaimedPrizeCount, giveawayMessage, isStarGiveaway);
    }

    public GiveawayCompleted withGiveawayMessage(@Nullable Message giveawayMessage) {
        return new GiveawayCompleted(winnerCount, unclaimedPrizeCount, giveawayMessage, isStarGiveaway);
    }

    public GiveawayCompleted withIsStarGiveaway(@Nullable Boolean isStarGiveaway) {
        return new GiveawayCompleted(winnerCount, unclaimedPrizeCount, giveawayMessage, isStarGiveaway);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GiveawayCompleted)) {
            return false;
        }
        GiveawayCompleted that = (GiveawayCompleted) o;
        return this.winnerCount == that.winnerCount
                && Objects.equals(this.unclaimedPrizeCount, that.unclaimedPrizeCount)
                && Objects.equals(this.giveawayMessage, that.giveawayMessage)
                && Objects.equals(this.isStarGiveaway, that.isStarGiveaway);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.winnerCount, this.unclaimedPrizeCount, this.giveawayMessage, this.isStarGiveaway);
    }

    @Override
    public String toString() {
        return "GiveawayCompleted[winnerCount=" + this.winnerCount
                + ", unclaimedPrizeCount=" + this.unclaimedPrizeCount
                + ", giveawayMessage=" + this.giveawayMessage
                + ", isStarGiveaway=" + this.isStarGiveaway
                + "]";
    }
}
