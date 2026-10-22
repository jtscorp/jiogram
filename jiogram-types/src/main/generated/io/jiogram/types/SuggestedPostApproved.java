package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.SuggestedPostPrice;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about the approval of a suggested post.
 *
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostapproved">SuggestedPostApproved in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SuggestedPostApproved {

    @JsonProperty("suggested_post_message")
    private final @Nullable Message suggestedPostMessage;

    @JsonProperty("price")
    private final @Nullable SuggestedPostPrice price;

    @JsonProperty("send_date")
    private final long sendDate;

    /**
     * Creates a new {@code SuggestedPostApproved} instance.
     *
     * @param suggestedPostMessage Message containing the suggested post. Note that the Message
     *     object in this field will not contain the reply_to_message field even if it itself is a
     *     reply.
     * @param price Amount paid for the post
     * @param sendDate Date when the post will be published
     */
    @JsonCreator
    public SuggestedPostApproved(
            @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
            @JsonProperty("price") @Nullable SuggestedPostPrice price,
            @JsonProperty("send_date") long sendDate) {
        this.suggestedPostMessage = suggestedPostMessage;
        this.price = price;
        this.sendDate = sendDate;
    }

    public static SuggestedPostApproved of(long sendDate) {
        return new SuggestedPostApproved(null, null, sendDate);
    }

    /**
     * Message containing the suggested post. Note that the Message object in this field will not
     * contain the reply_to_message field even if it itself is a reply.
     */
    public @Nullable Message suggestedPostMessage() {
        return suggestedPostMessage;
    }

    /**
     * Amount paid for the post
     */
    public @Nullable SuggestedPostPrice price() {
        return price;
    }

    /**
     * Date when the post will be published
     */
    public long sendDate() {
        return sendDate;
    }

    public SuggestedPostApproved withSuggestedPostMessage(@Nullable Message suggestedPostMessage) {
        return new SuggestedPostApproved(suggestedPostMessage, price, sendDate);
    }

    public SuggestedPostApproved withPrice(@Nullable SuggestedPostPrice price) {
        return new SuggestedPostApproved(suggestedPostMessage, price, sendDate);
    }

    public SuggestedPostApproved withSendDate(long sendDate) {
        return new SuggestedPostApproved(suggestedPostMessage, price, sendDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SuggestedPostApproved)) {
            return false;
        }
        SuggestedPostApproved that = (SuggestedPostApproved) o;
        return Objects.equals(this.suggestedPostMessage, that.suggestedPostMessage)
                && Objects.equals(this.price, that.price)
                && this.sendDate == that.sendDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.suggestedPostMessage, this.price, this.sendDate);
    }

    @Override
    public String toString() {
        return "SuggestedPostApproved[suggestedPostMessage=" + this.suggestedPostMessage
                + ", price=" + this.price
                + ", sendDate=" + this.sendDate
                + "]";
    }
}
