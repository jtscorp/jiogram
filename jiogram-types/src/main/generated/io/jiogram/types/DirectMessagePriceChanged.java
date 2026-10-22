package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about a change in the price of direct messages sent to a channel
 * chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#directmessagepricechanged">DirectMessagePriceChanged in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DirectMessagePriceChanged {

    @JsonProperty("are_direct_messages_enabled")
    private final boolean areDirectMessagesEnabled;

    @JsonProperty("direct_message_star_count")
    private final @Nullable Long directMessageStarCount;

    /**
     * Creates a new {@code DirectMessagePriceChanged} instance.
     *
     * @param areDirectMessagesEnabled True, if direct messages are enabled for the channel chat;
     *     false otherwise
     * @param directMessageStarCount The new number of Telegram Stars that must be paid by users for
     *     each direct message sent to the channel. Does not apply to users who have been exempted
     *     by administrators. Defaults to 0.
     */
    @JsonCreator
    public DirectMessagePriceChanged(
            @JsonProperty("are_direct_messages_enabled") boolean areDirectMessagesEnabled,
            @JsonProperty("direct_message_star_count") @Nullable Long directMessageStarCount) {
        this.areDirectMessagesEnabled = areDirectMessagesEnabled;
        this.directMessageStarCount = directMessageStarCount;
    }

    public static DirectMessagePriceChanged of(boolean areDirectMessagesEnabled) {
        return new DirectMessagePriceChanged(areDirectMessagesEnabled, null);
    }

    /**
     * True, if direct messages are enabled for the channel chat; false otherwise
     */
    public boolean areDirectMessagesEnabled() {
        return areDirectMessagesEnabled;
    }

    /**
     * The new number of Telegram Stars that must be paid by users for each direct message sent to
     * the channel. Does not apply to users who have been exempted by administrators. Defaults to 0.
     */
    public @Nullable Long directMessageStarCount() {
        return directMessageStarCount;
    }

    public DirectMessagePriceChanged withAreDirectMessagesEnabled(boolean areDirectMessagesEnabled) {
        return new DirectMessagePriceChanged(areDirectMessagesEnabled, directMessageStarCount);
    }

    public DirectMessagePriceChanged withDirectMessageStarCount(@Nullable Long directMessageStarCount) {
        return new DirectMessagePriceChanged(areDirectMessagesEnabled, directMessageStarCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DirectMessagePriceChanged)) {
            return false;
        }
        DirectMessagePriceChanged that = (DirectMessagePriceChanged) o;
        return this.areDirectMessagesEnabled == that.areDirectMessagesEnabled
                && Objects.equals(this.directMessageStarCount, that.directMessageStarCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.areDirectMessagesEnabled, this.directMessageStarCount);
    }

    @Override
    public String toString() {
        return "DirectMessagePriceChanged[areDirectMessagesEnabled=" + this.areDirectMessagesEnabled
                + ", directMessageStarCount=" + this.directMessageStarCount
                + "]";
    }
}
