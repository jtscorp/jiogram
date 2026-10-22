package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about a payment refund for a suggested post.
 *
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostrefunded">SuggestedPostRefunded in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SuggestedPostRefunded {

    @JsonProperty("suggested_post_message")
    private final @Nullable Message suggestedPostMessage;

    @JsonProperty("reason")
    private final String reason;

    /**
     * Creates a new {@code SuggestedPostRefunded} instance.
     *
     * @param suggestedPostMessage Message containing the suggested post. Note that the Message
     *     object in this field will not contain the reply_to_message field even if it itself is a
     *     reply.
     * @param reason Reason for the refund. Currently, one of 'post_deleted' if the post was deleted
     *     within 24 hours of being posted or removed from scheduled messages without being posted,
     *     or 'payment_refunded' if the payer refunded their payment.
     */
    @JsonCreator
    public SuggestedPostRefunded(
            @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
            @JsonProperty("reason") String reason) {
        this.suggestedPostMessage = suggestedPostMessage;
        this.reason = reason;
    }

    public static SuggestedPostRefunded of(String reason) {
        return new SuggestedPostRefunded(null, reason);
    }

    /**
     * Message containing the suggested post. Note that the Message object in this field will not
     * contain the reply_to_message field even if it itself is a reply.
     */
    public @Nullable Message suggestedPostMessage() {
        return suggestedPostMessage;
    }

    /**
     * Reason for the refund. Currently, one of 'post_deleted' if the post was deleted within 24
     * hours of being posted or removed from scheduled messages without being posted, or
     * 'payment_refunded' if the payer refunded their payment.
     */
    public String reason() {
        return reason;
    }

    public SuggestedPostRefunded withSuggestedPostMessage(@Nullable Message suggestedPostMessage) {
        return new SuggestedPostRefunded(suggestedPostMessage, reason);
    }

    public SuggestedPostRefunded withReason(String reason) {
        return new SuggestedPostRefunded(suggestedPostMessage, reason);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SuggestedPostRefunded)) {
            return false;
        }
        SuggestedPostRefunded that = (SuggestedPostRefunded) o;
        return Objects.equals(this.suggestedPostMessage, that.suggestedPostMessage)
                && Objects.equals(this.reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.suggestedPostMessage, this.reason);
    }

    @Override
    public String toString() {
        return "SuggestedPostRefunded[suggestedPostMessage=" + this.suggestedPostMessage
                + ", reason=" + this.reason
                + "]";
    }
}
