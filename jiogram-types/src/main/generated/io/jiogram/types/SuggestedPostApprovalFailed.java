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
 * Describes a service message about the failed approval of a suggested post. Currently, only caused
 * by insufficient user funds at the time of approval.
 *
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostapprovalfailed">SuggestedPostApprovalFailed in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SuggestedPostApprovalFailed {

    @JsonProperty("suggested_post_message")
    private final @Nullable Message suggestedPostMessage;

    @JsonProperty("price")
    private final SuggestedPostPrice price;

    /**
     * Creates a new {@code SuggestedPostApprovalFailed} instance.
     *
     * @param suggestedPostMessage Message containing the suggested post whose approval has failed.
     *     Note that the Message object in this field will not contain the reply_to_message field
     *     even if it itself is a reply.
     * @param price Expected price of the post
     */
    @JsonCreator
    public SuggestedPostApprovalFailed(
            @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
            @JsonProperty("price") SuggestedPostPrice price) {
        this.suggestedPostMessage = suggestedPostMessage;
        this.price = price;
    }

    public static SuggestedPostApprovalFailed of(SuggestedPostPrice price) {
        return new SuggestedPostApprovalFailed(null, price);
    }

    /**
     * Message containing the suggested post whose approval has failed. Note that the Message object
     * in this field will not contain the reply_to_message field even if it itself is a reply.
     */
    public @Nullable Message suggestedPostMessage() {
        return suggestedPostMessage;
    }

    /**
     * Expected price of the post
     */
    public SuggestedPostPrice price() {
        return price;
    }

    public SuggestedPostApprovalFailed withSuggestedPostMessage(@Nullable Message suggestedPostMessage) {
        return new SuggestedPostApprovalFailed(suggestedPostMessage, price);
    }

    public SuggestedPostApprovalFailed withPrice(SuggestedPostPrice price) {
        return new SuggestedPostApprovalFailed(suggestedPostMessage, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SuggestedPostApprovalFailed)) {
            return false;
        }
        SuggestedPostApprovalFailed that = (SuggestedPostApprovalFailed) o;
        return Objects.equals(this.suggestedPostMessage, that.suggestedPostMessage)
                && Objects.equals(this.price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.suggestedPostMessage, this.price);
    }

    @Override
    public String toString() {
        return "SuggestedPostApprovalFailed[suggestedPostMessage=" + this.suggestedPostMessage
                + ", price=" + this.price
                + "]";
    }
}
