package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSourceType;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * The boost was obtained by the creation of a Telegram Premium or a Telegram Star giveaway. This
 * boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription for
 * Telegram Premium giveaways and prize_star_count / 500 times for one year for Telegram Star
 * giveaways.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatboostsourcegiveaway">ChatBoostSourceGiveaway in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatBoostSourceGiveaway implements ChatBoostSource {

    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY)
    private final ChatBoostSourceType source;

    @JsonProperty("giveaway_message_id")
    private final long giveawayMessageId;

    @JsonProperty("user")
    private final @Nullable User user;

    @JsonProperty("prize_star_count")
    private final @Nullable Long prizeStarCount;

    @JsonProperty("is_unclaimed")
    private final @Nullable Boolean isUnclaimed;

    /**
     * Creates a new {@code ChatBoostSourceGiveaway} instance.
     *
     * @param source Source of the boost, always 'giveaway'
     * @param giveawayMessageId Identifier of a message in the chat with the giveaway; the message
     *     could have been deleted already. May be 0 if the message isn't sent yet.
     * @param user User that won the prize in the giveaway if any; for Telegram Premium giveaways
     *     only
     * @param prizeStarCount The number of Telegram Stars to be split between giveaway winners; for
     *     Telegram Star giveaways only
     * @param isUnclaimed True, if the giveaway was completed, but there was no user to win the
     *     prize
     */
    @JsonCreator
    public ChatBoostSourceGiveaway(
            @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) ChatBoostSourceType source,
            @JsonProperty("giveaway_message_id") long giveawayMessageId,
            @JsonProperty("user") @Nullable User user,
            @JsonProperty("prize_star_count") @Nullable Long prizeStarCount,
            @JsonProperty("is_unclaimed") @Nullable Boolean isUnclaimed) {
        this.source = source;
        this.giveawayMessageId = giveawayMessageId;
        this.user = user;
        this.prizeStarCount = prizeStarCount;
        this.isUnclaimed = isUnclaimed;
    }

    public static ChatBoostSourceGiveaway of(long giveawayMessageId) {
        return new ChatBoostSourceGiveaway(ChatBoostSourceType.GIVEAWAY, giveawayMessageId, null, null, null);
    }

    /**
     * Source of the boost, always 'giveaway'
     */
    public ChatBoostSourceType source() {
        return source;
    }

    /**
     * Identifier of a message in the chat with the giveaway; the message could have been deleted
     * already. May be 0 if the message isn't sent yet.
     */
    public long giveawayMessageId() {
        return giveawayMessageId;
    }

    /**
     * User that won the prize in the giveaway if any; for Telegram Premium giveaways only
     */
    public @Nullable User user() {
        return user;
    }

    /**
     * The number of Telegram Stars to be split between giveaway winners; for Telegram Star
     * giveaways only
     */
    public @Nullable Long prizeStarCount() {
        return prizeStarCount;
    }

    /**
     * True, if the giveaway was completed, but there was no user to win the prize
     */
    public @Nullable Boolean isUnclaimed() {
        return isUnclaimed;
    }

    public ChatBoostSourceGiveaway withGiveawayMessageId(long giveawayMessageId) {
        return new ChatBoostSourceGiveaway(source, giveawayMessageId, user, prizeStarCount, isUnclaimed);
    }

    public ChatBoostSourceGiveaway withUser(@Nullable User user) {
        return new ChatBoostSourceGiveaway(source, giveawayMessageId, user, prizeStarCount, isUnclaimed);
    }

    public ChatBoostSourceGiveaway withPrizeStarCount(@Nullable Long prizeStarCount) {
        return new ChatBoostSourceGiveaway(source, giveawayMessageId, user, prizeStarCount, isUnclaimed);
    }

    public ChatBoostSourceGiveaway withIsUnclaimed(@Nullable Boolean isUnclaimed) {
        return new ChatBoostSourceGiveaway(source, giveawayMessageId, user, prizeStarCount, isUnclaimed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatBoostSourceGiveaway)) {
            return false;
        }
        ChatBoostSourceGiveaway that = (ChatBoostSourceGiveaway) o;
        return Objects.equals(this.source, that.source)
                && this.giveawayMessageId == that.giveawayMessageId
                && Objects.equals(this.user, that.user)
                && Objects.equals(this.prizeStarCount, that.prizeStarCount)
                && Objects.equals(this.isUnclaimed, that.isUnclaimed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.source, this.giveawayMessageId, this.user, this.prizeStarCount, this.isUnclaimed);
    }

    @Override
    public String toString() {
        return "ChatBoostSourceGiveaway[source=" + this.source
                + ", giveawayMessageId=" + this.giveawayMessageId
                + ", user=" + this.user
                + ", prizeStarCount=" + this.prizeStarCount
                + ", isUnclaimed=" + this.isUnclaimed
                + "]";
    }
}
